package com.quind.model.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    private Documento tipoDocumento;
    private String numeroDocumento;
    private String area;
    private String nombreCompleto;

}
