package com.tickets.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="actividad")
public class Actividad implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_actividad")
    private Long idActividad;

    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String imagen;
    private boolean activo;
    
    @JoinColumn(name="id_categoria", referencedColumnName="id_categoria")
    @ManyToOne
    private Categoria categoria;

    public Actividad() {

    }

    public Actividad(String descripcion, String detalle, double precio, int existencias, String imagen, boolean activo, Categoria categoria) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.imagen = imagen;
        this.activo = activo;
        this.categoria = categoria;
    }

    

}
//Hola a todos desde Spring
//<p th:text="${variable}"></p>
//<p>[[${variable}]]</p>