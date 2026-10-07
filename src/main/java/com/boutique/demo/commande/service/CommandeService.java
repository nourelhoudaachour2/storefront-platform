package com.boutique.demo.commande.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boutique.demo.catalogue.entity.Produit;
import com.boutique.demo.catalogue.repository.ProduitRepository;
import com.boutique.demo.commande.dto.CommandeDTO;
import com.boutique.demo.commande.dto.LigneCommandeDTO;
import com.boutique.demo.commande.entity.Client;
import com.boutique.demo.commande.entity.Commande;
import com.boutique.demo.commande.entity.LigneCommande;
import com.boutique.demo.commande.repository.ClientRepository;
import com.boutique.demo.commande.repository.CommandeRepository;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    private final ProduitRepository produitRepository;

    public CommandeService(CommandeRepository commandeRepository,
                           ClientRepository clientRepository,
                           ProduitRepository produitRepository) {
        this.commandeRepository = commandeRepository;
        this.clientRepository = clientRepository;
        this.produitRepository = produitRepository;
    }

    @Transactional
    public Commande creerCommande(CommandeDTO commandeDTO) {

        Client client = clientRepository.findById(commandeDTO.getClientId()).orElse(null);

        if (client == null) {
            throw new RuntimeException("Client introuvable");
        }

        Commande commande = new Commande();
        commande.setDateCommande(LocalDate.now());
        commande.setStatut("Créée");
        commande.setClient(client);

        double total = 0;

        for (LigneCommandeDTO ligneDTO : commandeDTO.getLignes()) {

            Produit produit = produitRepository.findById(ligneDTO.getProduitId()).orElse(null);

            if (produit == null) {
                throw new RuntimeException("Produit introuvable");
            }

            // vérification du stock
            if (produit.getStock() < ligneDTO.getQuantite()) {
                throw new RuntimeException("Stock insuffisant pour le produit " + produit.getNom());
            }

            // décrémentation du stock
            produit.setStock(produit.getStock() - ligneDTO.getQuantite());

            LigneCommande ligne = new LigneCommande();
            ligne.setQuantite(ligneDTO.getQuantite());
            // le prix unitaire est copié depuis le produit
            ligne.setPrixUnitaire(produit.getPrix());
            ligne.setProduit(produit);
            ligne.setCommande(commande);

            commande.getLignes().add(ligne);

            total = total + ligne.getQuantite() * ligne.getPrixUnitaire();
        }

        commande.setMontantTotal(total);

        return commandeRepository.save(commande);
    }

    public Commande consulterCommande(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    public List<Commande> commandesClient(Long clientId) {
        return commandeRepository.findByClientId(clientId);
    }
}
