package com.boutique.demo.commande.entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String email;
    private String telephone;
    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;
    @OneToMany(mappedBy = "client")
    private List<Commande> commandes = new ArrayList<>();

    public Client() {}
    public Client(Long id, String nom, String prenom, String email, String telephone, Adresse adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;}

    public Long getId() {
        return id;}

    public void setId(Long id) {
        this.id = id;}

    public String getNom() {
        return nom;}

    public void setNom(String nom) {
        this.nom = nom;}

    public String getPrenom() {
        return prenom;}

    public void setPrenom(String prenom) {
        this.prenom = prenom;}

    public String getEmail() {
        return email;}

    public void setEmail(String email) {
        this.email = email;}

    public String getTelephone() {
        return telephone;}

    public void setTelephone(String telephone) {
        this.telephone = telephone;}

    public Adresse getAdresse() {
        return adresse;}

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;}

    public List<Commande> getCommandes() {
        return commandes;}

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;}
}