package com.rcasani.service;

import com.rcasani.client.ordenes.OrdenServiceV1Client;
import com.rcasani.client.ordenes.restclient.dto.CrearOrdenResponse;
import com.rcasani.controller.dto.CrearOrdenOrchestratorRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrdenService {

    private final OrdenServiceV1Client ordenServiceV1Client;

    public CrearOrdenResponse crearOrden(CrearOrdenOrchestratorRequest orchestratorRequest) {
        return ordenServiceV1Client.crearOrden(orchestratorRequest);
    }
}
