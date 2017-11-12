package com.example.toshibap55w.controlcatastrofes.modelo;

/**
 * Created by TOSHIBAP55W on 9/11/2017.
 */
public class Comentario {

    private int id;
    private Recomendacion recomendacion;
    private Persona persona;
    private Noticia noticia;
    private String Descripcion;
    private String valoracion;

    public Comentario(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Recomendacion getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(Recomendacion recomendacion) {
        this.recomendacion = recomendacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }
}
