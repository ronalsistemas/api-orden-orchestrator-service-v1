package com.rcasani.client.pagos.restclient;

import com.rcasani.client.pagos.dto.CobroRequest;
import com.rcasani.client.pagos.dto.ConsultarSaldoRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestClient;

@Component
@AllArgsConstructor
public class PagoServiceV2RestClient {

    private final RestClient pagosV2RestClient;

    public ResponseEntity<Void> consultarSaldo(@RequestBody ConsultarSaldoRequest request) {

        return pagosV2RestClient.post()
                .uri("/consultar-saldo")
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }

    public ResponseEntity<Void> cobro(@RequestBody CobroRequest request) {

        return pagosV2RestClient.post()
                .uri("/cargar")
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }
}
