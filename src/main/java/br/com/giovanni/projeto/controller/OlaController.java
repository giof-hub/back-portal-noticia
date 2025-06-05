package br.com.giovanni.projeto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author giovanni.5160
 */
@RestController
@RequestMapping("/ola")
public class OlaController {

    @GetMapping(path = "")
    public ResponseEntity<?> t() {
        return ResponseEntity.ok("Success");
    }

}
