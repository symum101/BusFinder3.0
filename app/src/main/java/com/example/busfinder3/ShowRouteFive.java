package com.example.busfinder3;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.busfinder3.databinding.ActivityShowRouteFiveBinding;

public class ShowRouteFive extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_route_five);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map5);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng stop1latLng = new LatLng(23.728178820131962, 90.386014419716);
        LatLng stop2latLng = new LatLng(23.727067347011573, 90.42159104063707);
        LatLng stop3latLng = new LatLng(23.731932599671186, 90.42538988560166);
        LatLng stop4latLng = new LatLng(23.749660662152152, 90.41259483310688);
        LatLng stop5latLng = new LatLng(23.76523269200724, 90.42140097836071);
        LatLng stop6latLng = new LatLng(23.781049301694388, 90.40704161972658);
        MarkerOptions markerOptions_1 = new MarkerOptions().position(stop1latLng).title("Jatrabari");
        MarkerOptions markerOptions_2 = new MarkerOptions().position(stop2latLng).title("Shapla Chottor");
        MarkerOptions markerOptions_3 = new MarkerOptions().position(stop3latLng).title("Kamlapur Railway Station");
        MarkerOptions markerOptions_4 = new MarkerOptions().position(stop4latLng).title("Malibag Railgate");
        MarkerOptions markerOptions_5 = new MarkerOptions().position(stop5latLng).title("Rampura TV Center");
        MarkerOptions markerOptions_6 = new MarkerOptions().position(stop6latLng).title("BRAC University");


        mMap.addMarker(markerOptions_1);
        mMap.addMarker(markerOptions_2);
        mMap.addMarker(markerOptions_3);
        mMap.addMarker(markerOptions_4);
        mMap.addMarker(markerOptions_5);
        mMap.addMarker(markerOptions_6);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(stop1latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(stop1latLng, 16f));
    }
}