package br.com.giovanni.projeto.entity;

import br.com.giovanni.projeto.models.NoticiaDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Builder
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

    @JoinColumn(name = "IDCATEGORIA", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Categoria categoria;

    @Column(name = "IDCATEGORIA")
    private Long idCategoria;

    @JoinColumn(name = "IDAUTOR", referencedColumnName = "ID")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Autor autor;

    @JoinColumn(name = "IDDOCUMENTO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private NoticiaDocumento noticiaDocumento;

    @Column(name = "IDDOCUMENTO")
    private Long idDocumento;

    public static Noticia converter(NoticiaDTO noticiaDTO) {
        return Noticia.builder()
                .dataPublicacao(new Date(System.currentTimeMillis()))
                .idDocumento(noticiaDTO.getIdDocumento())
                .titulo(noticiaDTO.getTitle())
                .conteudo(noticiaDTO.getContent())
                .idCategoria(noticiaDTO.getIdCategoria())
                .build();
    }
}
