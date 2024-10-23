package com.quind.model.ports.outbound;

import com.quind.model.models.SolicitudEmpleado;

public interface DocumentoPort {
    SolicitudEmpleado crearSolicitud (SolicitudEmpleado solicitudEmpleado);
}
