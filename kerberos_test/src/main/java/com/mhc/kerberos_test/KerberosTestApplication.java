package com.mhc.kerberos_test;

import com.mhc.kerberos_test.config.KerberosConfig;
import com.mhc.kerberos_test.utils.HttpClientUtils;
import com.mhc.kerberos_test.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.security.UserGroupInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.net.URI;
import java.text.MessageFormat;

@SpringBootApplication
@Slf4j
public class KerberosTestApplication implements CommandLineRunner {

    @Autowired
    KerberosConfig kerberosConfig;

    public static void main(String[] args) {
        SpringApplication.run(KerberosTestApplication.class, args);
    }

    private String getKeytabFile(String tenant, String kdcHost) {
        if(StringUtils.isBlank(kdcHost)) {
            return null;
        }
        String fileName = tenant + ".keytab";
        String dir = kerberosConfig.getLocation() + File.separator + kdcHost;
        String filePath = dir + File.separator + fileName;
        File file = new File(filePath);
        log.info("filePath: {}", filePath);
        if (file.exists()) {
            return filePath;
        }
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        log.info("file not exist");
        String url = MessageFormat.format(kerberosConfig.getUrl(), tenant, kdcHost);
        log.info("format url: {}", url);
        try {
            return HttpClientUtils.downloadFile(url, dir, fileName);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void run(String... args) throws Exception {
        Configuration conf = new Configuration();
        if(!StringUtils.isBlank(kerberosConfig.getHadoopDir())) {
            System.setProperty("hadoop.home.dir", kerberosConfig.getHadoopDir());
        }
        if(!StringUtils.isBlank(kerberosConfig.getKrb5())) {
            log.info("set java.security.krb5.conf={}", kerberosConfig.getKrb5());
            System.setProperty("java.security.krb5.conf", kerberosConfig.getKrb5());
        }
        String user = kerberosConfig.getTenant();
        String keyPath = kerberosConfig.getKeyPath();
        if(StringUtils.isBlank(keyPath)){
            keyPath = getKeytabFile(user, kerberosConfig.getKdcServerName());
        }
        String userMd5 = kerberosConfig.getUserMd5();
        if(keyPath != null) {
            if(!StringUtils.isBlank(kerberosConfig.getHadoopConfPath())){
                conf.addResource(new org.apache.hadoop.fs.Path(kerberosConfig.getHadoopConfPath(), "core-site.xml"));
                conf.addResource(new org.apache.hadoop.fs.Path(kerberosConfig.getHadoopConfPath(), "hdfs-site.xml"));
            } else {
                log.info("add  props:");
                kerberosConfig.getProps().forEach(it -> {
                    log.info("{} = {}", it.getK(), it.getV());
                    conf.set(it.getK(), it.getV());
                });
            }


            if(StringUtils.isBlank(userMd5)){
                userMd5 = MD5Util.MD5(user);
            }
            log.info("key path: {}", keyPath);
            UserGroupInformation.setConfiguration(conf);
            log.info("user is {}, md5: {}", user, userMd5);
            log.info("login with user: {}, keyPath: {}...", userMd5, keyPath);
            UserGroupInformation.loginUserFromKeytab(userMd5, keyPath);
        } else {
            userMd5 = "hdfs";
        }
        conf.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        log.info("hdfs url: {}", kerberosConfig.getHdfsUrl());
        FileSystem fs;
        if(kerberosConfig.getAddUser()) {
            String opUser = kerberosConfig.getOpUser();
            if(StringUtils.isBlank(opUser)){
                opUser = userMd5;
            }
            fs = FileSystem.get(URI.create(kerberosConfig.getHdfsUrl()), conf, opUser);
        } else {
            fs = FileSystem.get(URI.create(kerberosConfig.getHdfsUrl()), conf);
        }
        log.info("fs: {}", fs.toString());
        log.info("ls all file in \"/\":");
        FileStatus files[] = fs.listStatus(new Path("/"));
        for (FileStatus file : files) {
            System.out.println(file.getPath());
        }
    }
}
