package com.example.toshibap55w.controlcatastrofes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.toshibap55w.controlcatastrofes.modelo.Elemento;
import com.example.toshibap55w.controlcatastrofes.modelo.Entidad;

public class VerElemento extends AppCompatActivity {

    private EditText tfNombre;
    private EditText tfDescripcion;
    private Elemento elemento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_elemento);


        tfNombre = (EditText) findViewById(R.id.etNombreElemento);
        tfDescripcion = (EditText) findViewById(R.id.etDescripcionElemento);
        elemento = (Elemento) getIntent().getExtras().getSerializable("elemento");
        mostrarElemento();


    }

    public void mostrarElemento(){

        tfNombre.setText(elemento.getNombre());
        tfDescripcion.setText(elemento.getDescripcion());
    }




}
