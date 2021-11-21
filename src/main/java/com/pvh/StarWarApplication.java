package com.pvh;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Main class from where execution starts
 */
@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition
public class StarWarApplication {
    /**
     * main method from where execution starts
     * @param args args
     */
    public static void main(String[] args) {
        SpringApplication.run(StarWarApplication.class, args);
    }
}
