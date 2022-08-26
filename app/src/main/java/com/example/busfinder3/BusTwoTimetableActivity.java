package com.example.busfinder3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BusTwoTimetableActivity extends AppCompatActivity {

    BottomNavigationView navbar;
    private static final int REQUEST_CALL = 1;
    private Button callBtn, showRouteBtn;
    private final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_two_timetable);

        navbar = findViewById(R.id.navbar_t2);
        navbar.setSelectedItemId(R.id.timetable);
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

        showRouteBtn = findViewById(R.id.btn_showRoute2);
        showRouteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRoute();
            }

            private void showRoute() {
                startActivity(new Intent(BusTwoTimetableActivity.this, ShowRouteTwo.class));
            }
        });

        callBtn = findViewById(R.id.callbtnBusTwo);
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call();
            }
        });

    }

    private void Call() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final String number = snapshot.child("Conductors").child("conductor_2_number").getValue(String.class);

                if (number.trim().length() > 0) {
                    if (ContextCompat.checkSelfPermission(BusTwoTimetableActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(BusTwoTimetableActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                    } else {
                        String dial = "tel:" + number;
                        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                    }
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(BusTwoTimetableActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Call();
            } else {
                Toast.makeText(this, "Permission DENIED!", Toast.LENGTH_SHORT).show();

            }
        }
    }
}