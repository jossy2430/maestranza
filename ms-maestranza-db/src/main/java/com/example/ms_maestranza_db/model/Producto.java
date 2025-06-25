package com.example.ms_maestranza_db.model;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "producto")
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private int idProducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;

    @Column(name = "numero_serie")
    private String numeroSerie;

    @Column(name = "precio_unitario", columnDefinition = "decimal(10,2)")
    private Double precioUnitario;

    @Column(name = "stock")
    private int stock;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "categoria")
    private String categoria;

}
