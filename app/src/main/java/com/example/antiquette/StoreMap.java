package com.example.antiquette;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class StoreMap extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_map);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        supportMapFragment.getMapAsync(StoreMap.this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        map =googleMap;
        map.setMapType(googleMap.MAP_TYPE_HYBRID);
        LatLng tunis=new LatLng(33.8435408,9.400138);
        LatLng benArous=new LatLng(36.6306483,10.2100827);
        map.addMarker(new MarkerOptions().position(benArous).title("Visiter notre store"));
        map.moveCamera(CameraUpdateFactory.newLatLng(tunis));
        map.getUiSettings().setZoomControlsEnabled(true);
        map.getUiSettings().setMyLocationButtonEnabled(true);
        map.getUiSettings().setAllGesturesEnabled(true);


    }

}
