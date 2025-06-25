package com.example.ms_maestranza_db.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proyecto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproyecto")
    private int idProyecto;

    @Column(name = "nombre")
    private String nombreProyecto;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;

    @Column(name = "fecha_inicio", columnDefinition = "date")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", columnDefinition = "date")
    private LocalDate fechaFin;

}
