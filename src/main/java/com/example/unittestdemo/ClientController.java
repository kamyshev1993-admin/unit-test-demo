package com.example.unittestdemo;


import model.Client;
import model.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;

@RestController
public class ClientController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private ClientRepository clientRepository;

    ClientController() {
        clientRepository = new ClientRepository(jdbcTemplate);
    }

    @GetMapping(path = "/get")
    public Client getById(@RequestParam long id) {
        return clientRepository.findById(id);
    }
}
