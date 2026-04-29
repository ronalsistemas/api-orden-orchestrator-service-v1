package com.rcasani.client.farmacias.dto;

import java.util.List;
import java.util.UUID;

public record ReservaOrdenRequest(
        UUID ordenId,
        Long farmaciaId,
        Long clienteId,
        List<OrdenListaRequest> items
) {
}
