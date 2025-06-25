package com.example.ms_maestranza_db.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private int idUsuario;

    @Column(name = "nombreApellido")
    private String nombreApellido;

    @Column(name = "rut")
    private String rut;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion", columnDefinition = "text")
    private String direccion;

    @Column(name = "password")
    private String password;

    public enum RolEnum{
        admin_system,
        gestor_inventario,
        comprador,
        encargado_logistica,
        jefe_produccion,
        auditor_inventario,
        gerente_proyecto,
        trabajador_planta
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private RolEnum rol;

}
