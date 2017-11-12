package com.example.toshibap55w.controlcatastrofes;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mapa;

    public String latitud,longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;

        /*TIPO DE MAPA (NORMAL,SATELITE,HIBRIDO O RELIEVE)*/
        mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        mapa.setMyLocationEnabled(true);//ACTIVA LA VISUALIZACION
        mapa.getUiSettings().setZoomControlsEnabled(false);//SE DESACTIVAN LOS BOTONES DEL ZOOM
        mapa.getUiSettings().setCompassEnabled(true);

        mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(4.541763,-75.663464),15));

        mapa.setOnMapClickListener(this);
    }


    @Override
    public void onMapClick(LatLng latLng) {
        // Recibe por parametro la posicion exacta donde se pulso y añada un marcador
        //marcador
        latitud = String.valueOf(latLng.latitude);
        longitud = String.valueOf(latLng.longitude);
        mapa.addMarker(new MarkerOptions().position(latLng).icon(
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        Intent i = new Intent(this,PuntosEncuentro.class);
        i.putExtra("latitud",latitud);
        i.putExtra("longitud",longitud);

        Log.e("(((()))",latitud);
        Log.e("(((()))",longitud);
        startActivity(i);
    }

}
