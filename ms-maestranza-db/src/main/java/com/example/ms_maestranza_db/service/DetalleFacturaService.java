package com.example.ms_maestranza_db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_maestranza_db.model.DetalleFactura;
import com.example.ms_maestranza_db.repository.DetalleFacturaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DetalleFacturaService {
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    public List<DetalleFactura> findAll(){
        return detalleFacturaRepository.findAll();
    }

    public DetalleFactura findById(Integer idDetalle){
        return detalleFacturaRepository.findById(idDetalle).orElse(null);
    }

    public DetalleFactura save(DetalleFactura detalleFactura){
        return detalleFacturaRepository.save(detalleFactura);
    }

    public void deleteById(Integer idDetalle){
        detalleFacturaRepository.deleteById(idDetalle);
    }

}
