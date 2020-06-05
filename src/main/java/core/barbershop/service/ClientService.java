package core.barbershop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.barbershop.model.Client;
import core.barbershop.repository.ClientRepository;

/**
 * ClientService
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public Client postClient(Client client) {
        if (!client.isValid()) {
            throw new Error("Invalid client");
        }

        Client newClient = this.clientRepository.save(client);

        return newClient;
    }

    public List<Client> findAllClient() {
      List<Client> clients = this.clientRepository.findAll();

      return clients;
    }
}