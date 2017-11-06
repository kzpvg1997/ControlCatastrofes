package com.example.toshibap55w.controlcatastrofes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.toshibap55w.controlcatastrofes.persistencia.Servicio;

public class ListarEntidades extends AppCompatActivity {

    private ProgressBar progreso;

    private Servicio servicio;

    ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_entidades);

        // gestionEntidades.php
        servicio = new Servicio();

        lista = (ListView) findViewById(R.id.listaEntidades);
    }
}
