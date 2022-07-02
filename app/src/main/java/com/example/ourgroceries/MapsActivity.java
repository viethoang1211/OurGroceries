package com.example.ourgroceries;


import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.ourgroceries.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback,
        GoogleMap.OnMapClickListener,
        GoogleMap.OnMarkerClickListener, GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    Polyline polyline = null;

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
        mMap = googleMap;

        LatLng hcmus = new LatLng(10.762913,106.6821717);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hcmus));

        MarkerOptions   markerOptions = new MarkerOptions()
                .title("University of Science, VNUHCM")
                .position(hcmus)
                .draggable(true)
                .alpha(0.5f);

        Marker marker = mMap.addMarker(markerOptions);


        mMap.setOnMapClickListener(this);
        mMap.setOnMarkerClickListener(this);
        mMap.setOnMapLongClickListener(this);
        //marker.remove();

        // Add a marker in Sydney and move the camera
/*        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
  */


    }

    @Override
    public void onMapClick(LatLng latLng) {
        if (polyline == null)
        {
            PolylineOptions polylineOptions = new PolylineOptions()
                    .add(latLng)
                    .color(Color.RED)
                    .clickable(true);
            polyline = mMap.addPolyline(polylineOptions);
        }
        else
        {
            List<LatLng> pts = polyline.getPoints();
            pts.add(latLng);
            polyline.setPoints(pts);
        }
        //putOneMarkerAtLocation(latLng);
    }

    int Counter = 1;
    private void putOneMarkerAtLocation(LatLng latLng) {
        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)
                .title(String.valueOf(Counter++));
        Marker marker = mMap.addMarker(markerOptions);
        marker.setTag(Counter);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Object o = marker.getTag();
        if (o!=null) {
            int x = (int) o;
        }
        marker.remove();
        return false;
    }

    @Override
    public void onMapLongClick(LatLng latLng) {

    }
}