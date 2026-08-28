package com.rcasani.service;

import com.rcasani.client.ordenes.restclient.dto.CrearOrdenResponse;
import com.rcasani.controller.dto.CrearOrdenOrchestratorRequest;
import com.rcasani.controller.dto.CrearOrdenOrchestratorResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OrdenOrchestratorService {

    private final OrdenService ordenService;
    private final PagoService pagoService;
    private final FarmaciaService farmaciaService;
    private final EntregaService entregaService;

    public CrearOrdenOrchestratorResponse crearOrden(CrearOrdenOrchestratorRequest request) {

        CrearOrdenResponse ordenCreado = ordenService.crearOrden(request);

        pagoService.consultarSaldo(request.cliente().id(), request.tarjeta().id(), request.total());

        pagoService.cobro(request.cliente().id(), request.tarjeta().id(), request.total());

        farmaciaService.reservaFarmacia(ordenCreado.id(), request);

        entregaService.asignarConductor(ordenCreado.id(), request); //Se agregó con el servicio delivery

        return new CrearOrdenOrchestratorResponse(ordenCreado.id());

    }

    public void iniciarEntrega(UUID ordenId) {
        entregaService.iniciarEntrega(ordenId);
    }

    public void entregaCompleta(UUID ordenId) {
        entregaService.entregaCompleta(ordenId);
    }
}
