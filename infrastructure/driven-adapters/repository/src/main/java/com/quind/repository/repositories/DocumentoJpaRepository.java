package com.quind.repository.repositories;

import com.quind.repository.entities.DocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoJpaRepository extends JpaRepository<DocumentoEntity, String> {

}
