package com.kaikanwu.cafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = {
        "com.kaikanwu.cafe.interfaces",
        "com.kaikanwu.cafe.domain",
        "com.kaikanwu.cafe.application",
        "com.kaikanwu.cafe.infrastructure"})
public class CafeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CafeApplication.class, args);
    }
}
