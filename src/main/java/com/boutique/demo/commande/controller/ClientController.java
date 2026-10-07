package com.boutique.demo.commande.controller;

import org.springframework.web.bind.annotation.*;

import com.boutique.demo.commande.dto.AdresseDto;
import com.boutique.demo.commande.dto.ClientDto;
import com.boutique.demo.commande.entity.Adresse;
import com.boutique.demo.commande.entity.Client;
import com.boutique.demo.commande.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ClientDto ajouterClient(@RequestBody ClientDto clientDto) {
        Client client = clientService.ajouterClient(clientDto);
        return convertirEnDTO(client);
    }

    @GetMapping("/{id}")
    public ClientDto consulterClient(@PathVariable Long id) {
        Client client = clientService.consulterClient(id);

        if (client == null) {
            return null;
        }

        return convertirEnDTO(client);
    }

    @PutMapping("/{id}")
    public ClientDto modifierClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        Client client = clientService.modifierClient(id, clientDto);

        if (client == null) {
            return null;
        }

        return convertirEnDTO(client);
    }

    @DeleteMapping("/{id}")
    public void supprimerClient(@PathVariable Long id) {
        clientService.supprimerClient(id);
    }

    private ClientDto convertirEnDTO(Client client) {

        AdresseDto adresseDto = null;

        if (client.getAdresse() != null) {
            Adresse a = client.getAdresse();
            adresseDto = new AdresseDto(a.getId(), a.getRue(), a.getVille(), a.getCodePostal(), a.getPays());
        }

        return new ClientDto(
                client.getId(),
                client.getNom(),
                client.getPrenom(),
                client.getEmail(),
                client.getTelephone(),
                adresseDto
        );
    }
}
