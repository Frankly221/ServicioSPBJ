package com.App.APP.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.APP.Entity.Tarifario;

@Repository
public interface TarifarioRepository extends JpaRepository<Tarifario, Integer> {

}
