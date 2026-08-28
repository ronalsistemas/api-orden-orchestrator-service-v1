package com.rcasani.client.entrega;

import com.rcasani.client.entrega.dto.AsignarConductorRequest;
import com.rcasani.client.entrega.dto.EntregaDireccionRequest;
import com.rcasani.client.entrega.dto.EntregaPersonaRequest;
import com.rcasani.client.entrega.dto.EntregaResponse;
import com.rcasani.controller.dto.CrearOrdenOrchestratorRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@Slf4j
@Component
@AllArgsConstructor
public class EntregaServiceV1RestClient {

    private final RestClient entregaRestClient;

    public EntregaResponse asignarConductor(UUID ordenId, CrearOrdenOrchestratorRequest crearOrdenRequest) {
        AsignarConductorRequest asignarConductorRequest = new AsignarConductorRequest(
                ordenId,
                new EntregaDireccionRequest(
                        crearOrdenRequest.direccionEntrega().direccion(),
                        crearOrdenRequest.direccionEntrega().referencia()
                ),
                new EntregaPersonaRequest(
                        crearOrdenRequest.repartidor().id()
                )
        );

        return entregaRestClient.post()
                .uri("/asignar-conductor")
                .body(asignarConductorRequest)
                .retrieve()
                .body(EntregaResponse.class);
    }

    public void iniciarEntrega(UUID ordenId) {
        entregaRestClient.post()
                .uri("/{ordenId}/iniciar", ordenId)
                .retrieve()
                .toBodilessEntity();
    }

    public void entregaCompleta(UUID ordenId) {
        entregaRestClient.post()
                .uri("/{ordenId}/completo", ordenId)
                .retrieve()
                .toBodilessEntity();
    }
}
