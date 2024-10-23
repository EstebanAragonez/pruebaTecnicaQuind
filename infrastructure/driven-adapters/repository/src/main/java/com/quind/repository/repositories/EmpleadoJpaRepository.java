package com.quind.repository.repositories;

import com.quind.model.models.Empleado;
import com.quind.repository.entities.EmpleadoEntity;
import com.quind.repository.entities.EmpleadoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpleadoJpaRepository extends JpaRepository<EmpleadoEntity, EmpleadoId> {


    // Método para encontrar un empleado por tipo y número de documento
    Optional<Empleado> findByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);

}
