package com.example.atividadePontuadaDois.repository;

import com.example.atividadePontuadaDois.entity.FornecedorEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository <FornecedorEntity, Long> {

    Optional <FornecedorEntity> findByEmail (String email);

    @Transactional
    void deleteByEmail (String email);
}
