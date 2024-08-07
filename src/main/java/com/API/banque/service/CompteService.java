package com.API.banque.service;

import com.API.banque.entity.Compte;
import com.API.banque.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteService {
    @Autowired
    private CompteRepository compteRepository;

    public Double getSolde(String numeroCompte) {
        Compte compte = compteRepository.findByNumeroCompte(numeroCompte);
        if (compte != null) {
            return compte.getSolde();
        } else {
            throw new RuntimeException("Compte non trouvé");
        }
    }
    public Compte getCompte(String numeroCompte) {
        return compteRepository.findByNumeroCompte(numeroCompte);
    }
    /*

    public String getName(String numeroCompte) {
        Compte compte = compteRepository.findByNumeroCompte(numeroCompte);
        if (compte != null) {
            return compte.getName();
        } else {
            throw new RuntimeException("Compte non trouvé");
        }
    }* Ceci est un commentaire
     * qui s'étend sur plusieurs lignes.
     */
}
