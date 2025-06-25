package br.com.giovanni.projeto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "NOTICIA_DOCUMENTO")
public class NoticiaDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PATH")
    private String path;

    @Column(name = "FULLPATH")
    private String fullPath;
}
