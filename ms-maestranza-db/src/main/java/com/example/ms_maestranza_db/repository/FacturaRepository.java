package com.example.ms_maestranza_db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ms_maestranza_db.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer>{
    //usando jpql
    @Query("SELECT f FROM Factura f WHERE f.idFactura = :idFactura")
    List<Factura> buscarPorAi(@Param("idFactura") Integer idFactura);   

}
