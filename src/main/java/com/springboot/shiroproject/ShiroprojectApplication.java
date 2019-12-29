package com.springboot.shiroproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot.shiroproject.mapper")
public class ShiroprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroprojectApplication.class, args);
    }

}
