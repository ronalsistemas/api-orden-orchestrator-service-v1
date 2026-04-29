package com.rcasani.client.ordenes.httpexchange.config;

import com.rcasani.client.ordenes.httpexchange.OrdenServiceV1HttpExchangeClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ExchangeHttpClientConfig {

    @Bean
    public RestClient ordenServiceV1HttpExchangeRestClient(RestClient.Builder restClientBuilder) {
        return restClientBuilder
                .clone()
                .baseUrl("http://localhost:40011/api")
                .build();
    }

    @Bean
    public OrdenServiceV1HttpExchangeClient ordenServiceV1HttpExchangeClientFactory(RestClient ordenServiceV1HttpExchangeRestClient) {
        return HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(ordenServiceV1HttpExchangeRestClient))
                .build()
                .createClient(OrdenServiceV1HttpExchangeClient.class);
    }
}
