package com.example.ms_maestranza_db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ms_maestranza_db.model.Producto;
import com.example.ms_maestranza_db.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

    public Producto findById(Integer idProducto){
        return productoRepository.findById(idProducto).orElse(null);
    }

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    public void deleteById(Integer idProducto){
        productoRepository.deleteById(idProducto);
    }

}
