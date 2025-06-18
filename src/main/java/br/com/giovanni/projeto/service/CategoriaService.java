package br.com.giovanni.projeto.service;

import br.com.giovanni.projeto.entity.Categoria;
import br.com.giovanni.projeto.models.CategoriaDTO;
import br.com.giovanni.projeto.models.MenuDTO;
import br.com.giovanni.projeto.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public CategoriaDTO findById(Long id) {
        Optional<Categoria> categoria = repository.findById(id);

        return categoria.map(CategoriaDTO::convert).orElse(null);

    }

    public List<MenuDTO> findAll() {

        List<Categoria> categories = repository.getParentCategories();

        List<MenuDTO> menus = new ArrayList<>();

        for (Categoria category : categories) {
            menus.add(MenuDTO.convert(category));
        }

        return menus;
    }

//    public CategoriaDTO save(CategoriaDTO categoriaDTO) {
//        Categoria categoria = Categoria.convert(categoriaDTO);
//
//        repository.save(categoria);
//
//        categoriaDTO.setId(categoria.getId());
//
//        return categoriaDTO;
//    }
//
//    public CategoriaDTO update(Long id, CategoriaDTO categoriaDTO) {
//        Optional<Categoria> categoriaOpt = repository.findById(id);
//
//        if (categoriaOpt.isPresent()) {
//            Categoria categoria = categoriaOpt.get();
//
//            categoria.setIdCategoriaPai(categoriaDTO.getIdCategoriaPai());
//            categoria.setDescricao(categoriaDTO.getDescricao());
//
//            repository.save(categoria);
//        }
//
//        return categoriaDTO;
//    }
//
//    public void delete(Long id) {
//        repository.deleteById(id);
//    }
}
