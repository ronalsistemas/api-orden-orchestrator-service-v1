package com.rcasani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiOrdenOrchestratorServiceV1Application {

    public static void main(String[] args) {
        SpringApplication.run(ApiOrdenOrchestratorServiceV1Application.class, args);
    }

}
