package com.example.gestionstock2.repositories;

import com.example.gestionstock2.modele.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, UUID> {
}
