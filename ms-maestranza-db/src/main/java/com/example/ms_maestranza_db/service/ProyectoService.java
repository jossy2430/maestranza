package com.example.ms_maestranza_db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_maestranza_db.model.Proyecto;
import com.example.ms_maestranza_db.repository.ProyectoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProyectoService {
    @Autowired
    private ProyectoRepository proyectoRepository;

    public List<Proyecto> findAll(){
        return proyectoRepository.findAll();
    }

    public Proyecto findById(Integer idProyecto){
        return proyectoRepository.findById(idProyecto).orElse(null);
    }

    public Proyecto save(Proyecto proyecto){
        return proyectoRepository.save(proyecto);
    }

    public void deleteById(Integer idProyecto){
        proyectoRepository.deleteById(idProyecto);
    }

}
