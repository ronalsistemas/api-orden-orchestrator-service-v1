package com.rcasani.controller.dto;

import java.math.BigDecimal;
import java.util.List;

public record CrearOrdenOrchestratorRequest(
        ClienteRequest cliente,
        TarjetaRequest tarjeta,
        FarmaciaRequest farmacia,
        List<OrdenItemRequest> items,
        DireccionEntrega direccionEntrega,
        Repartidor repartidor,
        BigDecimal total
) {
}
