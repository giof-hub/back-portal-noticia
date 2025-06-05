package br.com.giovanni.projeto.models;

import br.com.giovanni.projeto.entity.Categoria;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CategoriaDTO implements Serializable {

    private Long id;
    private String descricao;
    private Long idCategoriaPai;

    public static CategoriaDTO convert(Categoria categoria) {
        return CategoriaDTO
                .builder()
                .id(categoria.getId())
                .descricao(categoria.getDescricao())
                .idCategoriaPai(categoria.getIdCategoriaPai())
                .build();
    }
}
