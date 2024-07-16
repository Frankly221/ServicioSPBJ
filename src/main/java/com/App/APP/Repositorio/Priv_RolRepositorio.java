package com.App.APP.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.APP.Entity.Priv_Rol;

@Repository

public interface Priv_RolRepositorio extends JpaRepository<Priv_Rol, Integer> {
    
}
