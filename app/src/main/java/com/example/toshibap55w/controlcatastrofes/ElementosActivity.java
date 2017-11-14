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

import com.example.toshibap55w.controlcatastrofes.modelo.Elemento;
import com.example.toshibap55w.controlcatastrofes.modelo.Entidad;
import com.example.toshibap55w.controlcatastrofes.persistencia.Servicio;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ElementosActivity extends AppCompatActivity  implements hiloInterfaz {

    ListView lvElementos;
    private ArrayAdapter adapter;
    private ProgressBar progreso;
    private Servicio servicio;
    List<Elemento> lista;
    Elemento elemento;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elementos);
    lvElementos = (ListView) findViewById(R.id.lvElementos);



        progreso = (ProgressBar) findViewById(R.id.progressBar);
        progreso.setVisibility(View.INVISIBLE);
        servicio = new Servicio(new Object(),"gestionListados.php","listarElementos",this,progreso);
        servicio.delegate=this;
        servicio.execute();
        lvElementos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                elemento = lista.get(position);
                Intent i = new Intent(getApplicationContext(), VerElemento.class);
                i.putExtra("elemento",elemento);
                startActivity(i);

            }

        });


    }

    public List<Elemento> jsonToList(String json) throws JSONException {
        JSONArray arrayJson = new JSONArray(json);
        List<Elemento> lista = new ArrayList<Elemento>();
        Gson gson = new Gson();
        for (int i = 0; i < arrayJson.length(); i++) {
            Elemento n = gson.fromJson(arrayJson.getJSONObject(i).toString(),Elemento.class);
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
            adapter =new ArrayAdapter<Elemento>(this,android.R.layout.simple_list_item_1,lista);
            lvElementos.setAdapter(adapter);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Apenas se haga el Execute se ejecuta el metodo
    @Override
    public void publicFinishListas(JSONArray jsonArray) {
    }



}
