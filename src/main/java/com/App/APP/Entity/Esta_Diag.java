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

@Data
@Builder
@Entity
@Table(name = "esta_diag")
@NoArgsConstructor
@AllArgsConstructor

public class Esta_Diag {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_esta_diag;
    
    private String estado;

    @OneToMany(mappedBy = "esta_diag")
    List<Diagnostico> diagnosticos;
    
}
