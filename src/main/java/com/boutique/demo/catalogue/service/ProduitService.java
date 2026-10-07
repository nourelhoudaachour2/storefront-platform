package com.boutique.demo.catalogue.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boutique.demo.catalogue.dto.ProduitDTO;
import com.boutique.demo.catalogue.entity.Categorie;
import com.boutique.demo.catalogue.entity.Produit;
import com.boutique.demo.catalogue.repository.CategorieRepository;
import com.boutique.demo.catalogue.repository.ProduitRepository;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;
    private final CategorieRepository categorieRepository;

    public ProduitService(ProduitRepository produitRepository,CategorieRepository categorieRepository) {
        this.produitRepository = produitRepository;
        this.categorieRepository = categorieRepository;
    }

    public Produit ajouterProduit(ProduitDTO produitDTO) {

        Categorie categorie = categorieRepository
                .findById(produitDTO.getCategorieId())
                .orElse(null);

        Produit produit = new Produit();

        produit.setReference(produitDTO.getReference());
        produit.setNom(produitDTO.getNom());
        produit.setDescription(produitDTO.getDescription());
        produit.setPrix(produitDTO.getPrix());
        produit.setStock(produitDTO.getStock());
        produit.setCategorie(categorie);

        return produitRepository.save(produit);
    }

    public Produit consulterProduit(Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    public Produit modifierProduit(Long id, ProduitDTO produitDTO) {

        Produit produit = produitRepository.findById(id).orElse(null);

        if (produit != null) {

            Categorie categorie = categorieRepository
                    .findById(produitDTO.getCategorieId())
                    .orElse(null);

            produit.setReference(produitDTO.getReference());
            produit.setNom(produitDTO.getNom());
            produit.setDescription(produitDTO.getDescription());
            produit.setPrix(produitDTO.getPrix());
            produit.setStock(produitDTO.getStock());
            produit.setCategorie(categorie);

            return produitRepository.save(produit);
        }

        return null;
    }

    public void supprimerProduit(Long id) {
        produitRepository.deleteById(id);
    }

    public List<Produit> produitsCategorie(Long categorieId) {
        return produitRepository.findByCategorieId(categorieId);
    }

    public List<Produit> rechercherParNom(String nom) {
        return produitRepository.findByNom(nom);
    }
}