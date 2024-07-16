package com.App.APP.Mapper;

import com.App.APP.DTO.TarifarioDTO;
import com.App.APP.Entity.Tarifario;

public class TarifarioMapper {
    public static TarifarioDTO DatosToDTO(Tarifario tarifario) {
        return TarifarioDTO.builder()
                .id(tarifario.getId())
                .precio(tarifario.getPrecio())
                .build();
    }

    public static Tarifario DatosToEntity(TarifarioDTO tarifarioDTO) {
        return Tarifario.builder()
                .id(tarifarioDTO.getId())
                .precio(tarifarioDTO.getPrecio())
                .build();
    }
}
