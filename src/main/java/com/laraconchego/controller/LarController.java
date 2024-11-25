package com.laraconchego.controller;

import com.laraconchego.model.Lar;
import com.laraconchego.repository.LarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LarController {

    @Autowired
    private LarRepository larRepository;

    // Endpoint para listar todos os LARs
    @GetMapping
    public List<Lar> getLars() {
        return larRepository.findAllLars();  // O método findAll() já é fornecido pelo Spring Data JPA
    }

    // Endpoint para criar um novo LAR
    @PostMapping
    public Lar createLar(@RequestBody Lar lar) {
        return larRepository.save(lar);  // O método save() já é fornecido pelo Spring Data JPA
    }

    // Endpoint para deletar um LAR pelo ID
    @DeleteMapping("/{id}")
    public void deleteLar(@PathVariable Long id) {
        larRepository.deleteLarById(id);  // O método deleteById() já é fornecido pelo Spring Data JPA
    }
}
