package com.example.employeetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EmployeeTestApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeTestApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder SpringApplication) {
        return SpringApplication.sources(EmployeeTestApplication.class);
    }

}
