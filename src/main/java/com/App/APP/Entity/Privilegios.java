package com.App.APP.Entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name ="privilegios")

public class Privilegios {

    //H
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_privilegio;

    private String url;

    private String nombreprivi;

    @OneToMany(mappedBy = "privilegios")
    private List<Priv_Rol> priv_rol;



}
