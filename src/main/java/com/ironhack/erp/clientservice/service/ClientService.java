package com.ironhack.erp.clientservice.service;

import com.ironhack.erp.clientservice.exception.ClientNotFoundException;
import com.ironhack.erp.clientservice.model.entities.Client;
import com.ironhack.erp.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Client Service
 */
@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    /**
     * Find all clients
     *
     * @return The list of clients
     */
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    /**
     * Fid a client by Identifier
     *
     * @param id The Identifier
     * @return The client found or ClientNotFoundException if it's missing
     */
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client with id: " + id + " not found"));
    }

    /**
     * Creates a client
     *
     * @param client the client to be created
     * @return The created client
     */
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    /**
     * Creates a client
     *
     * @param client the client to be updated
     * @param id the id of the client to be updated
     * @return The created client
     */
    public Client updateClient(Client client, Long id) {

        Client target = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("Client with id: " + id + " not found"));
        client.setId(target.getId());
        return clientRepository.save(client);
    }

    /**
     * Deletes a client by Identifier
     *
     * @param id The client identifier
     */
    public void deleteClient(Long id) {
        if (clientRepository.findById(id).isPresent()) {
            clientRepository.deleteById(id);
        } else {
            throw new ClientNotFoundException("Client with id: " + id + " not found");
        }
    }

}
