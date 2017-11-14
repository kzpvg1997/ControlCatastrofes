package com.example.toshibap55w.controlcatastrofes.modelo;

import java.io.Serializable;

/**
 * Created by TOSHIBAP55W on 9/11/2017.
 */
public class Noticia implements Serializable{

    private int id;
    private String nombre;
    private String descripcion;

    public Noticia(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return nombre;
    }
}
