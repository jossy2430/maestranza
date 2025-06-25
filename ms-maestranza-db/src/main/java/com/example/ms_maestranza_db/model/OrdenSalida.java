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
@Table(name = "ordensalida")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenSalida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private int idOrden;

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public enum EstadoEnum {
        pendiente,aprobado,rechazado
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoEnum estado;

    @Column(name = "fecha_salida", columnDefinition = "datetime")
    private LocalDateTime fechaSalida;

}
