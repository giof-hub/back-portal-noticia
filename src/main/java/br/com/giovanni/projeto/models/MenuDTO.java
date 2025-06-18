package br.com.giovanni.projeto.models;

import br.com.giovanni.projeto.entity.Categoria;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class MenuDTO implements Serializable {

    private Long id;
    private String description;
    private List<MenuDTO> subMenu;

    public static MenuDTO convert(Categoria categoria) {

        List<MenuDTO> subMenu = new ArrayList<>();

        for (Categoria sub : categoria.getCategorias()) {
            subMenu.add(MenuDTO.convert(sub));
        }

        return MenuDTO
                .builder()
                .id(categoria.getId())
                .description(categoria.getDescricao())
                .subMenu(subMenu)
                .build();
    }
}
