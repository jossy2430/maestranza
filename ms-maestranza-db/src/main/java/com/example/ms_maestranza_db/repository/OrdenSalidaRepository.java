package com.example.ms_maestranza_db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ms_maestranza_db.model.OrdenSalida;

@Repository
public interface OrdenSalidaRepository extends JpaRepository<OrdenSalida, Integer>{
    //usando jpql
    @Query("SELECT o FROM OrdenSalida o WHERE o.idOrden = :idOrden")
    List<OrdenSalida> buscarPorAi(@Param("idOrden") Integer idOrden);   

}
