// src/main/java/com/laraconchego/controller/DicaController.java
package com.laraconchego.controller;

import com.laraconchego.model.Dica;
import com.laraconchego.model.Dica;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DicaController {
    private List<Dica> dicas = new ArrayList<>();

    @GetMapping
    public List<Dica> getDicas() {
        return dicas;
    }

    @PostMapping
    public Dica addDica(@RequestBody Dica dica) {
        dicas.add(dica);
        return dica;
    }
}
