package com.example.toshibap55w.controlcatastrofes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class AlertarCatastrofe extends AppCompatActivity {

    EditText descripcionEmergencia,latitud,longitud;
    Spinner tipoEmergencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertar_catastrofe);

        tipoEmergencia = (Spinner) findViewById(R.id.spTipoCatastrofeEmergencia);

        descripcionEmergencia = (EditText) findViewById(R.id.etDescripcionEmergencia);
        latitud = (EditText) findViewById(R.id.etLongitudEmergencia);
        longitud = (EditText) findViewById(R.id.etLatitudEmergencia);

    }
}
