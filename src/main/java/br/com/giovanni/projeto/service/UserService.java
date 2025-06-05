package br.com.giovanni.projeto.service;

import br.com.giovanni.projeto.configuration.SecurityConfiguration;
import br.com.giovanni.projeto.entity.Usuario;
import br.com.giovanni.projeto.models.LoginUserDTO;
import br.com.giovanni.projeto.models.RecoveryJwtTokenDTO;
import br.com.giovanni.projeto.models.UserDetailsDTO;
import br.com.giovanni.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    public RecoveryJwtTokenDTO authenticateUser(LoginUserDTO loginUserDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.getLogin(), loginUserDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        UserDetailsDTO userDetails = (UserDetailsDTO) authentication.getPrincipal();

        return new RecoveryJwtTokenDTO(jwtTokenService.generateToken(userDetails));
    }
}
