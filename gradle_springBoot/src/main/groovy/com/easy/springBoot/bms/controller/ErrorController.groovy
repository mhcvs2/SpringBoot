package com.easy.springBoot.bms.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class ErrorController {

    @GetMapping("/404")
    Object CustomNotFound(){
        "error/404"
    }
}
