package com.mhc.user.service.impl;

import com.mhc.user.service.IUserService;
import com.mhc.user.service.dataservice.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private DataService dataService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getDefaultUser() {
        return dataService.getDefaultUser();
    }

    @Override
    public String getContextUserId() {
        return dataService.getContextUserId();
    }

    @Override
    public List<String> getProviderData() {
        List<String> result = restTemplate.getForObject("http://mhc-data-service/getProviderData", List.class);
        return result;
    }
}
