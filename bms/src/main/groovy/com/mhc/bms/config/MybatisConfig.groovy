package com.mhc.bms.config

import org.mybatis.spring.boot.autoconfigure.MybatisProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class MybatisConfig {

    @Bean
    @Primary
    MybatisProperties mybatisProperties() {
        MybatisProperties p = new MybatisProperties()
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration()
        // 开启mybatis开启数据库字段自动映射驼峰命名规则java属性
        config.mapUnderscoreToCamelCase = true
        p.configuration = config

        p

    }
}
