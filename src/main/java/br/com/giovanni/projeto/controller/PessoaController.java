package br.com.giovanni.projeto.controller;

import br.com.giovanni.projeto.models.PessoaDTO;
import br.com.giovanni.projeto.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    public ResponseEntity<String> insert(@RequestBody PessoaDTO pessoa) {
        service.insert(pessoa);

        return ResponseEntity.ok("Success");
    }

}
