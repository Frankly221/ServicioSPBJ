package com.App.APP.Entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="person")
@Entity
@Builder

public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    @OneToMany(mappedBy = "persona")
    private List<Diagnostico> diagnosticos;
    
    @OneToOne(mappedBy= "persona")
    private Usuario usuario;

    @OneToMany(mappedBy = "persona")
    private List<Telefono> telefonosecundario;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "id_doc")
    private Tip_Doc tip_doc;

      
}
