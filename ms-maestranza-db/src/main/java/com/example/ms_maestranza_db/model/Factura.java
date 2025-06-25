package com.example.ms_maestranza_db.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "factura")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private int idFactura;
    
    @ManyToOne
    @JoinColumn(name = "id_orden")
    private OrdenSalida ordenSalida;

    @Column(name = "facha_emision", columnDefinition = "datetime")
    private LocalDateTime fechaEmision;

    @Column(name = "total", columnDefinition = "decimal(10,2)")
    private Double total;

    public enum FacturaEnum{
        aprobado, pendiente, rechazado
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "facturacol")
    private FacturaEnum facturaRol;



}
