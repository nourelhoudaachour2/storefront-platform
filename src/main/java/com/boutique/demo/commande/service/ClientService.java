package com.boutique.demo.commande.service;

import org.springframework.stereotype.Service;

import com.boutique.demo.commande.dto.ClientDto;
import com.boutique.demo.commande.entity.Adresse;
import com.boutique.demo.commande.entity.Client;
import com.boutique.demo.commande.repository.ClientRepository;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client ajouterClient(ClientDto clientDto) {

        if (clientRepository.existsByEmail(clientDto.getEmail())) {
            throw new RuntimeException("Cet email existe déjà");
        }

        Client client = new Client();
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setEmail(clientDto.getEmail());
        client.setTelephone(clientDto.getTelephone());

        if (clientDto.getAdresse() != null) {
            Adresse adresse = new Adresse();
            adresse.setRue(clientDto.getAdresse().getRue());
            adresse.setVille(clientDto.getAdresse().getVille());
            adresse.setCodePostal(clientDto.getAdresse().getCodePostal());
            adresse.setPays(clientDto.getAdresse().getPays());
            client.setAdresse(adresse);
        }

        return clientRepository.save(client);
    }

    public Client consulterClient(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client modifierClient(Long id, ClientDto clientDto) {

        Client client = clientRepository.findById(id).orElse(null);

        if (client != null) {

            if (!client.getEmail().equals(clientDto.getEmail())
                    && clientRepository.existsByEmail(clientDto.getEmail())) {
                throw new RuntimeException("Cet email existe déjà");
            }

            client.setNom(clientDto.getNom());
            client.setPrenom(clientDto.getPrenom());
            client.setEmail(clientDto.getEmail());
            client.setTelephone(clientDto.getTelephone());

            if (clientDto.getAdresse() != null) {
                Adresse adresse = client.getAdresse();
                if (adresse == null) {
                    adresse = new Adresse();
                }
                adresse.setRue(clientDto.getAdresse().getRue());
                adresse.setVille(clientDto.getAdresse().getVille());
                adresse.setCodePostal(clientDto.getAdresse().getCodePostal());
                adresse.setPays(clientDto.getAdresse().getPays());
                client.setAdresse(adresse);
            }

            return clientRepository.save(client);
        }

        return null;
    }

    public void supprimerClient(Long id) {
        clientRepository.deleteById(id);
    }
}
