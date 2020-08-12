package com.itmk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * web启动类
 */
@SpringBootApplication
@EnableCaching
@ComponentScan("com.itmk.system.service")
@ComponentScan("com.itmk.system.controller")
@MapperScan("com.itmk.system.mapper")
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
    }
}
