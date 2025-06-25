package com.example.ms_maestranza_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ms_maestranza_db.model.Factura;
import com.example.ms_maestranza_db.service.FacturaService;

@RestController
@RequestMapping("/api/v1/facturas")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public ResponseEntity<List<Factura>> listar(){
        List<Factura> facturas = facturaService.findAll();
        if (facturas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Factura> guardar(@RequestBody Factura factura){
        Factura nuevaFactura = facturaService.save(factura);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaFactura);
    }

    @GetMapping("/{idFactura}")
    public ResponseEntity<Factura> buscar(@PathVariable Integer idFactura){
        try {
            Factura factura = facturaService.findById(idFactura);
            return ResponseEntity.ok(factura);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idFactura}")
    public ResponseEntity<Factura> actualizar(@PathVariable Integer idFactura, @RequestBody Factura factura){
        try {
            Factura fact = facturaService.findById(idFactura);
            if (fact != null) {
                fact.setFechaEmision(factura.getFechaEmision());
                fact.setTotal(factura.getTotal());
                fact.setFacturaRol(factura.getFacturaRol());

                Factura facturaActualizada = facturaService.save(fact);
                return ResponseEntity.ok(facturaActualizada);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idFactura}")
    public ResponseEntity<?> eliminar(@PathVariable Integer idFactura){
        try {
            facturaService.deleteById(idFactura);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
