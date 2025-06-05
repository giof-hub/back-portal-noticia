package br.com.giovanni.projeto.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "NOTICIA")
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "CONTEUDO")
    private String conteudo;

    @Column(name = "DATAPUBLICACAO")
    private Date dataPublicacao;

    @JoinColumn(name = "IDCATEGORIA", referencedColumnName = "ID")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Categoria categoria;

    @JoinColumn(name = "IDAUTOR", referencedColumnName = "ID")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Autor autor;
}
