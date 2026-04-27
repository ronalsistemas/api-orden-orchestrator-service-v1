package com.rcasani.controller;

import com.rcasani.controller.dto.CrearOrdenOrchestratorRequest;
import com.rcasani.controller.dto.CrearOrdenOrchestratorResponse;
import com.rcasani.service.OrdenOrchestratorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
