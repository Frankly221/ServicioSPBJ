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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tip_doc")

public class Tip_Doc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_doc;
    private String nombre_doc;

    @OneToMany(mappedBy= "tip_doc")
    private List<Persona> persona;
    
}
