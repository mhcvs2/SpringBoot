package com.mhc.user.controller;


import com.mhc.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 
 */
@Slf4j
@RestController
public class UserController {

	@Autowired
	private IUserService userService;
	
	/**
	 * 获取配置文件中系统默认用户
	 * @return
	 */
    @GetMapping("/getDefaultUser")
    public String getDefaultUser(){
        log.info("getDefaultUser=========================");
        return userService.getDefaultUser();
    }
    
    /**
     * 获取上下文用户
     * @return
     */
    @GetMapping("/getContextUserId")
    public String getContextUserId(){
        return userService.getContextUserId();
    }
    
    /**
     * 获取供应商数据
     * @return
     */
    @GetMapping("/getProviderData")
    public List<String> getProviderData(){
        return userService.getProviderData();
    }
}
