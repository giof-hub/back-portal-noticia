package br.com.giovanni.projeto.models;

import br.com.giovanni.projeto.entity.Noticia;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoticiaResponseDTO {

    private Long id;
    private String titulo;
    private String conteudo;
    private String documento;
    private String categoria;
    private Date dataPublicacao;
    private String autor;
    private String path;

    public static NoticiaResponseDTO converter(Noticia noticia) {
        return NoticiaResponseDTO.builder()
                .id(noticia.getId())
                .titulo(noticia.getTitulo())
                .conteudo(noticia.getConteudo())
                .documento(noticia.getNoticiaDocumento().getPath())
                .categoria(noticia.getCategoria().getDescricao())
                .dataPublicacao(noticia.getDataPublicacao())
                .autor(noticia.getAutor() != null ? noticia.getAutor().getPessoa().getNome() : null)
                .build();
    }
}
