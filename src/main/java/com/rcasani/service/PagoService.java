package com.rcasani.service;

import com.rcasani.client.pagos.PagoServiceV1FeignClient;
import com.rcasani.client.pagos.dto.CobroRequest;
import com.rcasani.client.pagos.dto.ConsultarSaldoRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@AllArgsConstructor
public class PagoService {

    private final PagoServiceV1FeignClient pagoServiceClient;

    public void consultarSaldo(Long clienteId, Long tarjetaId, BigDecimal cantidad) {
        log.info("Consultar saldo para clienteId: {}, clienteId: {}, cantidad: {}", clienteId, tarjetaId, cantidad);

        ConsultarSaldoRequest request = new ConsultarSaldoRequest(clienteId, tarjetaId, cantidad);
        ResponseEntity<Void> response = pagoServiceClient.consultarSaldo(request);

        if (response.getStatusCode().is4xxClientError()) {
            throw new RuntimeException("Fondos insuficientes para clienteId: " + clienteId + ", tarjetaId: " + tarjetaId);
        }

        log.info("Fondos suficientes disponibles para clienteId: {}, tarjetaId: {}, cantidad: {}", clienteId, tarjetaId, cantidad);
    }

    public void cobro(Long clienteId, Long tarjetaId, BigDecimal cantidad) {
        log.info("Importe de cobro por clienteId: {}, tarjetaId: {}, cantidad: {}", clienteId, tarjetaId, cantidad);

        CobroRequest request = new CobroRequest(clienteId, tarjetaId, cantidad);
        ResponseEntity<Void> response = pagoServiceClient.cobro(request);

        if (response.getStatusCode().isError()){
            throw new RuntimeException("Error al cobrar el importe a clienteId: " + clienteId + ", tarjetaId: " + tarjetaId);
        }

        log.info("Importe cobrado con éxito clienteId: {}, tarjetaId: {}, cantidad: {}", clienteId, tarjetaId, cantidad);
    }
}
