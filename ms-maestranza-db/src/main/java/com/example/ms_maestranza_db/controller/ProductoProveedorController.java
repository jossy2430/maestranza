package com.example.ms_maestranza_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ms_maestranza_db.model.ProductoProveedor;
import com.example.ms_maestranza_db.service.ProductoProveedorService;

@RestController
@RequestMapping("/api/v1/productos-proveedores")
public class ProductoProveedorController {
    @Autowired
    private ProductoProveedorService productoProveedorService;

    @GetMapping
    public ResponseEntity<List<ProductoProveedor>> listar(){
        List<ProductoProveedor> productosProveedores = productoProveedorService.findAll();
        if (productosProveedores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productosProveedores, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductoProveedor> guardar(@RequestBody ProductoProveedor productoProveedor){
        ProductoProveedor nuevoProductoProveedor = productoProveedorService.save(productoProveedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProductoProveedor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoProveedor> buscar(@PathVariable Integer id){
        try {
            ProductoProveedor productoProveedor = productoProveedorService.findById(id);
            return ResponseEntity.ok(productoProveedor);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoProveedor> actualizar(@PathVariable Integer id, @RequestBody ProductoProveedor productoProveedor){
        try {
            ProductoProveedor prodProv = productoProveedorService.findById(id);
            if (prodProv != null) {
                ProductoProveedor productoProveedorActualizado = productoProveedorService.save(productoProveedor);
                return ResponseEntity.ok(productoProveedorActualizado);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try {
            productoProveedorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
