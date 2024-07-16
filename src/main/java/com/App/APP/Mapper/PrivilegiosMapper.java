package com.App.APP.Mapper;

import com.App.APP.DTO.PrivilegiosDTO;
import com.App.APP.Entity.Privilegios;

public class PrivilegiosMapper {


    public static PrivilegiosDTO DatosToDTO(Privilegios privilegios) {


        return PrivilegiosDTO.builder()
                .id_privilegio(privilegios.getId_privilegio())
                .url(privilegios.getUrl())
                .nombreprivi(privilegios.getNombreprivi())
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
