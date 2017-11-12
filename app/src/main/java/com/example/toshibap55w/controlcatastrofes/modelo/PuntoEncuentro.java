package com.example.toshibap55w.controlcatastrofes.modelo;

/**
 * Created by TOSHIBAP55W on 9/11/2017.
 */
public class PuntoEncuentro {

    private int id;
    private TipoPunto tipoPunto;
    private String descripcion;
    private int capacidad;
    private String latitud;
    private String longitud;

    public PuntoEncuentro(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoPunto getTipoPunto() {
        return tipoPunto;
    }

    public void setTipoPunto(TipoPunto tipoPunto) {
        this.tipoPunto = tipoPunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
