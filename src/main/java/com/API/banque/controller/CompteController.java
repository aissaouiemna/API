package com.API.banque.controller;

import com.API.banque.entity.Compte;
import com.API.banque.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {
    @Autowired
    private CompteService compteService;

    @GetMapping("/solde/{numeroCompte}")
    public Double getSolde(@PathVariable String numeroCompte){
        return compteService.getSolde(numeroCompte);
    }

    @GetMapping("/compte/{numeroCompte}")
    public ResponseEntity<Compte> getSoldes(@PathVariable String numeroCompte) {
        Compte compte = compteService.getCompte(numeroCompte);
        if (compte != null) {
            return ResponseEntity.ok(compte);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*
    @GetMapping("/consulte/{numeroCompte}")
    public String getSoldeandName(@PathVariable String numeroCompte){
        System.out.println("Monsieur " + compteService.getSolde(numeroCompte)+ "a" +compteService.getSolde(numeroCompte)+ "dinars" );
    }
    */

}
