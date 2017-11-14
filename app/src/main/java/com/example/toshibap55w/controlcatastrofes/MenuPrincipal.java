package com.example.toshibap55w.controlcatastrofes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }


    public void irSeccionNoticias(View v){

        Intent i = new Intent(this,SeccionNoticias.class);
        startActivity(i);
    }

    public void irListaAlertas(View v){

        Intent i = new Intent(this,ListaAlertas.class);
        startActivity(i);
    }


    public void abrirComentarInformacion(View v) {
        Intent i = new Intent(this, ComentarioInformacion.class);
        startActivity(i);
        //  CustomerDTO global = (CustomerDTO) getApplication();
        //Toast.makeText(this, global.getName() + " APELLIDO ", Toast.LENGTH_LONG);
    }

    public void abrirGestionEntidades(View v) {
        Intent i = new Intent(this, ListarEntidades.class);
        startActivity(i);
        //  CustomerDTO global = (CustomerDTO) getApplication();
        //Toast.makeText(this, global.getName() + " APELLIDO ", Toast.LENGTH_LONG);
    }

    public void abrirPuntosEncuentro(View v) {
        Intent i = new Intent(this, ListaPuntosEncuentro.class);
        startActivity(i);
        //  CustomerDTO global = (CustomerDTO) getApplication();
        //Toast.makeText(this, global.getName() + " APELLIDO ", Toast.LENGTH_LONG);
    }


    public void abrirElementos(View v) {
        Intent i = new Intent(this, ElementosActivity.class);
        startActivity(i);
        //  CustomerDTO global = (CustomerDTO) getApplication();
        //Toast.makeText(this, global.getName() + " APELLIDO ", Toast.LENGTH_LONG);
    }
}
