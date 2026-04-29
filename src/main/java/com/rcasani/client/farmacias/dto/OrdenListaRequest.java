package com.rcasani.client.farmacias.dto;

public record OrdenListaRequest(
        Long productoId,
        String productoNombre,
        int cantidad,
        String descripcion
) {
}
