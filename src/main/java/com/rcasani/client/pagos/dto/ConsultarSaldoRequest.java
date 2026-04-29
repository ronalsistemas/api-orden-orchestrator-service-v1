package com.rcasani.client.pagos.dto;

import java.math.BigDecimal;

public record ConsultarSaldoRequest(Long clienteId, Long tarjetaId, BigDecimal cantidadRequerida) {
}
