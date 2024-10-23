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
@Table(name = "documentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoEntity {

    @Id
    @Column(name = "id", length = 2, nullable = false)
    private String id; // Ejemplos: CC, CE, PS

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre; // Ejemplos: "CÉDULA DE CIUDADANIA", "CÉDULA EXTRANJERÍA"
}
