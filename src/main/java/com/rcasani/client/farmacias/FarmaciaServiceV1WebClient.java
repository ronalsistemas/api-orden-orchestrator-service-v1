package com.rcasani.client.farmacias;

import com.rcasani.client.farmacias.dto.OrdenListaRequest;
import com.rcasani.client.farmacias.dto.ReservaOrdenRequest;
import com.rcasani.client.farmacias.dto.ReservaOrdenResponse;
import com.rcasani.controller.dto.CrearOrdenOrchestratorRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Slf4j
@Component
@AllArgsConstructor
public class FarmaciaServiceV1WebClient {

    private final WebClient farmaciaWebClient;

    public ReservaOrdenResponse reservarOrden(UUID orderId, CrearOrdenOrchestratorRequest orchestratorRequest) {
        log.info("WebClient - Reserving order at restaurant: {}", orchestratorRequest.farmacia().nombre());

        ReservaOrdenRequest request = new ReservaOrdenRequest(
                orderId,
                orchestratorRequest.farmacia().id(),
                orchestratorRequest.cliente().id(),
                orchestratorRequest.items()
                        .stream()
                        .map(item -> new OrdenListaRequest(
                                item.producto().id(),
                                item.producto().nombre(),
                                item.cantidad(),
                                item.descripcion()
                        ))
                        .toList()
        );

        return farmaciaWebClient.post()
                .uri("/{farmaciaId}/ordenes/reserva", orchestratorRequest.farmacia().id())
                //.header("Content-Type", "application/json")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(ReservaOrdenResponse.class)
                .block();
    }
}
