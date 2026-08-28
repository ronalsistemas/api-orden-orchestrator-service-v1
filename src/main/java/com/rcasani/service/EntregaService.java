package com.rcasani.service;

import com.rcasani.client.entrega.EntregaServiceV1RestClient;
import com.rcasani.client.entrega.dto.EntregaResponse;
import com.rcasani.controller.dto.CrearOrdenOrchestratorRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class EntregaService {

    private final EntregaServiceV1RestClient client;

    public EntregaResponse asignarConductor(UUID ordenId, CrearOrdenOrchestratorRequest crearOrdenRequest) {
        log.info("Asignación de conductor para ID de pedido: {}", ordenId);
        return client.asignarConductor(ordenId, crearOrdenRequest);
    }

    public void iniciarEntrega(UUID ordenId) {
        client.iniciarEntrega(ordenId);
    }

    public void entregaCompleta(UUID ordenId) {
        client.entregaCompleta(ordenId);
    }
}
