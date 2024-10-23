package com.quind.repository.adapters;

import com.quind.model.models.SolicitudEmpleado;
import com.quind.model.ports.outbound.SolicitudEmpleadoPort;
import com.quind.repository.entities.SolicitudEmpleadoEntity;
import com.quind.repository.mappers.SolicitudEmpleadoMapper;
import com.quind.repository.repositories.SolicitudEmpleadoJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SolicitudEmpleadoAdapter implements SolicitudEmpleadoPort {

    private final SolicitudEmpleadoJpaRepository solicitudEmpleadoJpaRepository;
    private final SolicitudEmpleadoMapper solicitudEmpleadoMapper;

    @Override
    public SolicitudEmpleado guardar(SolicitudEmpleado solicitudEmpleado) {
        SolicitudEmpleadoEntity solicitudEmpleadoEntity = solicitudEmpleadoMapper.toEntity(solicitudEmpleado);
        solicitudEmpleadoJpaRepository.save(solicitudEmpleadoEntity);
        return solicitudEmpleado;
    }

    @Override
    public List<SolicitudEmpleado> obtenerTodas() {
        List<SolicitudEmpleadoEntity> entities = solicitudEmpleadoJpaRepository.findAll();
        return entities.stream()
                .map(solicitudEmpleadoMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<SolicitudEmpleado> obtenerPorTipoYNumeroDocumento(String tipoDocumento, String numeroDocumento) {
        List<SolicitudEmpleadoEntity> entities = solicitudEmpleadoJpaRepository.findByDocumento_IdAndNumeroDocumento(tipoDocumento, numeroDocumento);
        return entities.stream()
                .map(solicitudEmpleadoMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SolicitudEmpleado> obtenerPorId(Long id) {
        Optional<SolicitudEmpleadoEntity> entityOpt = solicitudEmpleadoJpaRepository.findById(id);
        return entityOpt.map(solicitudEmpleadoMapper::toModel);
    }
}
