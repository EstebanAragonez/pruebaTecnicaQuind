package com.quind.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empleados")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(EmpleadoId.class)
public class EmpleadoEntity {

    @Id
    @Column(name = "tipo_documento", length = 2, nullable = false)
    private String tipoDocumento;

    @Id
    @Column(name = "numero_documento", length = 20, nullable = false)
    private String numeroDocumento;

    @Column(name = "area", length = 50)
    private String area;

    @Column(name = "nombre_completo", length = 100, nullable = false)
    private String nombreCompleto;
}
