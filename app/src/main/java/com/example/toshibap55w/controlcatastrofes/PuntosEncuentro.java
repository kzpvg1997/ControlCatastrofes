package com.example.toshibap55w.controlcatastrofes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.toshibap55w.controlcatastrofes.modelo.Persona;
import com.example.toshibap55w.controlcatastrofes.modelo.PuntoEncuentro;
import com.example.toshibap55w.controlcatastrofes.modelo.TipoPunto;
import com.example.toshibap55w.controlcatastrofes.modelo.Usuario;
import com.example.toshibap55w.controlcatastrofes.persistencia.Servicio;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PuntosEncuentro extends AppCompatActivity implements hiloInterfaz {

    EditText descripcion,latitud,longitud,capacidad;

     String lati,longi;

    private ProgressBar progreso;
    private Servicio servicio;
    Spinner tipoPunto;
private String accion = "";


    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntos_encuentro);

        descripcion = (EditText) findViewById(R.id.etDescripcionPunto);
        latitud = (EditText) findViewById(R.id.etLatitudPunto);
        longitud = (EditText) findViewById(R.id.etLongitudPunto);
        capacidad = (EditText) findViewById(R.id.etCapacidadPunto);
         tipoPunto = (Spinner) findViewById(R.id.spTipoPunto);


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
accion = "listarTipoPunto";
        servicio = new Servicio(new Object(),"gestionListados.php",accion,this,progreso);
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

            if(accion.equalsIgnoreCase("listarTipoPunto")) {

                List<TipoPunto> lista = jsonToList(json.getString("res"));
                if (lista.size() <= 0) {
                    Toast.makeText(this, "Por favor ingrese datos", Toast.LENGTH_SHORT).show();
                    return;
                }
                adapter = new ArrayAdapter<TipoPunto>(this, android.R.layout.simple_spinner_item, lista);
                tipoPunto.setAdapter(adapter);
            }else if (accion.equalsIgnoreCase("crear")){

                String  msj = "Se ha registrado correctamente";
                // limpiamos campos
                descripcion.setText("");
                latitud.setText("Latitud");
                longitud.setText("Longitud");
                capacidad.setText("");
                capacidad.setText("");
                 tipoPunto.setSelection(0);
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);

                Toast.makeText(this, msj, Toast.LENGTH_SHORT).show();

            } else{
                Toast.makeText(this, json.getString("res"), Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void publicFinishListas(JSONArray jsonArray) {

    }

    /**
     * registramos a una persona y su usuario
     * @param v
     */
    public void registrarPunto(View v) {

        try {
            String desc = descripcion.getText().toString();
            String lat = latitud.getText().toString();
            String lon = longitud.getText().toString();
            int capac = Integer.parseInt(capacidad.getText().toString());
            String tipoPun = tipoPunto.getSelectedItem().toString();
            PuntoEncuentro pu = new PuntoEncuentro();
            pu.setDescripcion(desc);
           pu.setLatitud(lat);
            pu.setLongitud(lon);
            pu.setCapacidad(capac);
            TipoPunto tipo= new TipoPunto();
            tipo.setNombre(tipoPun);
            pu.setTipoPunto(tipo);

            Log.e("eeeh(((((((((((((((( ", "" + pu);
            if (desc.equals(null) || lat.isEmpty() || lon.isEmpty() || capac ==0 || tipoPun.isEmpty()) {
                Toast.makeText(this, "Por favor, ingrese los datos", Toast.LENGTH_SHORT).show();
            } else {
                accion = "crear";
                /**
                 * Llamamos el servicio de consignar
                 */
                servicio = new Servicio(pu, "gestionEncuentros.php", accion, this, progreso);
                /*Se inicia la petecion*/
                servicio.delegate = this;
                servicio.execute();

            }
        }catch(NumberFormatException e){
            Toast.makeText(this, "En la cedula solo campos numericos", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }catch (NullPointerException ex){
            ex.printStackTrace();
        }

    }

}
