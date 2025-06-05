package br.com.giovanni.projeto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "AUTOR")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BIOGRAFIA")
    private String biografia;

    @JoinColumn(name = "IDPESSOA")
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Pessoa pessoa;
}
