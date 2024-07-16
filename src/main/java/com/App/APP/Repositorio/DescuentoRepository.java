package com.App.APP.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.APP.Entity.Descuento;

@Repository
public interface DescuentoRepository extends JpaRepository<Descuento, Integer> {

}
