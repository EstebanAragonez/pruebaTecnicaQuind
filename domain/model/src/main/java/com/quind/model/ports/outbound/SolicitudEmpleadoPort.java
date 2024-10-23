package com.quind.model.ports.outbound;

import com.quind.model.models.SolicitudEmpleado;

import java.util.List;
import java.util.Optional;

public interface SolicitudEmpleadoPort {
    SolicitudEmpleado guardar(SolicitudEmpleado solicitudEmpleado);
    List<SolicitudEmpleado> obtenerTodas();
    List<SolicitudEmpleado> obtenerPorTipoYNumeroDocumento(String tipoDocumento, String numeroDocumento);
    Optional<SolicitudEmpleado> obtenerPorId(Long id);
}
