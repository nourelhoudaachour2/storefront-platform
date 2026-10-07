package com.boutique.demo.catalogue.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import com.boutique.demo.catalogue.dto.ProduitDTO;
import com.boutique.demo.catalogue.entity.Produit;
import com.boutique.demo.catalogue.service.ProduitService;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping
    public ProduitDTO ajouterProduit(@RequestBody ProduitDTO produitDTO) {

        Produit produit = produitService.ajouterProduit(produitDTO);

        return convertirEnDTO(produit);
    }

    @GetMapping("/{id}")
    public ProduitDTO consulterProduit(@PathVariable Long id) {

        Produit produit = produitService.consulterProduit(id);

        if (produit == null) {
            return null;
        }

        return convertirEnDTO(produit);
    }

    @PutMapping("/{id}")
    public ProduitDTO modifierProduit(
            @PathVariable Long id,
            @RequestBody ProduitDTO produitDTO) {

        Produit produit = produitService.modifierProduit(id, produitDTO);

        if (produit == null) {
            return null;
        }

        return convertirEnDTO(produit);
    }

    @DeleteMapping("/{id}")
    public void supprimerProduit(@PathVariable Long id) {
        produitService.supprimerProduit(id);
    }

    @GetMapping("/categorie/{categorieId}")
    public List<ProduitDTO> produitsCategorie(
            @PathVariable Long categorieId) {

        return produitService.produitsCategorie(categorieId)
                .stream()
                .map(this::convertirEnDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/recherche")
    public List<ProduitDTO> rechercherParNom(@RequestParam String nom) {

        return produitService.rechercherParNom(nom)
                .stream()
                .map(this::convertirEnDTO)
                .collect(Collectors.toList());
    }

    private ProduitDTO convertirEnDTO(Produit produit) {

        Long categorieId = null;

        if (produit.getCategorie() != null) {
            categorieId = produit.getCategorie().getId();
        }

        return new ProduitDTO(
                produit.getId(),
                produit.getReference(),
                produit.getNom(),
                produit.getDescription(),
                produit.getPrix(),
                produit.getStock(),
                categorieId
        );
    }
}