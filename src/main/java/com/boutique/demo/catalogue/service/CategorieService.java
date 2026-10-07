package com.boutique.demo.catalogue.service;

import org.springframework.stereotype.Service;

import com.boutique.demo.catalogue.entity.Categorie;
import com.boutique.demo.catalogue.repository.CategorieRepository;

@Service
public class CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public Categorie ajouterCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public Categorie consulterCategorie(Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    public Categorie modifierCategorie(Long id, Categorie categorie) {
        Categorie categorieExistante = categorieRepository.findById(id).orElse(null);

        if (categorieExistante != null) {
            categorieExistante.setNom(categorie.getNom());
            categorieExistante.setDescription(categorie.getDescription());

            return categorieRepository.save(categorieExistante);
        }

        return null;
    }

    public void supprimerCategorie(Long id) {
        Categorie categorie = categorieRepository.findById(id).orElse(null);

        if (categorie != null) {
            if (!categorie.getProduits().isEmpty()) {
                throw new RuntimeException("Impossible de supprimer une catégorie qui contient des produits");
            }

            categorieRepository.deleteById(id);
        }
    }
}