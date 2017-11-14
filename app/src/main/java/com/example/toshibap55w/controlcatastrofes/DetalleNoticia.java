package com.example.toshibap55w.controlcatastrofes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.VideoView;

import com.example.toshibap55w.controlcatastrofes.modelo.Noticia;

public class DetalleNoticia extends AppCompatActivity {

    EditText nombreNoticia,descripcion;
    GridView listaImagenes;
    Spinner spVideos;
    VideoView pantallaVideo;
    Noticia noticia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_noticia);

        nombreNoticia = (EditText) findViewById(R.id.etNombreNoticia);
        descripcion = (EditText) findViewById(R.id.etDescripcionNoticia);

        listaImagenes = (GridView) findViewById(R.id.listaImagenes);

        spVideos = (Spinner) findViewById(R.id.spVideos);

        noticia = (Noticia) getIntent().getExtras().getSerializable("noticia");

        pantallaVideo = (VideoView) findViewById(R.id.videoViewNoticia);
        mostrarNoticia();
    }

    public void irComentarNoticia(View v){

        Intent i = new Intent(this,ComentarNoticia.class);
        startActivity(i);
    }

    public void mostrarNoticia(){
        nombreNoticia.setText(noticia.getNombre());
        descripcion.setText(noticia.getDescripcion());
    }
}
