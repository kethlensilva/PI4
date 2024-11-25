package com.laraconchego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.laraconchego.model.Login;
import com.laraconchego.repository.LoginRepository;

@RestController
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private LoginRepository loginRepository;

    @PostMapping
    public String signUp(@RequestParam String username, @RequestParam String password) {
        // Verifica se o username já existe
        if (loginRepository.findByUsername(username) != null) {
            return "Usuário já cadastrado!";
        }

        // Salva o novo usuário
        Login login = new Login(username, password);
        loginRepository.save(login);

        return "Cadastro realizado com sucesso!";
    }
}
