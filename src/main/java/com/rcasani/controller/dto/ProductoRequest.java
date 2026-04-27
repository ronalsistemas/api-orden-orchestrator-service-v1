package com.rcasani.controller.dto;

import java.math.BigDecimal;

public record ProductoRequest(Long id, String nombre, BigDecimal precio) {
}
