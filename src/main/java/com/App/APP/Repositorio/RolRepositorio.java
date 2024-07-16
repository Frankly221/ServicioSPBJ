package com.App.APP.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.APP.Entity.Rol;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer> {
    
}
