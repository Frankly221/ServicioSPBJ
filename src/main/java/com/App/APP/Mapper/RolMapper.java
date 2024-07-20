package com.App.APP.Mapper;

import com.App.APP.DTO.RolDTO;
import com.App.APP.Entity.Rol;

public class RolMapper {

    public static RolDTO DatosToDTO(Rol rol){

        //  List<Priv_RolDTO> priv_rolesDTO =  rol.getPriv_rol().stream().map
        // (Priv_RolMapper::DatosToDTO).collect(Collectors.toList());

        
        return RolDTO.builder()
       .idrol(rol.getIdrol())
       .nombre_rol(rol.getNombre_rol())
    //    .priv_rolDTO(priv_rolesDTO)
       .build();
    }
    

    public static Rol DatosToEntity(RolDTO rolDTO){

        return Rol.builder()
        .idrol(rolDTO.getIdrol())
        .nombre_rol(rolDTO.getNombre_rol())
        .build();
       
    }
}
