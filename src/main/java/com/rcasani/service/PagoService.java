package com.rcasani.service;

import com.rcasani.client.pagos.feign.PagoServiceV1FeignClient;
import com.rcasani.client.pagos.dto.CobroRequest;
import com.rcasani.client.pagos.dto.ConsultarSaldoRequest;
import com.rcasani.client.pagos.restclient.PagoServiceV1RestClient;
import com.rcasani.client.pagos.restclient.PagoServiceV2RestClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.math.BigDecimal;

@Slf4j
@Service
@AllArgsConstructor
public class PagoService {

    private final PagoServiceV1FeignClient pagoServiceClient;
    private final PagoServiceV1RestClient pagoServiceV1RestClient;
    private final PagoServiceV2RestClient pagoServiceV2RestClient;

    public void consultarSaldo(Long clienteId, Long tarjetaId, BigDecimal cantidad) {
        log.info("Consultar saldo para clienteId: {}, clienteId: {}, cantidad: {}", clienteId, tarjetaId, cantidad);

        ConsultarSaldoRequest request = new ConsultarSaldoRequest(clienteId, tarjetaId, cantidad);
        ResponseEntity<Void> response = pagoServiceClient.consultarSaldo(request);

        if (response.getStatusCode().is4xxClientError()) {
            throw new RuntimeException("Fondos insuficientes para clienteId: " + clienteId + ", tarjetaId: " + tarjetaId);
        }

        log.info("Fondos suficientes disponibles para clienteId: {}, tarjetaId: {}, cantidad: {}", clienteId, tarjetaId, cantidad);
    }

    @CircuitBreaker(name="cargarPagoV2CB", fallbackMethod = "cargarRetroceso")
    public void cobro(Long clienteId, Long tarjetaId, BigDecimal cantidad) {
        log.info("Calling PagoServiceV2#cargar");

        CobroRequest request = new CobroRequest(clienteId, tarjetaId, cantidad);
        ResponseEntity<Void> response = pagoServiceV2RestClient.cobro(request);

        if (response.getStatusCode().isError()){
            throw new RuntimeException("Error al cobrar el importe a clienteId: " + clienteId + ", tarjetaId: " + tarjetaId);
        }

        log.info("Importe cobrado con éxito clienteId: {}, tarjetaId: {}, cantidad: {}", clienteId, tarjetaId, cantidad);
    }

    public void cargarRetroceso(Long clienteId, Long tarjetaId, BigDecimal cantidad, Throwable ex) {
        log.info("Llamando a la opción de reserva PagoServiceV1#cargar");

        CobroRequest request = new CobroRequest(clienteId, tarjetaId, cantidad);
        ResponseEntity<Void> response = pagoServiceV1RestClient.cargar(request);

        if (response.getStatusCode().isError()){
            throw new RuntimeException("Error al cobrar el importe a clienteId: " + clienteId + ", tarjetaId: " + tarjetaId);
        }

        log.info("Importe cobrado con éxito clienteId: {}, tarjetaId: {}, cantidad: {}", clienteId, tarjetaId, cantidad);
    }
}