package com.App.APP.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.APP.Entity.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {

}
