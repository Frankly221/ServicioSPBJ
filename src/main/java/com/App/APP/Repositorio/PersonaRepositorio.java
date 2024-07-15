package com.App.APP.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.APP.Entity.Persona;



@Repository

public interface  PersonaRepositorio extends JpaRepository<Persona, Integer> {


    
}
