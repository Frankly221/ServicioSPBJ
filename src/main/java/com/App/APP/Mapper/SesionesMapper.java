package com.App.APP.Mapper;

import com.App.APP.DTO.SesionesDTO;
import com.App.APP.Entity.Sesiones;

public class SesionesMapper {
    public static SesionesDTO DatosToDTO(Sesiones sesiones) {
        return SesionesDTO.builder()
                .id_sesion(sesiones.getId_sesion())
                .fecha(sesiones.getFecha())
                .descripcion(sesiones.getDescripcion())
                .tipo(sesiones.getTipo())
                .hora(sesiones.getHora())
                .asistio(sesiones.getAsistio())
                .build();
    }

    public static Sesiones DatosToEntity(SesionesDTO sesionesDTO) {
        return Sesiones.builder()
                .id_sesion(sesionesDTO.getId_sesion())
                .fecha(sesionesDTO.getFecha())
                .descripcion(sesionesDTO.getDescripcion())
                .tipo(sesionesDTO.getTipo())
                .hora(sesionesDTO.getHora())
                .asistio(sesionesDTO.getAsistio())
                .build();
    }

    public static SesionesDTO DatosToDTOOnlyEstado(Sesiones sesiones){

        return SesionesDTO.builder()
        .id_sesion(sesiones.getId_sesion())
        .asistio(sesiones.getAsistio())
        .build();



    }

}
