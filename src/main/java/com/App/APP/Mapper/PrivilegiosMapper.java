package com.App.APP.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.App.APP.DTO.Priv_RolDTO;
import com.App.APP.DTO.PrivilegiosDTO;
import com.App.APP.Entity.Privilegios;


public class PrivilegiosMapper {


    public static PrivilegiosDTO DatosToDTO(Privilegios privilegios) {

        List<Priv_RolDTO> priv_rolesDTO =  privilegios.getPriv_rol().stream().map
        (Priv_RolMapper::DatosToDTO).collect(Collectors.toList());

        return PrivilegiosDTO.builder()
                .id_privilegio(privilegios.getId_privilegio())
                .url(privilegios.getUrl())
                .nombreprivi(privilegios.getNombreprivi())
                .priv_rolDTO(priv_rolesDTO)
                .build();
    }

    public static Privilegios DatosToEntity(PrivilegiosDTO privilegiosDTO) {


        return Privilegios.builder()
                .id_privilegio(privilegiosDTO.getId_privilegio())
                .url(privilegiosDTO.getUrl())
                .nombreprivi(privilegiosDTO.getNombreprivi())
                .build();
    }
   




    
}
