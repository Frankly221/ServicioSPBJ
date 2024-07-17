package com.App.APP.DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiagnosticoDTO {
    
    private int idhc;
    private Date inic_enferm;
    private String etiologia;
    private String diagnostico;
    private String observacion;
    private Date fecha_eval;
    private Double peso;
    private Double talla;
    private String enf_cronica;
    private int n_sesion;
    private String plan_pago;
    private Double monto_total;
    private int persona_idpersona;

}
