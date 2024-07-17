package com.App.APP.Mapper;

import com.App.APP.DTO.UsuarioDTO;
import com.App.APP.Entity.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO DatosToDTO(Usuario usuario){



        return UsuarioDTO.builder()
        .idusuario(usuario.getIdusuario())
        .username(usuario.getUsername())
        .password(usuario.getPassword())
        .persona_idpersona(usuario.getPersona_idpersona())
        .rol_idrol(usuario.getRol_idrol())
        .build();
        
    }

    public static Usuario DatosToEntity(UsuarioDTO usuarioDTO){

        return Usuario
         .builder()
         .idusuario(usuarioDTO.getIdusuario())
         .username(usuarioDTO.getUsername())
         .password(usuarioDTO.getPassword())
         .persona_idpersona(usuarioDTO.getPersona_idpersona())
         .rol_idrol(usuarioDTO.getRol_idrol())
         .build();

    }
    
}
