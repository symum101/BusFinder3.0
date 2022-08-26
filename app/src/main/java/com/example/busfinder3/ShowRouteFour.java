package com.example.busfinder3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ShowRouteFour extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_route_four);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map4);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng stop1latLng = new LatLng(23.728178820131962, 90.386014419716);
        LatLng stop2latLng = new LatLng(23.733600509971957, 90.38460743948653);
        LatLng stop3latLng = new LatLng(23.74899430147168, 90.37939297073166);
        LatLng stop4latLng = new LatLng(23.754036451297242, 90.37656289251719);
        LatLng stop5latLng = new LatLng(23.759239871699076, 90.38383558925959);
        LatLng stop6latLng = new LatLng(23.781049301694388, 90.40704161972658);
        MarkerOptions markerOptions_1 = new MarkerOptions().position(stop1latLng).title("Azimpur Bus Stand");
        MarkerOptions markerOptions_2 = new MarkerOptions().position(stop2latLng).title("New Market");
        MarkerOptions markerOptions_3 = new MarkerOptions().position(stop3latLng).title("Kalabagan");
        MarkerOptions markerOptions_4 = new MarkerOptions().position(stop4latLng).title("Sobhanbag");
        MarkerOptions markerOptions_5 = new MarkerOptions().position(stop5latLng).title("Khejur Bagan Mor");
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