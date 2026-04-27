package com.rcasani.client.ordenes.restclient.dto;

import com.rcasani.controller.dto.ClienteRequest;
import com.rcasani.controller.dto.FarmaciaRequest;

import java.math.BigDecimal;

public record CrearOrdenRequest(ClienteRequest cliente,
                                FarmaciaRequest farmacia,
                                BigDecimal total) {
}
