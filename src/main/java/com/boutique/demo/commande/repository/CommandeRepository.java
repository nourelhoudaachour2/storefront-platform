package com.boutique.demo.commande.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.boutique.demo.commande.entity.Commande;
public interface CommandeRepository extends JpaRepository<Commande, Long> {
List<Commande> findByClientId(Long clientId);}