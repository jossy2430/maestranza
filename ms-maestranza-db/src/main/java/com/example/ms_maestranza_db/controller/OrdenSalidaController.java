package com.example.ms_maestranza_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ms_maestranza_db.model.OrdenSalida;
import com.example.ms_maestranza_db.service.OrdenSalidaService;

@RestController
@RequestMapping("/api/v1/ordenes-salida")
public class OrdenSalidaController {
    @Autowired
    private OrdenSalidaService ordenSalidaService;

    @GetMapping
    public ResponseEntity<List<OrdenSalida>> listar(){
        List<OrdenSalida> ordenes = ordenSalidaService.findAll();
        if (ordenes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ordenes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrdenSalida> guardar(@RequestBody OrdenSalida ordenSalida){
        OrdenSalida nuevaOrden = ordenSalidaService.save(ordenSalida);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaOrden);
    }

    @GetMapping("/{idOrden}")
    public ResponseEntity<OrdenSalida> buscar(@PathVariable Integer idOrden){
        try {
            OrdenSalida ordenSalida = ordenSalidaService.findById(idOrden);
            return ResponseEntity.ok(ordenSalida);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idOrden}")
    public ResponseEntity<OrdenSalida> actualizar(@PathVariable Integer idOrden, @RequestBody OrdenSalida ordenSalida){
        try {
            OrdenSalida orden = ordenSalidaService.findById(idOrden);
            if (orden != null) {
                OrdenSalida ordenActualizada = ordenSalidaService.save(ordenSalida);
                return ResponseEntity.ok(ordenActualizada);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idOrden}")
    public ResponseEntity<?> eliminar(@PathVariable Integer idOrden){
        try {
            ordenSalidaService.deleteById(idOrden);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
