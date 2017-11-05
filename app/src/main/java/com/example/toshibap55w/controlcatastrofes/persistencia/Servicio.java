package com.example.toshibap55w.controlcatastrofes.persistencia;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TOSHIBAP55W on 4/11/2017.
 */
public class Servicio extends AsyncTask<Void, String, Boolean> {


    /**
     * Variable que almacena el resultado del servidor
     */
    private StringBuffer buffer = null;

    /**
     * el objeto a trabajar
     */
    private Object objeto;

    /**
     * La accion quese realizara en el servidor: buscar, crear, eliminar, editar, listar
     */
    private String accion;

    /**
     * Url a la que se le realiza la peticion
     */
    private String ruta = "http://universidad.peliston.com/android2/catastrofes/controlador/";

    /**
     * Referencia de la actividad que realizo la peticion
     */
    private Activity activity;

    /**
     * Referencia a la barra de carga de la actividad
     */
    private ProgressBar carga;

    /* Definimos el tipo de clase del objeto */
    private Class clase;

    /**
     * Constructor sin parametros
     */
    public Servicio(){
    }

    private ListView listView;

    /**
     * Constructor
     */
    public Servicio(Object objeto, String url, String accion, Activity activity, ProgressBar carga){
        this.accion = accion;
        this.carga = carga;
        this.activity = activity;
        this.ruta = ruta+url;
        this.objeto = objeto;
        this.clase = objeto.getClass();
    }

    @Override
    protected void onPreExecute() {
        //Se activa la barra de carga
        carga.setVisibility(View.VISIBLE);
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        // Se define el objeto para la conexion
        HttpURLConnection conn = null;
        // Se define un buffer para leer los resultados de la conexion
        BufferedReader reader = null;
        try {
            // Se crea la conexion
            // Se establece un objeto URL con la ruta definida, para el consumo del servicio rest
            URL url = new URL(ruta);
            // Se añade la url a la conexion
            conn = (HttpURLConnection) url.openConnection();
            // Se define el tipo de conexion (GET - POST)
            conn.setRequestMethod("POST");
            //Convertimos el objeto en formato json
            Gson gson = new Gson();
            String json = gson.toJson(objeto);
            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("object",json)
                    .appendQueryParameter("action",accion);
            String query = builder.build().getEncodedQuery();
            // Se añaden los datos
            // Se define un ouputstream para añadir los datos definidos a la conexion
            OutputStream out = conn.getOutputStream();
            // Se pasan a un Buffer
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            // Se aladen
            writer.write(query);
            // Se confirma
            writer.flush();
            // Se cierra la edicion
            writer.close();
            out.close();
            // Se ejecuta la conexion
            publishProgress("Se estan enviando los datos...");
            conn.connect();
            // Con un InputStream se obtienen los datos de la conexion
            InputStream stream = conn.getInputStream();
            // Se define un reader para leer los datos, asociandolo al inputStream
            reader = new BufferedReader(new InputStreamReader(stream));
            // Se inicializa el buffer para almacenar como Strins los resultados
            buffer = new StringBuffer();
            // Variable temporal para concatenar los datos leidos
            String line;
            // Mientras lo que lea sea diferente de vacio
            while ((line = reader.readLine()) != null){
                // Añadimos al Buffer global
                buffer.append(line);
            }
        }catch(MalformedURLException e){
            publishProgress("Error: Mal estructura de la url"+e.getMessage());
            e.printStackTrace();
            return false;
        }catch (IOException e){
            publishProgress("Error IO"+e.getMessage());
            e.printStackTrace();
        }finally {
            // Desconecta la conexion actida
            if(conn != null){
                conn.disconnect();
            }
            try{
                // Cerramos los readers
                if(reader != null){
                    reader.close();
                }
            }catch (IOException e){
                publishProgress("Error al final "+e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        Toast.makeText(activity, values[0], Toast.LENGTH_SHORT).show();
    }

    /**
     * pasa un array json a un list
     */
    public List<Object> jsonToList(String json) throws JSONException {
        JSONArray arrayJson = new JSONArray(json);
        List<Object> lista = new ArrayList<Object>();
        for (int i = 0; i < arrayJson.length(); i++) {
            lista.add((Object)arrayJson.getJSONObject(i));
        }
        return lista;
    }

    @Override
    protected void onPostExecute(Boolean resultado) {
        // Se oculta la barra de carga
        carga.setVisibility(View.INVISIBLE);
        try{
            if(resultado){
                // como el resultado obtenido es un array json, se pasa al String JSOnArray
                JSONArray jsonArray = new JSONArray(buffer.toString());
                // por cada elemento del json
                for (int i=0;i<jsonArray.length();i++){
                    // Se saca el objeto del array y se pasa a un objeto json
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if(accion.equals("listar")){
                        List<Object> listado = jsonToList(jsonObject.getString("res"));
                        //List<T> lista = (clase) listado;
                        ArrayAdapter<Object> adapter = new ArrayAdapter<Object>(activity,android.R.layout.simple_list_item_1,listado);
                        listView.setAdapter(adapter);
                    }else{
                        // Se saca la variable del objeto
                        Toast.makeText(activity, "Operacion exitosa," + jsonObject.getString("res"), Toast.LENGTH_SHORT).show();
                    }
                }
            }else{
                Toast.makeText(activity, "Error en la operacion",Toast.LENGTH_SHORT).show();
            }
        }catch (JSONException e){
            Toast.makeText(activity, "Error tratando el resultado "+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String url) {
        this.ruta = ruta+url;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public ProgressBar getCarga() {
        return carga;
    }

    public void setCarga(ProgressBar carga) {
        this.carga = carga;
    }

    public ListView getListView() {
        return listView;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
    }
}
