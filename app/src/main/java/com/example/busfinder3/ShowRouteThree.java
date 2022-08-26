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

public class ShowRouteThree extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_route_three);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map3);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng stop1latLng = new LatLng(23.7400199501424, 90.37543739643272);
        LatLng stop2latLng = new LatLng(23.751811327540743, 90.3684600810921);
        LatLng stop3latLng = new LatLng(23.75753429790395, 90.3612891504077);
        LatLng stop4latLng = new LatLng(23.758765708942686, 90.37415943072176);
        LatLng stop6latLng = new LatLng(23.781049301694388, 90.40704161972658);
        MarkerOptions markerOptions_1 = new MarkerOptions().position(stop1latLng).title("Jigatola Bus Stand");
        MarkerOptions markerOptions_2 = new MarkerOptions().position(stop2latLng).title("Shankor Bus Stop");
        MarkerOptions markerOptions_3 = new MarkerOptions().position(stop3latLng).title("Mohammadpur Bus Stand");
        MarkerOptions markerOptions_4 = new MarkerOptions().position(stop4latLng).title("Manik Mia Aveneu");
        MarkerOptions markerOptions_6 = new MarkerOptions().position(stop6latLng).title("BRAC University");


        mMap.addMarker(markerOptions_1);
        mMap.addMarker(markerOptions_2);
        mMap.addMarker(markerOptions_3);
        mMap.addMarker(markerOptions_4);
        mMap.addMarker(markerOptions_6);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(stop1latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(stop1latLng, 16f));
    }
}