package com.rcasani.client.ordenes;

import com.rcasani.client.ordenes.restclient.dto.CrearOrdenResponse;
import com.rcasani.controller.dto.CrearOrdenOrchestratorRequest;

public interface OrdenServiceV1Client {

    CrearOrdenResponse crearOrden(CrearOrdenOrchestratorRequest crearOrdenOrchestratorRequest);
}
