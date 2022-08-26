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

public class ShowRouteTwo extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_route_two);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng stop1latLng = new LatLng(23.778449011919097, 90.36074348904044);
        LatLng stop2latLng = new LatLng(23.785530240988432, 90.35360226575601);
        LatLng stop3latLng = new LatLng(23.80104029963686, 90.3556089117877);
        LatLng stop4latLng = new LatLng(23.80327572669936, 90.37074626575962);
        LatLng stop5latLng = new LatLng(23.792861514862896, 90.37508111972899);
        LatLng stop6latLng = new LatLng(23.781049301694388, 90.40704161972658);
        MarkerOptions markerOptions_1 = new MarkerOptions().position(stop1latLng).title("Kallyanpur Bus Stop");
        MarkerOptions markerOptions_2 = new MarkerOptions().position(stop2latLng).title("Govt. Bangla College");
        MarkerOptions markerOptions_3 = new MarkerOptions().position(stop3latLng).title("Sony Square");
        MarkerOptions markerOptions_4 = new MarkerOptions().position(stop4latLng).title("Al Helal Hospital");
        MarkerOptions markerOptions_5 = new MarkerOptions().position(stop5latLng).title("Shewrapara (Pubali Bank)");
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