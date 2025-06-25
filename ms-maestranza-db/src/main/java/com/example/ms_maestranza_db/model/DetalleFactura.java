package com.example.ms_maestranza_db.model;

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
@Table(name = "detalle_factura")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private int idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_unitario", columnDefinition = "decimal(10,2)")
    private Double precioUnitario;

    @Column(name = "subtotal", columnDefinition = "decimal(10,2)")
    private Double subtotal;

}
