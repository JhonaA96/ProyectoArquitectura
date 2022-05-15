package com.proyecto.arquitectura.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="juegos")
public class Juegos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String nombre;

    @Column
    private String clasificacion;

    @Column
    private String genero;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date fechaCreacion;

    @Column
    private String desarrollador;

    @Column
    private String modos;

    public Juegos(String nombre, String clasificacion, String genero, Date fechaCreacion, String desarrollador,
            String modos) {
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.fechaCreacion = fechaCreacion;
        this.desarrollador = desarrollador;
        this.modos = modos;
    }

    public Juegos(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public String getModos() {
        return modos;
    }

    public void setModos(String modos) {
        this.modos = modos;
    }
    
}
