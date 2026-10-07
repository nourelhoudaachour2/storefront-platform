package com.boutique.demo.commande.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CommandeDTO {

    private Long id;
    private LocalDate dateCommande;
    private String statut;
    private Double montantTotal;
    private Long clientId;
    private List<LigneCommandeDTO> lignes = new ArrayList<>();

    public CommandeDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDateCommande() { return dateCommande; }
    public void setDateCommande(LocalDate dateCommande) { this.dateCommande = dateCommande; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Double getMontantTotal() { return montantTotal; }
    public void setMontantTotal(Double montantTotal) { this.montantTotal = montantTotal; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }

    public List<LigneCommandeDTO> getLignes() { return lignes; }
    public void setLignes(List<LigneCommandeDTO> lignes) { this.lignes = lignes; }
}
