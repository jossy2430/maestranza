package com.example.ms_maestranza_db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_maestranza_db.model.OrdenSalida;
import com.example.ms_maestranza_db.repository.OrdenSalidaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrdenSalidaService {
    @Autowired
    private OrdenSalidaRepository ordenSalidaRepository;

    public List<OrdenSalida> findAll(){
        return ordenSalidaRepository.findAll();
    }

    public OrdenSalida findById(Integer idOrden){
        return ordenSalidaRepository.findById(idOrden).orElse(null);
    }

    public OrdenSalida save(OrdenSalida ordenSalida){
        return ordenSalidaRepository.save(ordenSalida);
    }

    public void deleteById(Integer idOrden){
        ordenSalidaRepository.deleteById(idOrden);
    }

}
