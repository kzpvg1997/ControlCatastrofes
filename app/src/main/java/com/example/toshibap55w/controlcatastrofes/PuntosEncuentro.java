package com.example.toshibap55w.controlcatastrofes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.toshibap55w.controlcatastrofes.modelo.Entidad;
import com.example.toshibap55w.controlcatastrofes.modelo.TipoPunto;
import com.example.toshibap55w.controlcatastrofes.persistencia.Servicio;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PuntosEncuentro extends AppCompatActivity implements HiloInterfaz{

    EditText descripcion,latitud,longitud,capacidad;

     String lati,longi;

    private ProgressBar progreso;
    private Servicio servicio;
    Spinner spinner;

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntos_encuentro);

        descripcion = (EditText) findViewById(R.id.etDescripcionPunto);
        latitud = (EditText) findViewById(R.id.etLatitudPunto);
        longitud = (EditText) findViewById(R.id.etLongitudPunto);
        capacidad = (EditText) findViewById(R.id.etCapacidadPunto);
        spinner = (Spinner) findViewById(R.id.spTipoPunto);


        progreso = (ProgressBar) findViewById(R.id.progressBarPuntos);
        progreso.setVisibility(View.INVISIBLE);

        Bundle datos = getIntent().getExtras();
        if(datos!=null) {
            lati = (String) datos.getSerializable("latitud");
            longi= (String) datos.getSerializable("longitud");
        }
        if(lati!=null && longi!=null) {
            latitud.setText(lati);
            longitud.setText(longi);
        }

        servicio = new Servicio(new Object(),"gestionListados.php","listarTipoPunto",this,progreso);
        servicio.delegate=this;
        servicio.execute();

    }

    public List<TipoPunto> jsonToList(String json) throws JSONException {
        JSONArray arrayJson = new JSONArray(json);
        List<TipoPunto> lista = new ArrayList<TipoPunto>();
        Gson gson = new Gson();
        for (int i = 0; i < arrayJson.length(); i++) {
            TipoPunto n = gson.fromJson(arrayJson.getJSONObject(i).toString(),TipoPunto.class);
            lista.add(n);
        }
        return lista;
    }

    public void irMenu(View v){
        Intent i = new Intent(this, MenuAdministrador.class);
        startActivity(i);
    }


    public void abrirMapa (View v){
        Intent i = new Intent(this,MapsActivity.class);
        startActivity(i);
    }

    @Override
    public void publicFinish(JSONObject json) {
        try{

            List<TipoPunto> lista=jsonToList(json.getString("res"));
            if(lista.size()<=0){
                Toast.makeText(this,"Por favor ingrese datos",Toast.LENGTH_SHORT).show();
                return;
            }
            adapter =new ArrayAdapter<TipoPunto>(this,android.R.layout.simple_spinner_item,lista);
            spinner.setAdapter(adapter);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void publicFinishListas(JSONArray jsonArray) {

    }
}
