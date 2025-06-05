package br.com.giovanni.projeto.service;

import br.com.giovanni.projeto.entity.Usuario;
import br.com.giovanni.projeto.models.UserDetailsDTO;
import br.com.giovanni.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> user = userRepository.findByLogin(username);

        if (user.isPresent()) {
            System.out.println(user.get().getLogin());
        }

        return new UserDetailsDTO(user.get());
    }
}
