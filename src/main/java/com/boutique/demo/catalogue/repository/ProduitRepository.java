package com.boutique.demo.catalogue.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.boutique.demo.catalogue.entity.Produit;
public interface ProduitRepository extends JpaRepository<Produit, Long> {
	List<Produit> findByCategorieId(Long categorieId);
    List<Produit> findByNom(String nom);}