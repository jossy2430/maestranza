package com.example.ms_maestranza_db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_maestranza_db.model.ProductoProveedor;
import com.example.ms_maestranza_db.repository.ProductoProveedorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductoProveedorService {
    @Autowired
    private ProductoProveedorRepository productoProveedorRepository;

    public List<ProductoProveedor> findAll(){
        return productoProveedorRepository.findAll();
    }

    public ProductoProveedor findById(Integer id){
        return productoProveedorRepository.findById(id).orElse(null);
    }

    public ProductoProveedor save(ProductoProveedor productoProveedor){
        return productoProveedorRepository.save(productoProveedor);
    }

    public void deleteById(Integer id){
        productoProveedorRepository.deleteById(id);
    }

}
