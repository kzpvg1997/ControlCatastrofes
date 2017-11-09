package com.example.toshibap55w.controlcatastrofes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.toshibap55w.controlcatastrofes.modelo.Persona;
import com.example.toshibap55w.controlcatastrofes.modelo.Usuario;
import com.example.toshibap55w.controlcatastrofes.persistencia.Servicio;

public class MainActivity extends AppCompatActivity {

    ProgressBar pbRegistro;

    Servicio servicio;

    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.etUsuarioLogin);
        password = (EditText) findViewById(R.id.etPasswordLogin);
        pbRegistro = (ProgressBar) findViewById(R.id.pbRegistro);
        pbRegistro.setVisibility(View.INVISIBLE);

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
            String msj = "Por favor, ingrese los datos";
            if (!(u.getUsername().isEmpty() || u.getPassword().isEmpty())) {

                /**
                 * Llamamos el servicio de entrar
                 */
                servicio = new Servicio(u, "gestionUsuarios.php", "entrar", this, pbRegistro);
                servicio.execute();
                if(servicio.getRta().equals("EXITO")){
                    Intent i = new Intent(this,MenuPrincipal.class);
                    startActivity(i);
                }else{
                    msj = servicio.getRta();
                }
            }else{
                Toast.makeText(this, msj, Toast.LENGTH_SHORT).show();
            }
        }catch (NullPointerException ex){
            Toast.makeText(this, "Conecte su celular a una red de internet", Toast.LENGTH_SHORT).show();
            servicio.cancel(true);
        }catch (Exception n){
            Toast.makeText(this, "Lo sentimos, hubo un error en la aplicacion", Toast.LENGTH_SHORT).show();
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
}
