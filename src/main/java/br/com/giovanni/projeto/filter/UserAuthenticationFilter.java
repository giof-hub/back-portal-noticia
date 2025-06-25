package br.com.giovanni.projeto.filter;

import br.com.giovanni.projeto.configuration.SecurityConfiguration;
import br.com.giovanni.projeto.entity.Usuario;
import br.com.giovanni.projeto.models.UserDetailsDTO;
import br.com.giovanni.projeto.repository.UsuarioRepository;
import br.com.giovanni.projeto.service.JwtTokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

@Component
public class UserAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        if (checkIfEndpointIsNotPublic(request)) {
//            String token = recoveryToken(request);
//            if (token != null) {
//                String subject = jwtTokenService.getSubjectFromToken(token);
//                Usuario user = userRepository.findByLogin(subject).get();
//                UserDetailsDTO userDetails = new UserDetailsDTO(user);
//
//                Authentication authentication =
//                        new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());
//
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            } else {
//                throw new RuntimeException("O token está ausente.");
//            }
//        }
        filterChain.doFilter(request, response);
    }

    private String recoveryToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }

    // Verifica se o endpoint requer autenticação antes de processar a requisição
    private boolean checkIfEndpointIsNotPublic(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return !Arrays.asList(SecurityConfiguration.ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED).contains(requestURI);
    }

}