package com.quind.repository.entities;

import com.quind.model.models.Documento;
import com.quind.model.models.TipoSolicitud;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "solicitudes_empleados")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudEmpleadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud_empleado")
    private Long idSolicitudEmpleado;

    @ManyToOne
    @JoinColumn(name = "id_solicitud", nullable = false)
    private TipoSolicitud tipoSolicitud;

    @ManyToOne
    @JoinColumn(name = "id_documento", nullable = false)
    private Documento documento;

    @Column(name = "numero_documento", length = 20, nullable = false)
    private String numeroDocumento;

    @Column(name = "nombre_empleado", length = 100, nullable = false)
    private String nombreEmpleado;

    @Column(name = "fecha_solicitud", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;

    @Column(name = "estado", length = 15, nullable = false)
    private String estado;

    @Column(name = "comentarios")
    private String comentarios;
}
