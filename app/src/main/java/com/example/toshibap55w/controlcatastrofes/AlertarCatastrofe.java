package com.example.toshibap55w.controlcatastrofes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.example.toshibap55w.controlcatastrofes.modelo.TipoCatastrofe;
import com.example.toshibap55w.controlcatastrofes.modelo.TipoPunto;
import com.example.toshibap55w.controlcatastrofes.persistencia.Servicio;
import com.google.android.gms.internal.se;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AlertarCatastrofe extends AppCompatActivity implements HiloInterfaz{

    EditText descripcionEmergencia,latitud,longitud;
    Spinner spinner;

    private ProgressBar progreso;
    private Servicio servicio;

    private ArrayAdapter adapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertar_catastrofe);

        spinner = (Spinner) findViewById(R.id.spTipoCatastrofeEmergencia);

        descripcionEmergencia = (EditText) findViewById(R.id.etDescripcionEmergencia);
        latitud = (EditText) findViewById(R.id.etLongitudEmergencia);
        longitud = (EditText) findViewById(R.id.etLatitudEmergencia);


        progreso = (ProgressBar) findViewById(R.id.progressBarEmergencia);
        progreso.setVisibility(View.INVISIBLE);
        servicio = new Servicio(new Object(),"gestionListados.php","listarTipoCatastrofe",this,progreso);
        servicio.delegate=this;
        servicio.execute();


    }

    @Override
    public void publicFinish(JSONObject json) {

    }

    @Override
    public void publicFinishListas(JSONArray jsonArray) {

        try {
            String[] datos = new String[jsonArray.length()];
            for (int i = 0; i < datos.length; i++) {
                datos[i] = jsonArray.getJSONObject(i).getString("nombre"); //nombre de la columna que quiere mostrar
            }

            adapater = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
            spinner.setAdapter(adapater);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
