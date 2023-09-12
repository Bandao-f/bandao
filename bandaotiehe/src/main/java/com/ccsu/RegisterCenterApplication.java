package com.ccsu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ccsu.dal")
public class RegisterCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegisterCenterApplication.class);
    }
}
