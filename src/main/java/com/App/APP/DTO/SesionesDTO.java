package com.App.APP.DTO;

import java.sql.Date;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)

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

    //  private DiagnosticoDTO diagnosticoDTO;


}
