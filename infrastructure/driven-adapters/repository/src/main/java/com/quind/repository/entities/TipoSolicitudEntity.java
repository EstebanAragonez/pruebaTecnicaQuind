package com.quind.repository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo_solicitudes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoSolicitudEntity {

    @Id
    @Column(name = "id", length = 3, nullable = false)
    private String id; // Ejemplos: "VC", "DNR", "AU"

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre; // Ejemplos: "VACACIONES", "DÍAS NO REMUNERADOS"
}
