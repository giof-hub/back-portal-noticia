package br.com.giovanni.projeto.controller;

import br.com.giovanni.projeto.models.CategoriaDTO;
import br.com.giovanni.projeto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author giovanni.5160
 */
//@RestController
//@RequestMapping("category")
public class CategoriaController {

//    @Autowired
//    private CategoriaService service;
//
//    @GetMapping
//    public ResponseEntity<List<CategoriaDTO>> listAll() {
//        List<CategoriaDTO> categorias = service.findAll();
//
//        return ResponseEntity.ok(categorias);
//    }
//
//    @GetMapping(name = "{id}")
//    public ResponseEntity<CategoriaDTO> findById(@PathVariable(name = "id") Long id) {
//        CategoriaDTO categorias = service.findById(id);
//
//        return ResponseEntity.ok(categorias);
//    }
//
//    @PostMapping
//    public ResponseEntity<CategoriaDTO> insert(@RequestBody CategoriaDTO categoriaDTO) {
//        CategoriaDTO categoria = service.save(categoriaDTO);
//
//        return ResponseEntity.ok(categoria);
//    }
//
//    @PutMapping(name = "{id}")
//    public ResponseEntity<CategoriaDTO> update(@PathVariable(name = "id") Long id,
//                                               @RequestBody CategoriaDTO categoriaDTO) {
//        CategoriaDTO categoria = service.update(id, categoriaDTO);
//
//        return ResponseEntity.ok(categoria);
//    }
//
//    @DeleteMapping(name = "{id}")
//    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
//        service.delete(id);
//
//        return ResponseEntity.ok("Success");
//    }
}
