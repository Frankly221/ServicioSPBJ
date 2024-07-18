package com.App.APP.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="usuario")

public class Usuario {

    //g
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idusuario;

    private String username;

    private String password;

    @OneToOne
    @JoinColumn(name ="idpersona")
    private Persona persona;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "idrol")
    private Rol rol;
    
}
