package com.rcasani.service;

import com.rcasani.client.farmacias.FarmaciaServiceV1WebClient;
import com.rcasani.controller.dto.CrearOrdenOrchestratorRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FarmaciaService {

    private final FarmaciaServiceV1WebClient farmaciaClient;

    public void reservaFarmacia(UUID ordenId, CrearOrdenOrchestratorRequest crearOrdenRequest) {
        farmaciaClient.reservarOrden(ordenId, crearOrdenRequest);
    }
}
