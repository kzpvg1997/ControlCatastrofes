package com.example.toshibap55w.controlcatastrofes.modelo;

/**
 * Created by TOSHIBAP55W on 9/11/2017.
 */
public class Entidad {
    private int ID;
    private String NOMBRE;
    private String DIRECCION;
    private String TELEFONO;

    public Entidad() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    @Override
    public String toString() {
        return NOMBRE;
    }
}
