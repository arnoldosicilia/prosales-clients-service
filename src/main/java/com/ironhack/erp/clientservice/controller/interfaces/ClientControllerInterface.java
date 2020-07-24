package com.ironhack.erp.clientservice.controller.interfaces;

import com.ironhack.erp.clientservice.model.entities.Client;

import java.util.List;

public interface ClientControllerInterface {
    List<Client> findAll();
    Client findById(Long id);
    Client createClient(Client client);
    void deleteClient(Long id);
}
