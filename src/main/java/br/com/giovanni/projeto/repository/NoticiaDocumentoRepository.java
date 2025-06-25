package br.com.giovanni.projeto.repository;

import br.com.giovanni.projeto.entity.NoticiaDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaDocumentoRepository extends JpaRepository<NoticiaDocumento, Long> {
}
