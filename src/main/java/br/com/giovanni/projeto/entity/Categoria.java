package br.com.giovanni.projeto.entity;


import br.com.giovanni.projeto.models.CategoriaDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "CATEGORIA")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @JoinColumn(name = "IDCATEGORIAPAI", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Categoria categoriaPai;

    @Column(name = "IDCATEGORIAPAI")
    private Long idCategoriaPai;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoriaPai")
    private List<Categoria> categorias;

    public static Categoria convert(CategoriaDTO categoriaDTO) {
        return Categoria
                .builder()
                .id(categoriaDTO.getId())
                .descricao(categoriaDTO.getDescricao())
                .idCategoriaPai(categoriaDTO.getIdCategoriaPai())
                .build();
    }
}
