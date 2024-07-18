package com.App.APP.Entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private int edad;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name ="id_esta_diag")
    private Esta_Diag esta_diag;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name ="idpersona")
    private Persona persona;


    @OneToMany(mappedBy= "diagnostico")
    List<Sesiones> sesiones;

    @OneToMany(mappedBy = "diagnostico")
    List<Pago> pagos;

}
