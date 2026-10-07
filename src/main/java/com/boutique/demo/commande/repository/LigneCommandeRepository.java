package com.boutique.demo.commande.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.boutique.demo.commande.entity.LigneCommande;
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {}