package com.obs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.obs"}) 
public class ObsApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ObsApiApplication.class, args);
    }
}
