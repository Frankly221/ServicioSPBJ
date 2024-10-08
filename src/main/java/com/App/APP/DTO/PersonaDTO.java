package com.App.APP.DTO;

import java.util.Date;
import java.util.List;

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

public class PersonaDTO {

    private int idpersona;    
    private String nombre;
    private String apellido;
    private String domicilio;
    private Date fecha_nac;
    private  String lugar_nac;
    private String residencia;
    private String estado_civil;
    private int n_hijos;
    private String referencia;
    private Boolean tipo_documento;
    private int ndoc_documento;
    private String correo;
    private Boolean genero;
    private int telefono;
     private List<DiagnosticoDTO> diagnosticosDTO;
    private List<TelefonoDTO> telefonosDTO;
    // private Tip_DocDTO tip_docDTO;




}
