package com.App.APP.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.APP.Entity.Sesiones;

@Repository
public interface SesionesRepository extends JpaRepository<Sesiones, Integer>{

}
