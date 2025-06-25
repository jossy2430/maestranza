package com.example.ms_maestranza_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ms_maestranza_db.model.Usuario;
import com.example.ms_maestranza_db.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        List<Usuario> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario){
        Usuario nuevoUsuario = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> buscar(@PathVariable Integer idUsuario){
        try {
            Usuario usuario = usuarioService.findById(idUsuario);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Integer idUsuario, @RequestBody Usuario usuario){
        try {
            Usuario user = usuarioService.findById(idUsuario);
            if (user != null) {
                user.setNombreApellido(usuario.getNombreApellido());
                user.setCorreo(usuario.getCorreo());
                user.setTelefono(usuario.getTelefono());
                user.setDireccion(usuario.getDireccion());
                user.setRut(usuario.getRut());
                user.setPassword(usuario.getPassword());
                user.setRol(usuario.getRol());

                Usuario usuarioActualizado = usuarioService.save(user);
                return ResponseEntity.ok(usuarioActualizado);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<?> eliminar(@PathVariable Integer idUsuario){
        try {
            usuarioService.deleteById(idUsuario);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
