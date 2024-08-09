package com.App.APP.Repositorio;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.App.APP.Entity.Persona;



@Repository

public interface  PersonaRepositorio extends JpaRepository<Persona, Integer> {
    @Query("SELECT DISTINCT p FROM Persona p " +
    "JOIN p.diagnosticos d " +
    "JOIN d.sesiones s " +
    "WHERE s.fecha = :fecha")
List<Persona> findPersonasBySesionFecha(@Param("fecha") Date fecha);


    
}
