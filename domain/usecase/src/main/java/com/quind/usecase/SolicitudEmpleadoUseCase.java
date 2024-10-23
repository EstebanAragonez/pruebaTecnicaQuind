package com.quind.usecase;

import com.quind.model.ports.outbound.EmpleadoPort;
import com.quind.model.ports.outbound.SolicitudEmpleadoPort;
import com.quind.model.ports.outbound.TipoSolicitudPort;
import lombok.RequiredArgsConstructor;
import com.quind.model.models.Empleado;
import com.quind.model.models.SolicitudEmpleado;
import com.quind.model.models.TipoSolicitud;
import com.quind.model.request.SolicitudEmpleadoRequest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.quind.model.validations.Validations.estadoValido;
import static com.quind.model.validations.Validations.validarFechaSolicitud;

@RequiredArgsConstructor
public class SolicitudEmpleadoUseCase {

    private final SolicitudEmpleadoPort solicitudEmpleadoPort;
    private final EmpleadoPort empleadoPort;
    private final TipoSolicitudPort tipoSolicitudPort;

    public SolicitudEmpleado crearSolicitud(SolicitudEmpleadoRequest solicitudEmpleadoRequest) {
        Optional<Empleado> empleadoOpt = empleadoPort.findByTipoDocumentoAndNumeroDocumento(
                solicitudEmpleadoRequest.getTipoDocumento(), solicitudEmpleadoRequest.getNumeroDocumento()
        );

        if (empleadoOpt.isEmpty()) {
            throw new IllegalArgumentException("El empleado no existe.");
        }

        Empleado empleado = empleadoOpt.get();

        Optional<TipoSolicitud> tipoSolicitudOpt = tipoSolicitudPort.findById(solicitudEmpleadoRequest.getTipoSolicitudId());
        if (tipoSolicitudOpt.isEmpty()) {
            throw new IllegalArgumentException("Tipo de solicitud inválido.");
        }

        TipoSolicitud tipoSolicitud = tipoSolicitudOpt.get();

        // Validar fechas para tipos de solicitud específicos
        validarFechaSolicitud(tipoSolicitud.getId(), solicitudEmpleadoRequest.getFechaDeseada());

        // Crear la solicitud de empleado
        SolicitudEmpleado nuevaSolicitud = getSolicitudEmpleado(solicitudEmpleadoRequest, tipoSolicitud, empleado);

        // Guardar la nueva solicitud
        return solicitudEmpleadoPort.guardar(nuevaSolicitud);
    }


    public List<SolicitudEmpleado> obtenerTodasLasSolicitudes() {
        return solicitudEmpleadoPort.obtenerTodas();
    }

    public List<SolicitudEmpleado> obtenerSolicitudesPorDocumento(String tipoDocumento, String numeroDocumento) {
        return solicitudEmpleadoPort.obtenerPorTipoYNumeroDocumento(tipoDocumento, numeroDocumento);
    }

    public SolicitudEmpleado actualizarSolicitud(Long id, String estado, String comentarios) {
        // Buscar la solicitud existente por ID
        Optional<SolicitudEmpleado> solicitudOpt = solicitudEmpleadoPort.obtenerPorId(id);

        if (solicitudOpt.isEmpty()) {
            throw new IllegalArgumentException("La solicitud no existe.");
        }

        SolicitudEmpleado solicitud = solicitudOpt.get();

        // Si la solicitud está denegada, no se puede cambiar el estado
        if ("DENEGADA".equalsIgnoreCase(solicitud.getEstado()) && !solicitud.getEstado().equalsIgnoreCase(estado)) {
            throw new IllegalArgumentException("No se puede reactivar una solicitud denegada, cree nuevamente la solicitud.");
        }

        // Validar que el estado sea uno de los permitidos
        if (!estadoValido(estado)) {
            throw new IllegalArgumentException("Estado no válido. Los estados permitidos son: NUEVA, APROBADA, EN PROCESO, DENEGADA.");
        }

        // Validar que los estados "APROBADA" y "DENEGADA" tengan comentarios
        if ((estado.equalsIgnoreCase("APROBADA") || estado.equalsIgnoreCase("DENEGADA")) && (comentarios == null || comentarios.trim().isEmpty())) {
            throw new IllegalArgumentException("Las solicitudes con estado 'APROBADA' o 'DENEGADA' deben tener un comentario.");
        }

        // Actualizar el estado y los comentarios
        solicitud.setEstado(estado);
        solicitud.setComentarios(comentarios);

        // Guardar la solicitud actualizada
        return solicitudEmpleadoPort.guardar(solicitud);
    }

    private static SolicitudEmpleado getSolicitudEmpleado(SolicitudEmpleadoRequest solicitudEmpleadoRequest, TipoSolicitud tipoSolicitud, Empleado empleado) {
        SolicitudEmpleado nuevaSolicitud = new SolicitudEmpleado();
        nuevaSolicitud.setTipoSolicitud(tipoSolicitud);
        nuevaSolicitud.setDocumento(empleado.getTipoDocumento());
        nuevaSolicitud.setNumeroDocumento(empleado.getNumeroDocumento());
        nuevaSolicitud.setNombreEmpleado(empleado.getNombreCompleto());
        nuevaSolicitud.setFechaSolicitud(new Date()); // Asignar la fecha actual
        nuevaSolicitud.setEstado("NUEVA"); // Estado siempre es "NUEVA"
        nuevaSolicitud.setComentarios(solicitudEmpleadoRequest.getComentarios());
        return nuevaSolicitud;
    }
}
