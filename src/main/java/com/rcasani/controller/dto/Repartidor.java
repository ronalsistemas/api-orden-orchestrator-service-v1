package com.rcasani.controller.dto;

public record Repartidor(
        Long id,
        String nombre,
        String numeroTelefono,
        String vehiculo,
        String placa
) {
}
