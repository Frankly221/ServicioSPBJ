package com.App.APP.Mapper;

import com.App.APP.DTO.UsuarioDTO;
import com.App.APP.Entity.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO DatosToDTO(Usuario usuario){



        return UsuarioDTO.builder()
        .idusuario(usuario.getIdusuario())
        .username(usuario.getUsername())
        .password(usuario.getPassword())
        .build();
        
    }

    public static Usuario DatosToEntity(UsuarioDTO usuarioDTO){

        return Usuario
         .builder()
         .idusuario(usuarioDTO.getIdusuario())
         .username(usuarioDTO.getUsername())
         .password(usuarioDTO.getPassword())
         .build();

    }
    
}
