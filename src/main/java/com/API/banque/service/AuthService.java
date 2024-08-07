package com.API.banque.service;
import com.API.banque.repository.ClientRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.API.banque.entity.Client;

import java.util.Date;

@Service
public class AuthService {

    @Autowired
    private ClientRepository clientRepo;

    @Value("${jwt.secret}")
    private String secret;

    public String authenticate(String email, String password) {
        Client client = clientRepo.findByEmail(email);
        if (client != null && client.getPassword().equals(password)) {
            return generateJwtToken(client);
        }
        throw new RuntimeException("Invalid credentials");
    }

    private String generateJwtToken(Client client) {
        return Jwts.builder()
                .setSubject(client.getEmail())
                .claim("roles", client.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 jour
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
