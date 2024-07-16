package com.App.APP.Mapper;

import com.App.APP.DTO.Priv_RolDTO;
import com.App.APP.Entity.Priv_Rol;

public class Priv_RolMapper {


    public static Priv_RolDTO DatosToDTO(Priv_Rol priva_rol){


        return Priv_RolDTO.builder()
        .id_priv_rol(priva_rol.getId_priv_rol())
        .privilegios_idpri(priva_rol.getPrivilegios_idpri())
        .rol_idrol(priva_rol.getRol_idrol())
        .build();
                
    }

    public static Priv_Rol DatosToEntity(Priv_RolDTO priva_rolDTO){

        return Priv_Rol.builder()
        .id_priv_rol(priva_rolDTO.getId_priv_rol())
        .privilegios_idpri(priva_rolDTO.getPrivilegios_idpri())
        .rol_idrol(priva_rolDTO.getRol_idrol())
        .build();
    }




    
}
