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


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="priv_rol")

public class Priv_Rol {

    //G
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_priv_rol;


    private int privilegios_idpri;

    private int rol_idrol;


    
}
