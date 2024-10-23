package com.quind.model.models;

import java.util.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudEmpleado {

    private Long idSolicitudEmpleado;
    private TipoSolicitud tipoSolicitud;
    private Documento documento;
    private String numeroDocumento;
    private String nombreEmpleado;
    private Date fechaSolicitud;
    private String estado;
    private String comentarios;

}
