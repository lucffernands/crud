package com.devsuperior.crud.controllers;

import com.devsuperior.crud.dto.ClientDTO;
import com.devsuperior.crud.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public Page<ClientDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public ClientDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ClientDTO insert(@Valid @RequestBody ClientDTO dto) {
        return service.insert(dto);
    }

    @PutMapping(value = "/{id}")
    public ClientDTO update(@PathVariable Long id, @Valid @RequestBody ClientDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
