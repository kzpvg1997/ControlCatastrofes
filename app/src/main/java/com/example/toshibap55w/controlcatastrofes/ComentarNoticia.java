package com.example.toshibap55w.controlcatastrofes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class ComentarNoticia extends AppCompatActivity {

    Spinner spValoracion;
    EditText etComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentar_noticia);

        etComentario = (EditText) findViewById(R.id.tfComentario);
        spValoracion = (Spinner) findViewById(R.id.cbValoracion);
        listarValoracion();
    }

    public void listarValoracion(){

        String[] valoraciones = {"Muy Mala", "Mala", "Regular"
                , "Buena", "Muy Buena"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valoraciones);
        spValoracion.setAdapter(adapter);

    }

}
