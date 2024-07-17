package com.App.APP.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="diagnostico")
@Entity
@Builder
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
