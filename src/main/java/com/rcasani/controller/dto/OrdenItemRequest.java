package com.rcasani.controller.dto;

import java.math.BigDecimal;

public record OrdenItemRequest(Long id, ProductoRequest producto, int cantidad, String descripcion, BigDecimal precio) {
}
