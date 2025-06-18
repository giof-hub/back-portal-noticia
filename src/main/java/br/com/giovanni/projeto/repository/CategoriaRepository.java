package br.com.giovanni.projeto.repository;

import br.com.giovanni.projeto.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("SELECT c FROM Categoria c WHERE c.idCategoriaPai IS NULL")
    List<Categoria> getParentCategories();

}
