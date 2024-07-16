package com.App.APP.Entity;

import jakarta.persistence.Entity;
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

    private int id_priv_rol;


    private int privilegios_idpri;

    private int rol_idrol;


    
}
