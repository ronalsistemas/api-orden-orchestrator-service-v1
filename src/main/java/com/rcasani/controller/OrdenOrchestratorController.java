package com.rcasani.controller;

import com.rcasani.controller.dto.CrearOrdenOrchestratorRequest;
import com.rcasani.controller.dto.CrearOrdenOrchestratorResponse;
import com.rcasani.service.OrdenOrchestratorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/ordenes")
public class OrdenOrchestratorController {

    private final OrdenOrchestratorService service;

    @PostMapping
    public ResponseEntity<CrearOrdenOrchestratorResponse> crearOrden(@RequestBody CrearOrdenOrchestratorRequest request) {

        CrearOrdenOrchestratorResponse crearOrdenResponse = service.crearOrden(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(crearOrdenResponse);
    }

    @PostMapping("/{ordenId}/entrega/iniciar")
    public ResponseEntity<Void> iniciarEntrega(@PathVariable UUID ordenId) {

        service.iniciarEntrega(ordenId);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{ordenId}/entrega/completa")
    public ResponseEntity<Void> entregaCompleta(@PathVariable UUID ordenId) {

        service.entregaCompleta(ordenId);

        return ResponseEntity.ok().build();
    }
}
