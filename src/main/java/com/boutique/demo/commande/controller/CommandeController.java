package com.boutique.demo.commande.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.boutique.demo.commande.dto.CommandeDTO;
import com.boutique.demo.commande.dto.LigneCommandeDTO;
import com.boutique.demo.commande.entity.Commande;
import com.boutique.demo.commande.entity.LigneCommande;
import com.boutique.demo.commande.service.CommandeService;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @PostMapping
    public CommandeDTO creerCommande(@RequestBody CommandeDTO commandeDTO) {
        Commande commande = commandeService.creerCommande(commandeDTO);
        return convertirEnDTO(commande);
    }

    @GetMapping("/{id}")
    public CommandeDTO consulterCommande(@PathVariable Long id) {
        Commande commande = commandeService.consulterCommande(id);

        if (commande == null) {
            return null;
        }

        return convertirEnDTO(commande);
    }

    @GetMapping("/client/{clientId}")
    public List<CommandeDTO> commandesClient(@PathVariable Long clientId) {
        List<CommandeDTO> resultat = new ArrayList<>();

        for (Commande commande : commandeService.commandesClient(clientId)) {
            resultat.add(convertirEnDTO(commande));
        }

        return resultat;
    }

    private CommandeDTO convertirEnDTO(Commande commande) {

        CommandeDTO dto = new CommandeDTO();
        dto.setId(commande.getId());
        dto.setDateCommande(commande.getDateCommande());
        dto.setStatut(commande.getStatut());
        dto.setMontantTotal(commande.getMontantTotal());
        dto.setClientId(commande.getClient().getId());

        List<LigneCommandeDTO> lignes = new ArrayList<>();

        for (LigneCommande ligne : commande.getLignes()) {
            lignes.add(new LigneCommandeDTO(
                    ligne.getId(),
                    ligne.getProduit().getId(),
                    ligne.getQuantite(),
                    ligne.getPrixUnitaire()
            ));
        }

        dto.setLignes(lignes);

        return dto;
    }
}
