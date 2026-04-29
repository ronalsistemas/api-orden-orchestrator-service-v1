package com.rcasani.client.pagos.dto;

import java.math.BigDecimal;

public record CobroRequest(Long clienteId, Long tarjetaId, BigDecimal cantidad) {
}
