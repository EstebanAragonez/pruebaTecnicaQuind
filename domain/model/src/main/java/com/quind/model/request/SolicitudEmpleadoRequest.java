package com.quind.model.request;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Getter
@Setter
public class SolicitudEmpleadoRequest {

    @NotNull
    private String tipoDocumento; // Ejemplo: "CC"

    @NotNull
    private String numeroDocumento; // Ejemplo: "123456"

    @NotNull
    private String tipoSolicitudId; // Ejemplo: "VC"

    @NotNull
    private Date fechaDeseada; // Fecha para la solicitud, ingresada por el usuario

    private String comentarios;
}
