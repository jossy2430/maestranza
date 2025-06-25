package com.example.ms_maestranza_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ms_maestranza_db.model.Proveedor;
import com.example.ms_maestranza_db.service.ProveedorService;

@RestController
@RequestMapping("/api/v1/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<Proveedor>> listar(){
        List<Proveedor> proveedores = proveedorService.findAll();
        if (proveedores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Proveedor> guardar(@RequestBody Proveedor proveedor){
        Proveedor nuevoProveedor = proveedorService.save(proveedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProveedor);
    }

    @GetMapping("/{idProveedor}")
    public ResponseEntity<Proveedor> buscar(@PathVariable Integer idProveedor){
        try {
            Proveedor proveedor = proveedorService.findById(idProveedor);
            return ResponseEntity.ok(proveedor);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idProveedor}")
    public ResponseEntity<Proveedor> actualizar(@PathVariable Integer idProveedor, @RequestBody Proveedor proveedor){
        try {
            Proveedor prov = proveedorService.findById(idProveedor);
            if (prov != null) {
                prov.setNombreApellido(proveedor.getNombreApellido());
                prov.setCorreo(proveedor.getCorreo());
                prov.setTelefono(proveedor.getTelefono());
                prov.setDireccion(proveedor.getDireccion());
                prov.setRut(proveedor.getRut());

                Proveedor proveedorActualizado = proveedorService.save(prov);
                return ResponseEntity.ok(proveedorActualizado);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idProveedor}")
    public ResponseEntity<?> eliminar(@PathVariable Integer idProveedor){
        try {
            proveedorService.deleteById(idProveedor);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
