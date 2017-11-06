package com.example.toshibap55w.controlcatastrofes.modelo;

/**
 * Created by TOSHIBAP55W on 6/11/2017.
 */
public class Persona {

    private int documento;
    private String nombre;
    private String apellido;
    private String telefono;
    private Persona familiar;
    private Usuario usuario;

    public Persona() {

    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Persona getFamiliar() {
        return familiar;
    }

    public void setFamiliar(Persona familiar) {
        this.familiar = familiar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
