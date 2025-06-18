package br.com.giovanni.projeto.models;

import br.com.giovanni.projeto.entity.Categoria;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CategoriaDTO implements Serializable {

    private Long id;
    private String descricao;
    private List<CategoriaDTO> subCategorias;

    public static CategoriaDTO convert(Categoria categoria) {

        List<CategoriaDTO> subCategories = new ArrayList<>();

        for (Categoria sub : categoria.getCategorias()) {
            subCategories.add(CategoriaDTO.convert(sub));
        }

        return CategoriaDTO
                .builder()
                .id(categoria.getId())
                .descricao(categoria.getDescricao())
                .subCategorias(subCategories)
                .build();
    }
}
