package com.boutique.demo.commande.entity;
import com.boutique.demo.catalogue.entity.Produit;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantite;
    private Double prixUnitaire;
    @ManyToOne(optional = false)
    private Commande commande;
    @ManyToOne
    private Produit produit;
    public LigneCommande() {}
    public LigneCommande(Long id, Integer quantite, Double prixUnitaire, Commande commande, Produit produit) {
        this.id = id;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.commande = commande;
        this.produit = produit;}
    

    public Long getId() {
        return id;}
    public void setId(Long id) {
        this.id = id;}
    public Integer getQuantite() {
        return quantite;}
    public void setQuantite(Integer quantite) {
        this.quantite = quantite;}
     public Double getPrixUnitaire() {
        return prixUnitaire;}
     public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire; }
    public Commande getCommande() {
        return commande;}
    public void setCommande(Commande commande) {
        this.commande = commande;}
    public Produit getProduit() {
        return produit;}
    public void setProduit(Produit produit) {
        this.produit = produit;}}
    
