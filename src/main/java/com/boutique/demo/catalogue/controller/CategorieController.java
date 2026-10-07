package com.boutique.demo.catalogue.controller;
import org.springframework.web.bind.annotation.*;
import com.boutique.demo.catalogue.dto.CategorieDTO;
import com.boutique.demo.catalogue.entity.Categorie;
import com.boutique.demo.catalogue.service.CategorieService;

@RestController
@RequestMapping("/categories")
public class CategorieController {

    private final CategorieService categorieService;
    public CategorieController(CategorieService categorieService) {this.categorieService = categorieService;}
    
    @PostMapping
    public CategorieDTO ajouterCategorie(@RequestBody CategorieDTO categorieDTO) {

        Categorie categorie = new Categorie();
        categorie.setNom(categorieDTO.getNom());
        categorie.setDescription(categorieDTO.getDescription());
        Categorie categorieSauvegardee = categorieService.ajouterCategorie(categorie);
        return new CategorieDTO(
                categorieSauvegardee.getId(),
                categorieSauvegardee.getNom(),
                categorieSauvegardee.getDescription()
        );
    }

    @GetMapping("/{id}")
    public CategorieDTO consulterCategorie(@PathVariable Long id) {

        Categorie categorie = categorieService.consulterCategorie(id);

        if (categorie == null) {
            return null;
        }

        return new CategorieDTO(
                categorie.getId(),
                categorie.getNom(),
                categorie.getDescription()
        );
    }

    @PutMapping("/{id}")
    public CategorieDTO modifierCategorie(
            @PathVariable Long id,
            @RequestBody CategorieDTO categorieDTO) {

        Categorie categorie = new Categorie();

        categorie.setNom(categorieDTO.getNom());
        categorie.setDescription(categorieDTO.getDescription());

        Categorie categorieModifiee =
                categorieService.modifierCategorie(id, categorie);

        if (categorieModifiee == null) {
            return null;
        }

        return new CategorieDTO(
                categorieModifiee.getId(),
                categorieModifiee.getNom(),
                categorieModifiee.getDescription()
        );
    }

    @DeleteMapping("/{id}")
    public void supprimerCategorie(@PathVariable Long id) {
        categorieService.supprimerCategorie(id);
    }
}