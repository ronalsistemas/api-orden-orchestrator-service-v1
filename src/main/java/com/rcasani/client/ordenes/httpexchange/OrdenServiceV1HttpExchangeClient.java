package com.rcasani.client.ordenes.httpexchange;

import com.rcasani.client.ordenes.restclient.dto.CrearOrdenRequest;
import com.rcasani.client.ordenes.restclient.dto.CrearOrdenResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/v1")
public interface OrdenServiceV1HttpExchangeClient {

    @PostMapping("/ordenes")
    CrearOrdenResponse crear(@RequestBody CrearOrdenRequest request);
}
