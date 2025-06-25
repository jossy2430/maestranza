package com.example.ms_maestranza_db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ms_maestranza_db.model.DetalleOrdenSalida;

@Repository
public interface DetalleOrdenSalidaRepository extends JpaRepository<DetalleOrdenSalida, Integer>{
    //usando jpql
    @Query("SELECT d FROM DetalleOrdenSalida d WHERE d.idDetalle = :idDetalle")
    List<DetalleOrdenSalida> buscarPorAi(@Param("idDetalle") Integer idDetalle);   

}
