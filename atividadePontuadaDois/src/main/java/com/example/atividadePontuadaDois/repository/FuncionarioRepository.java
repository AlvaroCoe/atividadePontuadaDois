package com.example.atividadePontuadaDois.repository;

import com.example.atividadePontuadaDois.entity.FuncionarioEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository <FuncionarioEntity, Long> {

    Optional <FuncionarioEntity> findByEmail (String email);

    @Transactional
    void deleteByEmail (String email);
}
