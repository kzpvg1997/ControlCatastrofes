package com.example.toshibap55w.controlcatastrofes.modelo;

/**
 * Created by TOSHIBAP55W on 9/11/2017.
 */
public class TipoCatastrofe {

    private int id;
    private String nombre;


    public TipoCatastrofe(){

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

    @Override
    public String toString() {
        return " "+nombre;
    }
}
