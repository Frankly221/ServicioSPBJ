package com.App.APP.Entity;

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



    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "id_privilegio")
    private Privilegios privilegios;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "idrol")
    private Rol rol;

    
}
