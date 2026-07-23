package com.rcasani.client.ordenes.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;

@Configuration
public class OrdenRestClientBaseConfig {

    //Usamos @LoadBalanced para que esta RestClient.Builder pueda resolver nombres de servicios registrados en Eureka
    @Bean("loadBalancedRestClientBuilder")
    @LoadBalanced
    public RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }

    //Usamos @Primary para que esta sea la que se inyecte por defecto al cliente de Eureka
    @Primary
    @Bean
    public RestClient.Builder cleanRestClientBuilder() {
        return RestClient.builder();
    }
}
