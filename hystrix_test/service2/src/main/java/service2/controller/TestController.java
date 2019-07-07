package service2.controller;

import org.springframework.web.bind.annotation.*;
import com.mhc.test.hystrix.common.model.User;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/t1/{id}")
    public User getUser(@PathVariable Integer id){
        User user = new User();
        user.setId(id);
        user.setName("mhc");
        return user;
    }

    @PostMapping("/t1")
    public String addUser(@RequestBody User user) {
        return user.toString();
    }

}
