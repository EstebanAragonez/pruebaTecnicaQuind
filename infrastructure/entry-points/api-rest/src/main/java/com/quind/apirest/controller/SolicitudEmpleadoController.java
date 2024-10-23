package com.quind.apirest.controller;

import com.quind.model.request.SolicitudEmpleadoRequest;
import com.quind.model.models.SolicitudEmpleado;
import com.quind.usecase.SolicitudEmpleadoUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/solicitudes")
@RequiredArgsConstructor
public final class SolicitudEmpleadoController {

    private final SolicitudEmpleadoUseCase solicitudEmpleadoUseCase;

    @PostMapping
    public ResponseEntity<SolicitudEmpleado> crearSolicitud(@Valid @RequestBody SolicitudEmpleadoRequest solicitudEmpleadoRequest) {
        try {
            SolicitudEmpleado nuevaSolicitud = solicitudEmpleadoUseCase.crearSolicitud(solicitudEmpleadoRequest);
            return ResponseEntity.ok(nuevaSolicitud);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<SolicitudEmpleado>> obtenerSolicitudes(
            @RequestParam(required = false) String tipoDocumento,
            @RequestParam(required = false) String numeroDocumento) {

        List<SolicitudEmpleado> solicitudes;

        if (tipoDocumento != null && numeroDocumento != null) {
            solicitudes = solicitudEmpleadoUseCase.obtenerSolicitudesPorDocumento(tipoDocumento, numeroDocumento);
        } else {
            solicitudes = solicitudEmpleadoUseCase.obtenerTodasLasSolicitudes();
        }

        return ResponseEntity.ok(solicitudes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudEmpleado> actualizarSolicitud(
            @PathVariable Long id,
            @RequestParam String estado,
            @RequestParam(required = false) String comentarios) {

        try {
            SolicitudEmpleado solicitudActualizada = solicitudEmpleadoUseCase.actualizarSolicitud(id, estado, comentarios);
            return ResponseEntity.ok(solicitudActualizada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
