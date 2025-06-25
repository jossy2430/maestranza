package com.example.ms_maestranza_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ms_maestranza_db.model.Proyecto;
import com.example.ms_maestranza_db.service.ProyectoService;

@RestController
@RequestMapping("/api/v1/proyectos")
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public ResponseEntity<List<Proyecto>> listar(){
        List<Proyecto> proyectos = proyectoService.findAll();
        if (proyectos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Proyecto> guardar(@RequestBody Proyecto proyecto){
        Proyecto nuevoProyecto = proyectoService.save(proyecto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProyecto);
    }

    @GetMapping("/{idProyecto}")
    public ResponseEntity<Proyecto> buscar(@PathVariable Integer idProyecto){
        try {
            Proyecto proyecto = proyectoService.findById(idProyecto);
            return ResponseEntity.ok(proyecto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idProyecto}")
    public ResponseEntity<Proyecto> actualizar(@PathVariable Integer idProyecto, @RequestBody Proyecto proyecto){
        try {
            Proyecto proy = proyectoService.findById(idProyecto);
            if (proy != null) {
                Proyecto proyectoActualizado = proyectoService.save(proyecto);
                return ResponseEntity.ok(proyectoActualizado);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idProyecto}")
    public ResponseEntity<?> eliminar(@PathVariable Integer idProyecto){
        try {
            proyectoService.deleteById(idProyecto);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
