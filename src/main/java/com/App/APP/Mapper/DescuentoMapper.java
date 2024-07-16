package com.App.APP.Mapper;

import com.App.APP.DTO.DescuentoDTO;
import com.App.APP.Entity.Descuento;

public class DescuentoMapper {
    public static DescuentoDTO DatosToDTO(Descuento descuento) {
        return DescuentoDTO.builder()
                .id(descuento.getId())
                .n_sesiones(descuento.getN_sesiones())
                .descuento(descuento.getDescuento())
                .build();
    }

    public static Descuento DatosToEntity(DescuentoDTO descuentoDTO) {
        return Descuento.builder()
                .id(descuentoDTO.getId())
                .n_sesiones(descuentoDTO.getN_sesiones())
                .descuento(descuentoDTO.getDescuento())
                .build();
    }
}
