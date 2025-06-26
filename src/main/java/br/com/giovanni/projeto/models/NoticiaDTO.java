package br.com.giovanni.projeto.models;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoticiaDTO {

    private Long id;
    private String titulo;
    private String conteudo;
    private Long idDocumento;
    private Long idCategoria;
    private Date dataPublicacao;
}
