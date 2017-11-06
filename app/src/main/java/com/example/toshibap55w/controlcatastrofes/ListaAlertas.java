package com.example.toshibap55w.controlcatastrofes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;

public class ListaAlertas extends AppCompatActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alertas);

        lista = (ListView) findViewById(R.id.listaAlertas);

    }

    public void irAlertaCatastrofe(View v){

        Intent i = new Intent(this,AlertarCatastrofe.class);
        startActivity(i);
    }
}
