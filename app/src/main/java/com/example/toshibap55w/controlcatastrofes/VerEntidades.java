package com.example.toshibap55w.controlcatastrofes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class VerEntidades extends AppCompatActivity {


    private EditText tfNombre;
    private EditText tfDireccion;
    private EditText tfTelefono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_entidades);

        tfNombre = (EditText) findViewById(R.id.tfNombre);
        tfDireccion = (EditText) findViewById(R.id.tfDireccion);
        tfTelefono = (EditText) findViewById(R.id.tfTelefono);
    }

    public void crear(View v){

    }

    public void editar(View v){

    }

    public void eliminar(View v){

    }

    public void listar(View v){

    }


}
