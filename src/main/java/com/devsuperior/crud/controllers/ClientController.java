package com.devsuperior.crud.controllers;

import com.devsuperior.crud.dto.ClientDTO;
import com.devsuperior.crud.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public Page<ClientDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

}
