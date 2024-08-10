package com.App.APP.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.App.APP.Entity.Telefono;

@Repository
public interface TelefonoRepository extends JpaRepository<Telefono, Integer> {
    @Query("SELECT t FROM Telefono t WHERE t.persona.id = :id")
    public List<Telefono> findByPersonaId(Integer id);
}
