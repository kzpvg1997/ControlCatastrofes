package com.example.toshibap55w.controlcatastrofes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class ListaPuntosEncuentro extends AppCompatActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_puntos_encuentro);

        lista = (ListView) findViewById(R.id.listaPuntosEncuentro);
    }

    public void abrirPuntosEncuentro(View v) {
        Intent i = new Intent(this, ListaPuntosEncuentro.class);
        startActivity(i);
        //  CustomerDTO global = (CustomerDTO) getApplication();
        //Toast.makeText(this, global.getName() + " APELLIDO ", Toast.LENGTH_LONG);
    }
}
