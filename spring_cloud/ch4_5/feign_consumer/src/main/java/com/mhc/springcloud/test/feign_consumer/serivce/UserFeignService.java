package com.mhc.springcloud.test.feign_consumer.serivce;

import com.mhc.springcloud.test.feign_consumer.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ch4-5-provider")
public interface UserFeignService {

    @RequestMapping(value = "/user/add", method = RequestMethod.GET, consumes= MediaType.APPLICATION_JSON_VALUE)
    public String addUser(User user);

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String updateUser(@RequestBody User user);
}
