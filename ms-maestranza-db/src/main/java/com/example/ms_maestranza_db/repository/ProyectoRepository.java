package com.example.ms_maestranza_db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ms_maestranza_db.model.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer>{
    //usando jpql
    @Query("SELECT p FROM Proyecto p WHERE p.idProyecto = :idProyecto")
    List<Proyecto> buscarPorAi(@Param("idProyecto") Integer idProyecto);   

}
