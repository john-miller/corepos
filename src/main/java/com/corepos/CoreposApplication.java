package com.corepos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.corepos")
public class CoreposApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreposApplication.class, args);
    }
}
