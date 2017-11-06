package com.example.toshibap55w.controlcatastrofes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PuntosEncuentro extends AppCompatActivity {

    EditText descripcion,latitud,longitud,capacidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntos_encuentro);

        descripcion = (EditText) findViewById(R.id.etDescripcionPunto);
        latitud = (EditText) findViewById(R.id.etLatitudPunto);
        longitud = (EditText) findViewById(R.id.etLongitudPunto);
        capacidad = (EditText) findViewById(R.id.etCapacidadPunto);
    }

    public void abrirMapa (View v){
        Intent i = new Intent(this,MapsActivity.class);
        startActivity(i);
    }
}
