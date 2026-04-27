package com.rcasani.client.ordenes.restclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class OrdenRestClientConfig {

    @Bean
    public RestClient.Builder getRestClientBuilder() {
        return RestClient.builder();
    }

    @Bean
    public RestClient ordenRestClient(RestClient.Builder restClientBuilder) {
        return restClientBuilder.clone().baseUrl("http://localhost:40011/api/v1").build();
    }
}
