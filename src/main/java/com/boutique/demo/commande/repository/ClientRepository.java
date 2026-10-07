package com.boutique.demo.commande.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.boutique.demo.commande.entity.Client;
public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByEmail(String email);
}
