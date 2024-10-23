package com.quind.apirest.response;

import java.util.Date;

public record SolicitudEmpleadoResponse(
        String tipoSolicitudId,
        String tipoDocumento,
        String numeroDocumento,
        String nombreEmpleado,
        Date fechaSolicitud,
        String comentarios
) {
}
