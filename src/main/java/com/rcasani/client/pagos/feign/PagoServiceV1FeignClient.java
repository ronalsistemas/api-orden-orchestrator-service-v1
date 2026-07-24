package com.rcasani.client.pagos.feign;

import com.rcasani.client.pagos.dto.CobroRequest;
import com.rcasani.client.pagos.dto.ConsultarSaldoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "api-pagos-service-v1")
public interface PagoServiceV1FeignClient {

    @PostMapping("/api/v1/pagos/consultar-saldo")
    ResponseEntity<Void> consultarSaldo(@RequestBody ConsultarSaldoRequest request);

    @PostMapping("/api/v1/pagos/cobro")
    ResponseEntity<Void> cobro(@RequestBody CobroRequest request);
}
