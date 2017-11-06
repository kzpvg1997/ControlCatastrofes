package com.example.toshibap55w.controlcatastrofes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.toshibap55w.controlcatastrofes.modelo.Persona;
import com.example.toshibap55w.controlcatastrofes.modelo.Usuario;
import com.example.toshibap55w.controlcatastrofes.persistencia.Servicio;

public class RegistrarUsuarios extends AppCompatActivity {

    EditText documento,nombre,apellido,telefono,familiar,usuario,password;

    ProgressBar pbRegistro;

    Servicio servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuarios);
    }

    public void volverLogin(View v){

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

        documento = (EditText) findViewById(R.id.etDocumento);
        nombre = (EditText) findViewById(R.id.etNombre);
        apellido = (EditText) findViewById(R.id.etApellido);
        telefono = (EditText) findViewById(R.id.etTelefono);
        familiar = (EditText) findViewById(R.id.etFamiliar);
        usuario = (EditText) findViewById(R.id.etUsernameRegistro);
        password = (EditText) findViewById(R.id.etPasswordRegistro);

        pbRegistro = (ProgressBar) findViewById(R.id.pbRegistro);
    }

    /**
     * registramos a una persona y su usuario
     * @param v
     */
    public void registrarPersona(View v){
        Usuario u = new Usuario(usuario.getText().toString(),password.getText().toString());

       int doc = Integer.parseInt(documento.getText().toString());
        String nomb = nombre.getText().toString();
        String ape = apellido.getText().toString();
        String tel = telefono.getText().toString();

        Persona p = new Persona();
        p.setDocumento(doc);
        p.setNombre(nomb);
        p.setApellido(ape);
        p.setTelefono(tel);
        p.setUsuario(u);

        String msj = "Por favor, ingrese los datos";
        if(!(doc<=0||nomb.isEmpty()|| ape.isEmpty()||tel.isEmpty()||u.getUsername().isEmpty() || u.getPassword().isEmpty() )){

            /**
             * Llamamos el servicio de consignar
             */
            servicio = new Servicio(p, "gestionUsuarios.php", "crear", this, pbRegistro);
            /*Se inicia la petecion*/
            servicio.execute();
            msj = "exito";
            documento.setText("");
            nombre.setText("");
            apellido.setText("");
            telefono.setText("");
            familiar.setText("");
            usuario.setText("");
            password.setText("");
        }
        if(!msj.equals("exito")) {
            Toast.makeText(this, msj, Toast.LENGTH_SHORT).show();
        }
    }


}
