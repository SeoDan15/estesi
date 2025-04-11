package com.tienda.tienda.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Pojo
//JavaBean
@Entity
@Table (name="Categorias")
public class Categoria extends Object{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private String imagen;

    public String getImagen() {
        return (imagen == null || imagen.isEmpty()) ? "INF3.png" : imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    @Override
    public String toString() {
        return "Categoria [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen + "]";
    }
}
