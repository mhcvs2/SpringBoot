package com.mhc.kerberos_test.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.Asserts;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HttpClientUtils {

    /**
     * get方式下载文件
     *
     * @param url
     * @param dir
     * @param defaultFileName
     * @return
     * @throws IOException
     */
    public static String downloadFile(String url, String dir, String defaultFileName) throws IOException {
        Asserts.notBlank(url, "url is null!");
        Asserts.notBlank(dir, "dir is null!");

        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        InputStream in = entity.getContent();

        String fileName = getFileName(response);
        if (StringUtils.isBlank(fileName)) {
            fileName = defaultFileName;
        }
        File file = new File(dir + File.separator + fileName);
        FileOutputStream out = new FileOutputStream(file);
        IOUtils.write(in, out, 1024);
        IOUtils.closeQuietly(in, out);
        return file.getAbsolutePath();
    }

    private static String getFileName(HttpResponse response) {
        Header contentHeader = response.getFirstHeader("Content-Disposition");
        if (contentHeader != null) {
            HeaderElement[] elements = contentHeader.getElements();
            if (elements.length != 1) {
                return null;
            }

            NameValuePair element = elements[0].getParameterByName("filename");
            if (element == null) {
                return null;
            }

            return element.getValue();
        }

        return null;
    }

}

