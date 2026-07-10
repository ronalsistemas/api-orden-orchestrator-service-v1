package com.rcasani.client.ordenes.httpexchange;

import com.rcasani.client.ordenes.restclient.dto.CrearOrdenRequest;
import com.rcasani.client.ordenes.restclient.dto.CrearOrdenResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange
public interface OrdenServiceV1HttpExchangeClient {

    @PostExchange
    CrearOrdenResponse crear(@RequestBody CrearOrdenRequest request);
}
