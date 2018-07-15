package com.mhc.todo.api2.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class WebController {

    @GetMapping("/")
    String index() {
        "index.html"
    }

    @GetMapping("/{action:todo|login}")   //可以写正则表达式
    String todo() {
        "index.html"
    }

}
