package com.rcasani.client.ordenes.restclient.dto;

import java.math.BigDecimal;

public record CrearOrdenRequest(ClienteRequest cliente,
                                FarmaciaRequest farmacia,
                                BigDecimal total) {
}
