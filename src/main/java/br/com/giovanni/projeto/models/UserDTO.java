package br.com.giovanni.projeto.models;

import br.com.giovanni.projeto.entity.Usuario;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserDTO implements Serializable {

    private Long id;
    private String login;
    private String password;
    private Long idPessoa;

    public static UserDTO convert(Usuario usuario) {
        return UserDTO
                .builder()
                .id(usuario.getId())
                .login(usuario.getLogin())
                .password(usuario.getPassword())
                .idPessoa(usuario.getIdPessoa())
                .build();
    }
}
