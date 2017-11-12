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

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class SeccionNoticias extends AppCompatActivity implements ListView.OnItemClickListener, HiloInterfaz{

    private ProgressBar progreso;

    private Servicio servicio;

    ListView listView;

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccion_noticias);
        progreso = (ProgressBar) findViewById(R.id.progreso);
        progreso.setVisibility(View.INVISIBLE);
        listView = (ListView) findViewById(R.id.listaNoticias);
        servicio = new Servicio(new Object(),"gestionNoticias.php","listar",this,progreso);
        servicio.delegate=this;
        servicio.execute();

    }

    public void irDetalleNoticia(View v){

        Intent i = new Intent(this,DetalleNoticia.class);
        startActivity(i);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


    }

    public List<Noticia> jsonToList(String json) throws JSONException {
        JSONArray arrayJson = new JSONArray(json);
        List<Noticia> lista = new ArrayList<Noticia>();
        Gson gson = new Gson();
        for (int i = 0; i < arrayJson.length(); i++) {
            Noticia n = gson.fromJson(arrayJson.getJSONObject(i).toString(),Noticia.class);
            lista.add(n);
        }
        return lista;
    }

    @Override
    public void publicFinish(JSONObject json) {
        try{

            List<Noticia> lista=jsonToList(json.getString("res"));
            if(lista.size()<=0){
                Toast.makeText(this,"Por favor ingrese datos",Toast.LENGTH_SHORT).show();
                return;
            }
            adapter =new ArrayAdapter<Noticia>(this,android.R.layout.simple_list_item_1,lista);
            listView.setAdapter(adapter);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void publicFinishListas(JSONArray jsonArray) {

    }
}
