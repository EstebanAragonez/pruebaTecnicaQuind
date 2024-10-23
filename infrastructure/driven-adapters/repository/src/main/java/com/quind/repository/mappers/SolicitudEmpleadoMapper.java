package com.quind.repository.mappers;

import com.quind.model.models.SolicitudEmpleado;
import com.quind.repository.entities.SolicitudEmpleadoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SolicitudEmpleadoMapper {

    SolicitudEmpleadoEntity toEntity(SolicitudEmpleado solicitudEmpleado);
    SolicitudEmpleado toModel(SolicitudEmpleadoEntity solicitudEmpleadoEntity);
}
