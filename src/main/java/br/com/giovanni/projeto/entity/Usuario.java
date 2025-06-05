package br.com.giovanni.projeto.entity;

import br.com.giovanni.projeto.models.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @JoinColumn(name = "IDPESSOA", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Pessoa pessoa;

    @Column(name = "IDPESSOA")
    private Long idPessoa;

    public static Usuario convert(UserDTO userDTO) {
        return Usuario
                .builder()
                .id(userDTO.getId())
                .login(userDTO.getLogin())
                .password(userDTO.getPassword())
                .idPessoa(userDTO.getIdPessoa())
                .build();
    }
}
