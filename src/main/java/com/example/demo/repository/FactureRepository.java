package com.example.demo.repository;

import com.example.demo.entity.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository permettant l'interraction avec la base de données pour les factures.
 */
@Repository
public interface FactureRepository extends JpaRepository<FactureEntity, Long> {

}
