package com.App.APP.Entity;

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

    private int persona_idpersona;

    private int rol_idrol;
    
}
