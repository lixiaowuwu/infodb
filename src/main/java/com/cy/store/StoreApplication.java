package com.cy.store;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.cy.store.mapper")
public class StoreApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }
}
