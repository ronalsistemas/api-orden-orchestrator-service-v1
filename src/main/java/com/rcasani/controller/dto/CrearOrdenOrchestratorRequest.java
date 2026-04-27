package com.rcasani.controller.dto;

import java.math.BigDecimal;
import java.util.List;

public record CrearOrdenOrchestratorRequest(
        ClienteRequest cliente,
        CuentaPago cuenta,
        FarmaciaRequest farmacia,
        List<OrdenItemRequest> listaOrden,
        DireccionEntrega direccionEntrega,
        Repartidor repartidor,
        BigDecimal total
) {
}
