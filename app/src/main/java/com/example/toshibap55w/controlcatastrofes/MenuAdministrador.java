package com.example.toshibap55w.controlcatastrofes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuAdministrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_administrador);
    }

    public void abrirGestionEntidades(View v) {
        Intent i = new Intent(this, VerEntidades.class);
        startActivity(i);
        //  CustomerDTO global = (CustomerDTO) getApplication();
        //Toast.makeText(this, global.getName() + " APELLIDO ", Toast.LENGTH_LONG);
    }

    public void abrirGestionPuntosEncuentro(View v) {
        Intent i = new Intent(this, PuntosEncuentro.class);
        startActivity(i);
        //  CustomerDTO global = (CustomerDTO) getApplication();
        //Toast.makeText(this, global.getName() + " APELLIDO ", Toast.LENGTH_LONG);
    }

    public void volverInicio(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
