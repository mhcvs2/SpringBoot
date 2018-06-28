因为spring boot2.0与spring boot 1.5有这很大区别，而网上关于使用RabbitMq的教程大都使用spring boot1.5，所有在使用spring boot2.0时网上的教程多数不起作用。以下是主spring boot2.0相较于spring boot1.5主要改变

    首先在屏蔽安全验证的代码在1.5中应该

[java] view plain copy

    management:  
      security:  
        enable: false  

而在2.0中应该是
[html] view plain copy

    management:  
      endpoints:  
        web:  
          exposure:  
            include: bus-refresh  

在和config cilent服务的配置文件中加上上述配置代码屏蔽安全验证；

2.其次，在config server段除了需要导入amqp的启动依赖，还需要actuator的启动依赖。pom代码如下
[html] view plain copy

    <dependency>  
               <groupId>org.springframework.boot</groupId>  
               <artifactId>spring-boot-starter-actuator</artifactId>  
           </dependency>  
           <dependency>  
               <groupId>org.springframework.cloud</groupId>  
               <artifactId>spring-cloud-starter-bus-amqp</artifactId>  
           </dependency>  

3.最后在想config client服务发送post请求时，用http://localhost:8762/actuator/bus-refresh替换http://localhost:8762/bus/refresh，如果使用http://localhost:8762/bus/refresh会返回404错误