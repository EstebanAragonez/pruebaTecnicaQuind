package com.quind.apirest.mappers;

import com.quind.model.request.SolicitudEmpleadoRequest;
import com.quind.model.models.SolicitudEmpleado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SolicitudEmpleadoApiRestMapper {

    SolicitudEmpleado toModel(SolicitudEmpleadoRequest solicitudEmpleadoRequest);

}
