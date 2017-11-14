package com.example.toshibap55w.controlcatastrofes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.toshibap55w.controlcatastrofes.modelo.Entidad;
import com.example.toshibap55w.controlcatastrofes.modelo.Noticia;
import com.example.toshibap55w.controlcatastrofes.persistencia.Servicio;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListarEntidades extends AppCompatActivity implements hiloInterfaz {

    private ProgressBar progreso;
    private Servicio servicio;
    ListView listaView;
    List<Entidad> lista;
    Entidad entidad;

    private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_entidades);
        // gestionEntidades.php

        listaView = (ListView) findViewById(R.id.listaEntidades);
        progreso = (ProgressBar) findViewById(R.id.progreso);
        progreso.setVisibility(View.INVISIBLE);
        servicio = new Servicio(new Object(),"gestionEntidades.php","listar",this,progreso);
        servicio.delegate=this;
        servicio.execute();
        listaView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                entidad = lista.get(position);
                Intent i = new Intent(getApplicationContext(), VerEntidades.class);
                i.putExtra("entidad",entidad);
                startActivity(i);

            }

        });

    }

    public List<Entidad> jsonToList(String json) throws JSONException {
        JSONArray arrayJson = new JSONArray(json);
        List<Entidad> lista = new ArrayList<Entidad>();
        Gson gson = new Gson();
        for (int i = 0; i < arrayJson.length(); i++) {
            Entidad n = gson.fromJson(arrayJson.getJSONObject(i).toString(),Entidad.class);
            lista.add(n);
        }
        return lista;
    }

    @Override
    public void publicFinish(JSONObject json) {

        try{

            lista=jsonToList(json.getString("res"));
            if(lista.size()<=0){
                Toast.makeText(this,"Por favor ingrese datos",Toast.LENGTH_SHORT).show();
                return;
            }
            adapter =new ArrayAdapter<Entidad>(this,android.R.layout.simple_list_item_1,lista);
            listaView.setAdapter(adapter);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Apenas se haga el Execute se ejecuta el metodo
    @Override
    public void publicFinishListas(JSONArray jsonArray) {
    }
}
