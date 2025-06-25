package com.example.ms_maestranza_db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ms_maestranza_db.model.MovimientoInventario;

@Repository
public interface MovimientoInventarioRepository extends JpaRepository<MovimientoInventario, Integer>{
    //usando jpql
    @Query("SELECT m FROM MovimientoInventario m WHERE m.idInventario = :idInventario")
    List<MovimientoInventario> buscarPorAi(@Param("idInventario") Integer idInventario);   

}
