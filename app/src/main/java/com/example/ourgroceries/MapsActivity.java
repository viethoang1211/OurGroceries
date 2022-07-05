package com.example.ourgroceries;


import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.ourgroceries.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.List;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener, GoogleMap.OnMapLongClickListener {
    Button bt_scan;
    private Object Button;
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    int message;
    public static final String EXTRA_MESSAGE = "message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Intent intent = getIntent();
        message = intent.getIntExtra(EXTRA_MESSAGE, 0);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng D5Branch = new LatLng(10.762913, 106.6821717);
        LatLng D10Branch = new LatLng(10.7794236, 106.6424814);
        LatLng D1Branch = new LatLng(10.7875487, 106.7031019);
        LatLng DTBBranch = new LatLng(10.8184684, 106.6566358);
        MarkerOptions markerOptions1 = new MarkerOptions()
                .title("District 1 Branch")
                .position(D1Branch)
                .alpha(0.9f);
        MarkerOptions markerOptions2 = new MarkerOptions()
                .title("District 10 Branch")
                .position(D10Branch)
                .alpha(0.9f);
        MarkerOptions markerOptions3 = new MarkerOptions()
                .title("District 5 Branch")
                .position(D5Branch)
                .alpha(0.9f);
        MarkerOptions markerOptions4 = new MarkerOptions()
                .title("District TB Branch")
                .position(DTBBranch)
                .alpha(0.9f);
        if (message == 0) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(D10Branch, 11));
            Marker marker1 = mMap.addMarker(markerOptions1);
            marker1.setTag("1");
            Marker marker2 = mMap.addMarker(markerOptions2);
            marker2.setTag("2");
            Marker marker3 = mMap.addMarker(markerOptions3);
            marker3.setTag("3");
            Marker marker4 = mMap.addMarker(markerOptions4);
            marker4.setTag("4");
        }
        else if(message==1){
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(D1Branch, 11));
            Marker marker1 = mMap.addMarker(markerOptions1);
            marker1.setTag("1");
        }
        else if(message==2){
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(D10Branch, 11));
            Marker marker2 = mMap.addMarker(markerOptions2);
            marker2.setTag("2");
        }
        else if(message==3){
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(D5Branch, 11));
            Marker marker3 = mMap.addMarker(markerOptions3);
            marker3.setTag("3");
        }
        else {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DTBBranch, 11));
            Marker marker4 = mMap.addMarker(markerOptions4);
            marker4.setTag("4");
        }
        mMap.setOnMarkerClickListener(this);
        mMap.setOnMapLongClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        String string = marker.getTag().toString();
        int x = Integer.parseInt(string.toString());
        Intent intent = new Intent(this, BranchInfo.class);
        intent.putExtra(BranchInfo.EXTRA_MESSAGE,x);
        startActivity(intent);
        return false;
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
      // implement in the future
    }
}