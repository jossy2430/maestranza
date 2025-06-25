package com.example.ms_maestranza_db.model;


import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proverdor")
    private int idProveedor;

    @Column(name = "nombre")
    private String nombreApellido;

    @Column(name = "rut")
    private String rut;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion", columnDefinition = "text")
    private String direccion;

    @Column(name = "terminos_pago", columnDefinition = "text")
    private String terminosPago;

    @Column(name = "rubro")
    private String rubro;

    public enum EstadoEnum{
        activo,
        inactivo
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoEnum estado; 

}
