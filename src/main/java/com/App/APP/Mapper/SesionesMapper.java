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
                .diagnostico_idhc(sesiones.getDiagnostico_idhc())
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
                .diagnostico_idhc(sesionesDTO.getDiagnostico_idhc())
                .build();
    }

}
