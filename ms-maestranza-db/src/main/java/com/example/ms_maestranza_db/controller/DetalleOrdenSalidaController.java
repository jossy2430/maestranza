package com.example.ms_maestranza_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ms_maestranza_db.model.DetalleOrdenSalida;
import com.example.ms_maestranza_db.service.DetalleOrdenSalidaService;

@RestController
@RequestMapping("/api/v1/detalles-orden-salida")
public class DetalleOrdenSalidaController {
    @Autowired
    private DetalleOrdenSalidaService detalleOrdenSalidaService;

    @GetMapping
    public ResponseEntity<List<DetalleOrdenSalida>> listar(){
        List<DetalleOrdenSalida> detalles = detalleOrdenSalidaService.findAll();
        if (detalles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DetalleOrdenSalida> guardar(@RequestBody DetalleOrdenSalida detalleOrdenSalida){
        DetalleOrdenSalida nuevoDetalle = detalleOrdenSalidaService.save(detalleOrdenSalida);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDetalle);
    }

    @GetMapping("/{idDetalle}")
    public ResponseEntity<DetalleOrdenSalida> buscar(@PathVariable Integer idDetalle){
        try {
            DetalleOrdenSalida detalle = detalleOrdenSalidaService.findById(idDetalle);
            return ResponseEntity.ok(detalle);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idDetalle}")
    public ResponseEntity<DetalleOrdenSalida> actualizar(@PathVariable Integer idDetalle, @RequestBody DetalleOrdenSalida detalleOrdenSalida){
        try {
            DetalleOrdenSalida detalle = detalleOrdenSalidaService.findById(idDetalle);
            if (detalle != null) {
                DetalleOrdenSalida detalleActualizado = detalleOrdenSalidaService.save(detalleOrdenSalida);
                return ResponseEntity.ok(detalleActualizado);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idDetalle}")
    public ResponseEntity<?> eliminar(@PathVariable Integer idDetalle){
        try {
            detalleOrdenSalidaService.deleteById(idDetalle);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
