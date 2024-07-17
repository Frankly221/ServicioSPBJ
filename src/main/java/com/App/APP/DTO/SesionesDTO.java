package com.App.APP.DTO;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SesionesDTO {
    
    private int id_sesion;
    private Date fecha;
    private String descripcion;
    private Boolean tipo;
    private Time hora;
    private Boolean asistio;
    private int diagnostico_idhc;

}
