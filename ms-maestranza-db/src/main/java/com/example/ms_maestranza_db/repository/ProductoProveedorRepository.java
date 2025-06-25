package com.example.ms_maestranza_db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ms_maestranza_db.model.ProductoProveedor;

@Repository
public interface ProductoProveedorRepository extends JpaRepository<ProductoProveedor, Integer>{
    //usando jpql
    @Query("SELECT pp FROM ProductoProveedor pp WHERE pp.id = :id")
    List<ProductoProveedor> buscarPorAi(@Param("id") Integer id);   

}
