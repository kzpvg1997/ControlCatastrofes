package com.example.toshibap55w.controlcatastrofes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.toshibap55w.controlcatastrofes.modelo.Entidad;

public class VerEntidades extends AppCompatActivity {


    private EditText tfNombre;
    private EditText tfDireccion;
    private EditText tfTelefono;
private Entidad entidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_entidades);

        tfNombre = (EditText) findViewById(R.id.etNombreEntidad);
        tfDireccion = (EditText) findViewById(R.id.etDireccionEntidad);
        tfTelefono = (EditText) findViewById(R.id.etTelefonoEntidad);
        entidad = (Entidad) getIntent().getExtras().getSerializable("entidad");
mostrarEntidad();
    }

   public void mostrarEntidad(){

       tfNombre.setText(entidad.getNOMBRE());
       tfDireccion.setText(entidad.getDIRECCION());
       tfTelefono.setText(entidad.getTELEFONO());

   }


}
