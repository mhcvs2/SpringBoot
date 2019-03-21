package com.mhc.validator_test.controller;

import com.mhc.validator_test.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@RestController
@Validated
@Slf4j
@RequestMapping("/t1")
public class Test1Controller {

    // @Future 限制是将来的日期
    @GetMapping("/1")
    public String t1(@Size(min = 1, max = 10, message = "姓名长度必须为1-10")@RequestParam("name") String name,
                     @Min(value = 10, message = "年龄最小为10")@Max(value = 100, message = "年龄最大为100")@RequestParam("age") Integer age,
                     @Future(message = "出生日期必须是将来的时间") @RequestParam("birth")@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")Date birth){
        log.info("name: {}, age: {}, birth: {}", name, age, birth);
        return "t1";
    }

    @PostMapping("/2")
    public User t2(@Valid @RequestBody User user){
        if(user.getAge() != null) {
            user.setAge(user.getAge()+1);
        }
        return user;
    }

}
