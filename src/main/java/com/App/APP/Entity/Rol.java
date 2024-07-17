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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rol")
@Builder
@Entity


public class Rol {

    //H
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrol;

    private String nombre_rol;
}
