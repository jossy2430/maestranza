package com.example.ms_maestranza_db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_maestranza_db.model.Factura;
import com.example.ms_maestranza_db.repository.FacturaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> findAll(){
        return facturaRepository.findAll();
    }

    public Factura findById(Integer idFactura){
        return facturaRepository.findById(idFactura).orElse(null);
    }

    public Factura save(Factura factura){
        return facturaRepository.save(factura);
    }

    public void deleteById(Integer idFactura){
        facturaRepository.deleteById(idFactura);
    }

}
