package com.rcasani.client.ordenes.restclient;

import com.rcasani.client.ordenes.OrdenServiceV1Client;
import com.rcasani.client.ordenes.restclient.dto.ClienteRequest;
import com.rcasani.client.ordenes.restclient.dto.CrearOrdenRequest;
import com.rcasani.client.ordenes.restclient.dto.CrearOrdenResponse;
import com.rcasani.client.ordenes.restclient.dto.FarmaciaRequest;
import com.rcasani.controller.dto.CrearOrdenOrchestratorRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
@AllArgsConstructor
@Profile("RestClient")
public class OrdenServiceV1RestClient implements OrdenServiceV1Client {

    private final RestClient ordenRestClient;

    public CrearOrdenResponse crearOrden(CrearOrdenOrchestratorRequest crearOrdenOrchestratorRequest) {
        log.info("RestClient - Creando pedido para el cliente: {}", crearOrdenOrchestratorRequest.cliente().nombre());

        CrearOrdenRequest request = new CrearOrdenRequest(
                new ClienteRequest(crearOrdenOrchestratorRequest.cliente().id(), crearOrdenOrchestratorRequest.cliente().nombre()),
                new FarmaciaRequest(crearOrdenOrchestratorRequest.farmacia().id(), crearOrdenOrchestratorRequest.farmacia().nombre()),
                crearOrdenOrchestratorRequest.total()
        );

        //return ordenRestClient.post().uri("/ordenes")
        return ordenRestClient.post()
                .body(request)
                .retrieve()
                .body(CrearOrdenResponse.class);
    }
}
