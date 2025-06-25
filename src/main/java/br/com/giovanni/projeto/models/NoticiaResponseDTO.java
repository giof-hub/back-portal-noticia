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
    private String title;
    private String content;
    private String documento;
    private String categoria;
    private Date dataPublicacao;
    private String autor;

    public static NoticiaResponseDTO converter(Noticia noticia) {
        return NoticiaResponseDTO.builder()
                .id(noticia.getId())
                .title(noticia.getTitulo())
                .content(noticia.getConteudo())
                .documento(noticia.getNoticiaDocumento().getPath())
                .categoria(noticia.getCategoria().getDescricao())
                .dataPublicacao(noticia.getDataPublicacao())
                .autor(noticia.getAutor().getPessoa().getNome())
                .build();
    }
}
