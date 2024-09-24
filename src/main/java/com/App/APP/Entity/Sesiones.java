package com.App.APP.Entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sesiones")
@Entity
@Builder
public class Sesiones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sesion;

    private Date fecha;
    private String descripcion;
    private Boolean tipo;
    private Time hora;
    private Boolean asistio;
    private Boolean esSesion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idhc")
    private Diagnostico diagnostico;

}
