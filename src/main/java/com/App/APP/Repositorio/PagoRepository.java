package com.App.APP.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.App.APP.Entity.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
    @Query("SELECT p FROM Pago p WHERE p.diagnostico.idhc = :id")
    public List<Pago> findByDiagnosticoId(Integer id);
}
