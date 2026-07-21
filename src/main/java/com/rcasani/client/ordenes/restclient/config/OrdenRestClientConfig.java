package com.rcasani.client.ordenes.restclient.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class OrdenRestClientConfig {

    @Bean
    public RestClient ordenRestClient(
            @Value("${http-clients.internal.api-orden-service-v1.base-url}")
            String baseUrl,
            @Qualifier("loadBalancedRestClientBuilder")
            RestClient.Builder restClientBuilder) {
        return restClientBuilder.clone().baseUrl(baseUrl).build();
    }
}
