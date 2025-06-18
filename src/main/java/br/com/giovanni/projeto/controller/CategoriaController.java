package br.com.giovanni.projeto.controller;

import br.com.giovanni.projeto.models.MenuDTO;
import br.com.giovanni.projeto.models.ResultDTO;
import br.com.giovanni.projeto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author giovanni.5160
 */
@RestController
@RequestMapping("v1/category")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<ResultDTO<List<MenuDTO>>> listAll() {
        List<MenuDTO> categorias = service.findAll();

        return ResponseEntity.ok(new ResultDTO<>(categorias));
    }

//    @GetMapping(name = "{id}")
//    public ResponseEntity<CategoriaDTO> findById(@PathVariable(name = "id") Long id) {
//        CategoriaDTO categorias = service.findById(id);
//
//        return ResponseEntity.ok(categorias);
//    }
}
