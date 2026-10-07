package com.boutique.demo.commande.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.boutique.demo.commande.entity.Adresse;
public interface AdresseRepository extends JpaRepository<Adresse, Long> {}