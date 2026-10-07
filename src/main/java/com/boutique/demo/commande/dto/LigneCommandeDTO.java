package com.boutique.demo.commande.dto;

public class LigneCommandeDTO {

    private Long id;
    private Long produitId;
    private Integer quantite;
    private Double prixUnitaire;

    public LigneCommandeDTO() {}

    public LigneCommandeDTO(Long id, Long produitId, Integer quantite, Double prixUnitaire) {
        this.id = id;
        this.produitId = produitId;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProduitId() { return produitId; }
    public void setProduitId(Long produitId) { this.produitId = produitId; }

    public Integer getQuantite() { return quantite; }
    public void setQuantite(Integer quantite) { this.quantite = quantite; }

    public Double getPrixUnitaire() { return prixUnitaire; }
    public void setPrixUnitaire(Double prixUnitaire) { this.prixUnitaire = prixUnitaire; }
}
