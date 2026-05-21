package com.example.atividadePontuadaDois.repository;

import com.example.atividadePontuadaDois.entity.ClienteEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository <ClienteEntity, Long> {

    Optional <ClienteEntity> findByEmail (String email);

    @Transactional
    void deleteByEmail (String email);
}
