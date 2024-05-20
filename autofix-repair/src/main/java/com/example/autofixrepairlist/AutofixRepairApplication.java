package com.example.autofixrepairlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AutofixRepairApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutofixRepairApplication.class, args);
    }

}
