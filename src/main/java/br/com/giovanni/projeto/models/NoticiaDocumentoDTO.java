package br.com.giovanni.projeto.models;

import br.com.giovanni.projeto.entity.NoticiaDocumento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticiaDocumentoDTO {

    private Long id;
    private String path;
    private String fullPath;

    public static NoticiaDocumentoDTO convert(NoticiaDocumento noticiaDocumento) {
        return NoticiaDocumentoDTO.builder()
                .id(noticiaDocumento.getId())
                .path(noticiaDocumento.getPath())
                .fullPath(noticiaDocumento.getFullPath())
                .build();
    }
}
