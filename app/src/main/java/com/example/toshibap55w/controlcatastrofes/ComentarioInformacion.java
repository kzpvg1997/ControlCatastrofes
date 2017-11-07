package com.example.toshibap55w.controlcatastrofes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class ComentarioInformacion extends AppCompatActivity {


    private EditText etComentario;
    private Spinner cbValoracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentario_informacion);

        etComentario = (EditText) findViewById(R.id.etComentarioInformacion);
        cbValoracion = (Spinner) findViewById(R.id.cbValoracion);
        listarValoracion();
    }

    public void listarValoracion(){

        String[] valoraciones = {"Muy Mala", "Mala", "Regular"
                , "Buena", "Muy Buena"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valoraciones);
        cbValoracion.setAdapter(adapter);

    }


}
