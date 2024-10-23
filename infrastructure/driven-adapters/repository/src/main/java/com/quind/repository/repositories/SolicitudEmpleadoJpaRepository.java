package com.quind.repository.repositories;

import com.quind.repository.entities.SolicitudEmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudEmpleadoJpaRepository extends JpaRepository<SolicitudEmpleadoEntity, Long> {
    List<SolicitudEmpleadoEntity> findByDocumento_IdAndNumeroDocumento(String tipoDocumento, String numeroDocumento);
}
