package com.example.busfinder3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private GoogleMap mMap;

    BottomNavigationView navbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_main);

        navbar = findViewById(R.id.navbar);
        navbar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){

                    case R.id.find:
                        startActivity(new Intent(getApplication(), MapsActivity.class));
                        break;

                    case R.id.timetable:
                        //Toast.makeText(MainActivity.this,"Timetable",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplication(), TimetableActivity.class));
                        break;

                    case R.id.announcements:
                        //Toast.makeText(MainActivity.this,"Announcements",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplication(), AnnouncementActivity.class));
                        overridePendingTransition(0,0);
                        break;

                    case R.id.menu:
                        //Toast.makeText(MainActivity.this,"Menu",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplication(), MenuActivity.class));
                        break;
                    default:

                }
                return true;
            }
        });
        mAuth = FirebaseAuth.getInstance();
    }
//------------------------------------onCreate ends here--------------------------------------------
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }
}