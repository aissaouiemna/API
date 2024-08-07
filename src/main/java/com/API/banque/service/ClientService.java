package com.API.banque.service;

import com.API.banque.entity.Client;
import com.API.banque.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepo;

    public Client authenticate(String email, String password) {
        Client client = clientRepo.findByEmail(email);
        if (client != null && client.getPassword().equals(password)) {
            return client;
        } else {
            return null;
        }

    }
}
