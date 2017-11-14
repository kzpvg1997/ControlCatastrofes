package com.example.toshibap55w.controlcatastrofes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.toshibap55w.controlcatastrofes.modelo.Persona;
import com.example.toshibap55w.controlcatastrofes.modelo.Usuario;
import com.example.toshibap55w.controlcatastrofes.persistencia.Servicio;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements hiloInterfaz {

    ProgressBar pbProgeso;
    Servicio servicio;
    EditText username,password;
    public static Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.etUsuarioLogin);
        password = (EditText) findViewById(R.id.etPasswordLogin);
        pbProgeso = (ProgressBar) findViewById(R.id.pblogin);
        pbProgeso.setVisibility(View.INVISIBLE);
    }

    /**
     * registramos a una persona y su usuario
     * @param v
     */
    public void entrar(View v) {
        try {
            String nick = username.getText().toString();
            String pass = password.getText().toString();
            Usuario u = new Usuario();
            u.setPassword(pass);
            u.setUsername(nick);
            if (u.getUsername().isEmpty() || u.getPassword().isEmpty()) {
                Toast.makeText(this, "Por favor, ingrese los datos", Toast.LENGTH_SHORT).show();
            }else{
                /**
                 * Llamamos al servicio de entrar
                 */
                servicio = new Servicio(u, "gestionUsuarios.php", "entrar", this, pbProgeso);
                servicio.delegate=this;
                servicio.execute();

            }
        }catch (Exception n){
            n.printStackTrace();
        }
    }

    public void abrirRegistro(View v){

        Intent i = new Intent(this,RegistrarUsuarios.class);
        startActivity(i);
    }

    public void irMenuPrincipal(View v){

        Intent i = new Intent(this,MenuPrincipal.class);
        startActivity(i);
    }

    @Override
    public void publicFinish(JSONObject json) {

        try {
            String nick = username.getText().toString();
            String pass = password.getText().toString();
            Usuario u = new Usuario();
            u.setPassword(pass);
            u.setUsername(nick);

            if (!json.getString("res").equalsIgnoreCase("ERROR")) {

                Persona p = new Persona();
                p.setDocumento(Integer.parseInt(json.getString("res")));
                Log.e(p.getDocumento()+"",">>>>>");
                 MainActivity.setPersona(p);

                if (u.getUsername().equalsIgnoreCase("admin")) {
                    Intent i = new Intent(this, MenuAdministrador.class);
                    startActivity(i);
                }else {
                    Intent i = new Intent(this, MenuPrincipal.class);
                    startActivity(i);
                }

        }else{
            Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_SHORT).show();
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void publicFinishListas(JSONArray jsonArray) {

    }

    public static Persona getPersona() {
        return persona;
    }

    public static void setPersona(Persona persona) {
        MainActivity.persona = persona;
    }
}
