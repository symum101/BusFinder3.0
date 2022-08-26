package com.example.busfinder3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ShowRouteOne extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_route_one);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        LatLng stop1latLng = new LatLng(23.88016586518908, 90.40110318435252);
        LatLng stop2latLng = new LatLng(23.868257031545067, 90.40013197116362);
        LatLng stop3latLng = new LatLng(23.861532080203467, 90.40014804602853);
        LatLng stop4latLng = new LatLng(23.852504404053338, 90.40802463508375);
        LatLng stop5latLng = new LatLng(23.829835333942494, 90.42021331179345);
        LatLng stop6latLng = new LatLng(23.781049301694388, 90.40704161972658);
        MarkerOptions markerOptions_1 = new MarkerOptions().position(stop1latLng).title("Abdullahpur Bus Stand");
        MarkerOptions markerOptions_2 = new MarkerOptions().position(stop2latLng).title("Azampur Bus Stand");
        MarkerOptions markerOptions_3 = new MarkerOptions().position(stop3latLng).title("Jasimuddin Square");
        MarkerOptions markerOptions_4 = new MarkerOptions().position(stop4latLng).title("Airport Bus Stand");
        MarkerOptions markerOptions_5 = new MarkerOptions().position(stop5latLng).title("Khilkhet Bus Stand");
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