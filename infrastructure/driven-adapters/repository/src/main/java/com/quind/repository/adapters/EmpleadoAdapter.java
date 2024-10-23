package com.quind.repository.adapters;

import com.quind.model.models.Empleado;
import com.quind.model.ports.outbound.EmpleadoPort;
import com.quind.repository.repositories.EmpleadoJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Slf4j
@Repository
@RequiredArgsConstructor
public class EmpleadoAdapter implements EmpleadoPort {

    private final EmpleadoJpaRepository empleadoJpaRepository;
    @Override
    public Optional<Empleado> findByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento) {
        return empleadoJpaRepository.findByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);
    }
}
