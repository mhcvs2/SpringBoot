package com.example.gradle_config_client

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RefreshScope
@RestController
class GradleConfigClientApplication {

	static void main(String[] args) {
		SpringApplication.run GradleConfigClientApplication, args
	}

	@Value('${foo}')
	String foo

	@RequestMapping(value = "/hi")
	public String hi(){
		return foo
	}

}
