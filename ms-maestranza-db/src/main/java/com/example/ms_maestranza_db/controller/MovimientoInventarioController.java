package com.example.ms_maestranza_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ms_maestranza_db.model.MovimientoInventario;
import com.example.ms_maestranza_db.service.MovimientoInventarioService;

@RestController
@RequestMapping("/api/v1/movimientos-inventario")
public class MovimientoInventarioController {
    @Autowired
    private MovimientoInventarioService movimientoInventarioService;

    @GetMapping
    public ResponseEntity<List<MovimientoInventario>> listar(){
        List<MovimientoInventario> movimientos = movimientoInventarioService.findAll();
        if (movimientos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(movimientos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MovimientoInventario> guardar(@RequestBody MovimientoInventario movimientoInventario){
        MovimientoInventario nuevoMovimiento = movimientoInventarioService.save(movimientoInventario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMovimiento);
    }

    @GetMapping("/{idInventario}")
    public ResponseEntity<MovimientoInventario> buscar(@PathVariable Integer idInventario){
        try {
            MovimientoInventario movimiento = movimientoInventarioService.findById(idInventario);
            return ResponseEntity.ok(movimiento);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idInventario}")
    public ResponseEntity<MovimientoInventario> actualizar(@PathVariable Integer idInventario, @RequestBody MovimientoInventario movimientoInventario){
        try {
            MovimientoInventario movimiento = movimientoInventarioService.findById(idInventario);
            if (movimiento != null) {
                MovimientoInventario movimientoActualizado = movimientoInventarioService.save(movimientoInventario);
                return ResponseEntity.ok(movimientoActualizado);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idInventario}")
    public ResponseEntity<?> eliminar(@PathVariable Integer idInventario){
        try {
            movimientoInventarioService.deleteById(idInventario);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
