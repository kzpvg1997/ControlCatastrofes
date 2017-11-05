package com.example.toshibap55w.controlcatastrofes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirRegistro(View v){

        Intent i = new Intent(this,RegistrarUsuarios.class);
        startActivity(i);
    }

    public void irMenuPrincipal(View v){

        Intent i = new Intent(this,MenuPrincipal.class);
        startActivity(i);
    }
}
