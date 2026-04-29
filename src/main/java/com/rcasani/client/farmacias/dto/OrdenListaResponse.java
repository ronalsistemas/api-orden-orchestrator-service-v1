package com.rcasani.client.farmacias.dto;

public record OrdenListaResponse(
        Long productoId,
        String productoNombre,
        int cantidad,
        String descripcion
) {
}
