package com.App.APP.Mapper;

import com.App.APP.DTO.TelefonoDTO;
import com.App.APP.Entity.Telefono;

public class TelefonoMapper {

    public static TelefonoDTO DatosToDTO(Telefono telefono){
        return TelefonoDTO.builder()
                .idtf(telefono.getIdtf())
                .telefono(telefono.getTelefono())
                .build();
    }

    public static Telefono DatosToEntity(TelefonoDTO telefonoDTO){


        return Telefono.builder()
                .idtf(telefonoDTO.getIdtf())
                .telefono(telefonoDTO.getTelefono())
                .build();
    }
    
}
