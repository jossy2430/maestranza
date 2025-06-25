package com.example.ms_maestranza_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ms_maestranza_db.model.DetalleFactura;
import com.example.ms_maestranza_db.service.DetalleFacturaService;

@RestController
@RequestMapping("/api/v1/detalles-factura")
public class DetalleFacturaController {
    @Autowired
    private DetalleFacturaService detalleFacturaService;

    @GetMapping
    public ResponseEntity<List<DetalleFactura>> listar(){
        List<DetalleFactura> detalles = detalleFacturaService.findAll();
        if (detalles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DetalleFactura> guardar(@RequestBody DetalleFactura detalleFactura){
        DetalleFactura nuevoDetalle = detalleFacturaService.save(detalleFactura);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDetalle);
    }

    @GetMapping("/{idDetalle}")
    public ResponseEntity<DetalleFactura> buscar(@PathVariable Integer idDetalle){
        try {
            DetalleFactura detalle = detalleFacturaService.findById(idDetalle);
            return ResponseEntity.ok(detalle);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idDetalle}")
    public ResponseEntity<DetalleFactura> actualizar(@PathVariable Integer idDetalle, @RequestBody DetalleFactura detalleFactura){
        try {
            DetalleFactura detalle = detalleFacturaService.findById(idDetalle);
            if (detalle != null) {
                DetalleFactura detalleActualizado = detalleFacturaService.save(detalleFactura);
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
            detalleFacturaService.deleteById(idDetalle);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
