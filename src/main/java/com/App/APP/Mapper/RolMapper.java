package com.App.APP.Mapper;

import com.App.APP.DTO.RolDTO;
import com.App.APP.Entity.Rol;

public class RolMapper {

    public static RolDTO DatosToDTO(Rol rol){
        
        return RolDTO.builder()
       .idrol(rol.getIdrol())
       .nombre_rol(rol.getNombre_rol())
       .build();
    }
    

    public static Rol DatosToEntity(RolDTO rolDTO){

        return Rol.builder()
        .idrol(rolDTO.getIdrol())
        .nombre_rol(rolDTO.getNombre_rol())
        .build();
       
    }
}
