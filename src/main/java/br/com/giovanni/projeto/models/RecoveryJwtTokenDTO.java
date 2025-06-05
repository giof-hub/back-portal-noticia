package br.com.giovanni.projeto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RecoveryJwtTokenDTO {
    private String token;
}
