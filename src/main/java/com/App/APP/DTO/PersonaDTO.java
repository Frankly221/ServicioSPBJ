package com.App.APP.DTO;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int telefono;

    private List<DiagnosticoDTO> diagnosticosDTO;
    private List<TelefonoDTO> telefonoDTO;
    private Tip_DocDTO tip_docDTO;




}
