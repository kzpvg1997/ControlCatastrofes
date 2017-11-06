package com.example.toshibap55w.controlcatastrofes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListaPuntosEncuentro extends AppCompatActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_puntos_encuentro);

        lista = (ListView) findViewById(R.id.listaPuntosEncuentro);
    }
}
