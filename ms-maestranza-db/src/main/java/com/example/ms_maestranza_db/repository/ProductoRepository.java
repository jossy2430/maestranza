package com.example.ms_maestranza_db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ms_maestranza_db.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    //usando jpql
    @Query("SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
    List<Producto> buscarPorAi(@Param("idProducto") Integer idProducto);   

}
