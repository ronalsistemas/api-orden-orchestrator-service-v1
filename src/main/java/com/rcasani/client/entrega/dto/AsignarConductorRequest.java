package com.rcasani.client.entrega.dto;

import java.util.UUID;

public record AsignarConductorRequest(
        UUID ordenId,
        EntregaDireccionRequest entregaDireccion,
        EntregaPersonaRequest entregaPersona
) {
}
