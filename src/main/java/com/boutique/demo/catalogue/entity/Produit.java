package com.boutique.demo.catalogue.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String reference;
    private String nom;
    private String description;
    private Double prix;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    public Produit() {}
    public Produit(Long id, String reference, String nom, String description, Double prix, Integer stock, Categorie categorie) {
        this.id = id;
        this.reference = reference;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.stock = stock;
        this.categorie = categorie;} 

    public Long getId() { return id;}
    public void setId(Long id) {this.id = id;}

    public String getReference() {return reference;}
    public void setReference(String reference)
    {this.reference = reference;}

    public String getNom() {return nom;}
    public void setNom(String nom) 
    {this.nom = nom;}

    public String getDescription() {return description;}
    public void setDescription(String description)
    {this.description = description;}

    public Double getPrix() {return prix;}
    public void setPrix(Double prix)
    {this.prix = prix;}

    public Integer getStock() {return stock;}
    public void setStock(Integer stock) 
    {this.stock = stock;}

    public Categorie getCategorie() {return categorie;}
    public void setCategorie(Categorie categorie)
    {this.categorie = categorie;}
}