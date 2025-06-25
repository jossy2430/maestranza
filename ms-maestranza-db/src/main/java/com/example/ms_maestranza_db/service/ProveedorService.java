package com.example.ms_maestranza_db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_maestranza_db.model.Proveedor;
import com.example.ms_maestranza_db.repository.ProveedorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> findAll(){
        return proveedorRepository.findAll();
    }

    public Proveedor findById(Integer idProveedor){
        return proveedorRepository.findById(idProveedor).orElse(null);
    }

    public Proveedor save(Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }

    public void deleteById(Integer idProveedor){
        proveedorRepository.deleteById(idProveedor);
    }

}
