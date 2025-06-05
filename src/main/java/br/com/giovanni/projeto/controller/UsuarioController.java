package br.com.giovanni.projeto.controller;


import br.com.giovanni.projeto.models.UserDTO;
import br.com.giovanni.projeto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<Void> login(@RequestBody UserDTO userDTO) {


        return ResponseEntity.ok().build();
    }
}
