package com.App.APP.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UsuarioDTO {
    private int idusuario;

    private String username;

    private String password;

    private int persona_idpersona;

    private int rol_idrol;
    
}
