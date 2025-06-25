package com.example.ms_maestranza_db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_maestranza_db.model.DetalleOrdenSalida;
import com.example.ms_maestranza_db.repository.DetalleOrdenSalidaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DetalleOrdenSalidaService {
    @Autowired
    private DetalleOrdenSalidaRepository detalleOrdenSalidaRepository;

    public List<DetalleOrdenSalida> findAll(){
        return detalleOrdenSalidaRepository.findAll();
    }

    public DetalleOrdenSalida findById(Integer idDetalle){
        return detalleOrdenSalidaRepository.findById(idDetalle).orElse(null);
    }

    public DetalleOrdenSalida save(DetalleOrdenSalida detalleOrdenSalida){
        return detalleOrdenSalidaRepository.save(detalleOrdenSalida);
    }

    public void deleteById(Integer idDetalle){
        detalleOrdenSalidaRepository.deleteById(idDetalle);
    }

}
