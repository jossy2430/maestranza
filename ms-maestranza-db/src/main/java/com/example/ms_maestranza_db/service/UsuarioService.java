package com.example.ms_maestranza_db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_maestranza_db.model.Usuario;
import com.example.ms_maestranza_db.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Integer idUsuario){
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Integer idUsuario){
        usuarioRepository.deleteById(idUsuario);
    }

}
