package com.example.busfinder3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class TimetableActivity extends AppCompatActivity {

    private Button btnBus1 , btnBus2 , btnBus3,  btnBus4, btnBus5;
    BottomNavigationView navbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);


        navbar = findViewById(R.id.navbar_timetable);
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





        btnBus1 = findViewById(R.id.btnBusOne);
        btnBus2 = findViewById(R.id.btnBusTwo);
        btnBus3 = findViewById(R.id.btnBusThree);
        btnBus4 = findViewById(R.id.btnBusFour);
        btnBus5 = findViewById(R.id.btnBusFive);


        btnBus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showbusBusOneTimetable();
            }
        });

        btnBus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBusTwoTimetable();
            }
        });

        btnBus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBusThreeTimetable();
            }
        });

        btnBus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBusFourTimetable();
            }
        });

        btnBus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBusFiveTimetable();
            }
        });
    }

    private void showBusFiveTimetable() {
        startActivity(new Intent(TimetableActivity.this , BusFiveTimetableActivity.class));
    }

    private void showBusFourTimetable() {
        startActivity(new Intent(TimetableActivity.this , BusFourTimetableActivity.class));

    }

    private void showBusThreeTimetable() {
        startActivity(new Intent(TimetableActivity.this , BusThreeTimetableActivity.class));
    }


    private void showBusTwoTimetable() {
        startActivity(new Intent(TimetableActivity.this , BusTwoTimetableActivity.class));
    }

    private void showbusBusOneTimetable() {
        startActivity(new Intent(TimetableActivity.this , BusOneTimetableActivity.class));
    }


}