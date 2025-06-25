package com.example.ms_maestranza_db.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "producto_proveedor")
@AllArgsConstructor
@NoArgsConstructor
public class ProductoProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @Column(name = "precio_ultima_compra", columnDefinition = "decimal(10,2)")
    private Double precioUltimaCompra;

    @Column(name = "fecha_ultima_compra", columnDefinition = "date")
    private LocalDate fechaUltimaCompra;
}
