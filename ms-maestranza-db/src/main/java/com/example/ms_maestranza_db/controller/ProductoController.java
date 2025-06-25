package com.example.ms_maestranza_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ms_maestranza_db.model.Producto;
import com.example.ms_maestranza_db.service.ProductoService;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listar(){
        List<Producto> productos = productoService.findAll();
        if (productos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto){
        Producto nuevoProducto = productoService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<Producto> buscar(@PathVariable Integer idProducto){
        try {
            Producto producto = productoService.findById(idProducto);
            return ResponseEntity.ok(producto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idProducto}")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer idProducto, @RequestBody Producto producto){
        try {
            Producto prod = productoService.findById(idProducto);
            if (prod != null) {
                prod.setNombre(producto.getNombre());
                prod.setDescripcion(producto.getDescripcion());
                prod.setPrecioUnitario(producto.getPrecioUnitario());
                prod.setStock(producto.getStock());
                prod.setCategoria(producto.getCategoria());

                Producto productoActualizado = productoService.save(prod);
                return ResponseEntity.ok(productoActualizado);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<?> eliminar(@PathVariable Integer idProducto){
        try {
            productoService.deleteById(idProducto);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
