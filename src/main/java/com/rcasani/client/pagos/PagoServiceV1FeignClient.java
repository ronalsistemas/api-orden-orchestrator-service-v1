package com.rcasani.client.pagos;

import com.rcasani.client.pagos.dto.CobroRequest;
import com.rcasani.client.pagos.dto.ConsultarSaldoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pagotServiceV1FeignClient", url = "http://localhost:40014/api/v1/")
public interface PagoServiceV1FeignClient {

    @PostMapping("/pagos/consultar-saldo")
    ResponseEntity<Void> consultarSaldo(@RequestBody ConsultarSaldoRequest request);

    @PostMapping("/pagos/cobro")
    ResponseEntity<Void> cobro(@RequestBody CobroRequest request);
}
