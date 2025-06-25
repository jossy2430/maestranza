package com.example.ms_maestranza_db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_maestranza_db.model.MovimientoInventario;
import com.example.ms_maestranza_db.repository.MovimientoInventarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MovimientoInventarioService {
    @Autowired
    private MovimientoInventarioRepository movimientoInventarioRepository;

    public List<MovimientoInventario> findAll(){
        return movimientoInventarioRepository.findAll();
    }

    public MovimientoInventario findById(Integer idInventario){
        return movimientoInventarioRepository.findById(idInventario).orElse(null);
    }

    public MovimientoInventario save(MovimientoInventario movimientoInventario){
        return movimientoInventarioRepository.save(movimientoInventario);
    }

    public void deleteById(Integer idInventario){
        movimientoInventarioRepository.deleteById(idInventario);
    }

}
