package com.mhc.spring_cloud.example.ui.service;

import com.mhc.spring_cloud.example.ui.domain.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient("person")
public interface PersonService {

    @RequestMapping(method = RequestMethod.POST, value = "/save",
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody List<Person> save(@RequestBody String name);
}
