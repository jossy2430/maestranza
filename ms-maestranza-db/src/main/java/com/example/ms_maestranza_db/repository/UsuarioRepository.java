package com.example.ms_maestranza_db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ms_maestranza_db.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    //usando jpql
    @Query("SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    List<Usuario> buscarPorAi(@Param("idUsuario") Integer idUsuario);   

}
