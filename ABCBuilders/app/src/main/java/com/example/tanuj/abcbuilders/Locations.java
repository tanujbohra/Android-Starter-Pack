package com.example.tanuj.abcbuilders;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Locations extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
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
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Property1 = new LatLng(19.1345841,72.8330728);
        mMap.addMarker(new MarkerOptions().position(Property1).title("Propert one"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Property1));

        LatLng p2 = new LatLng(19.1174943,72.8475946);
        mMap.addMarker(new MarkerOptions().position(p2).title("Propert two"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(p2));

        LatLng p3 = new LatLng(19.1170015,72.8510195);
        mMap.addMarker(new MarkerOptions().position(p3).title("Propert three"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(p3));

        LatLng p4 = new LatLng(19.0979402,72.8544515);
        mMap.addMarker(new MarkerOptions().position(p4).title("Propert four"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(p4));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(p3,12.0f));
    }
}

//19.1174943,72.8475946
//19.1170015,72.8510195
//19.0979402,72.8544515