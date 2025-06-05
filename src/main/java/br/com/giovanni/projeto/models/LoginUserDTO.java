package br.com.giovanni.projeto.models;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class LoginUserDTO implements Serializable {

    private String login;
    private String password;
}
