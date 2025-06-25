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
@Table(name = "movimiento_inventario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private int idInventario;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public enum tipoEmun{
        entrada,salida,transferencia
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private tipoEmun tipo;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "fecha_movimiento", columnDefinition = "datetime")
    private LocalDateTime fechaMovimiento;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
