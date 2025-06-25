package com.example.ms_maestranza_db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ms_maestranza_db.model.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{
    //usando jpql
    @Query("SELECT p FROM Proveedor p WHERE p.idProveedor = :idProveedor")
    List<Proveedor> buscarPorAi(@Param("idProveedor") Integer idProveedor);   

}
