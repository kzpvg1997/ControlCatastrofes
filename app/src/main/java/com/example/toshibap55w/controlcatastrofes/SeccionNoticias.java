package com.example.toshibap55w.controlcatastrofes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class SeccionNoticias extends AppCompatActivity {


    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccion_noticias);

        lista = (ListView) findViewById(R.id.listaNoticias);
    }

    public void irDetalleNoticia(View v){

        Intent i = new Intent(this,DetalleNoticia.class);
        startActivity(i);
    }
}
