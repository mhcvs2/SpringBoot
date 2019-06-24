package com.mhc.dataservice.controller;

import com.mhc.common.context.UserContextHolder;
import com.mhc.dataservice.config.DataConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class DataController {

    @Autowired
    private DataConfig dataConfig;

    @GetMapping("/getContextUserId")
    public String getContextUserId(){
        log.info("getContextUserId=====================");
        return UserContextHolder.currentUser().getUserId();
    }

    @GetMapping("/getDefaultUser")
    public String getDefaultUser(){
        log.info("getDefaultUser==================");
        return dataConfig.getDefaultUser();
    }

    @GetMapping("/getProviderData")
    public List<String> getProviderData(){
        log.info("getProviderData==================");
        List<String> provider = new ArrayList<String>();
        provider.add("Beijing Company");
        provider.add("Shanghai Company");
        provider.add("Shenzhen Company");
        return provider;
    }

}
