package com.example.toshibap55w.controlcatastrofes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.etUsuarioLogin);
        password = (EditText) findViewById(R.id.etPasswordLogin);

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
