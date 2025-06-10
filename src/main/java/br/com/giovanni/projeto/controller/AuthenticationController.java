package br.com.giovanni.projeto.controller;

import br.com.giovanni.projeto.models.LoginUserDTO;
import br.com.giovanni.projeto.models.RecoveryJwtTokenDTO;
import br.com.giovanni.projeto.models.ResultDTO;
import br.com.giovanni.projeto.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("v1/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUserDTO loginUserDTO, HttpServletResponse response) throws IOException {
        RecoveryJwtTokenDTO token = userService.authenticateUser(loginUserDTO);
        return new ResponseEntity<>(new ResultDTO<>(token.getToken()), HttpStatus.OK);
    }
}
