package com.rcasani.client.pagos.restclient.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class PagoRestClientConfig {

    @Bean
    public RestClient paymentsV1RestClient(
            @Value("${http-clients.internal.api-pago-service-v1.base-url}")
            String baseUrl,
            @Qualifier("loadBalancedRestClientBuilder") //Indicamos que use el cliente con LoadBalancer para resuelva por los nombres de servicio de eureka
            RestClient.Builder restClientBuilder) {
        return restClientBuilder.clone().baseUrl(baseUrl).build();
    }

    @Bean
    public RestClient paymentsV2RestClient(
            @Value("${http-clients.internal.api-pago-service-v2.base-url}")
            String baseUrl,
            @Qualifier("loadBalancedRestClientBuilder") //Indicamos que use el cliente con LoadBalancer para resuelva por los nombres de servicio de eureka
            RestClient.Builder restClientBuilder) {
        return restClientBuilder.clone().baseUrl(baseUrl).build();
    }
}
