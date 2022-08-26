package com.example.busfinder3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class MenuActivity extends AppCompatActivity {

    BottomNavigationView navbar;
    private Button btnLogout, btnHotline;
    private static int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        navbar = findViewById(R.id.navbar_menu);
        navbar.setSelectedItemId(R.id.menu);
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



        //Hotline Button
        btnHotline = findViewById(R.id.btnHotline);
        AlertDialog.Builder callDialog = new AlertDialog.Builder(MenuActivity.this);
        btnHotline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callDialog.setTitle("Call Emergency Hotline?");
                callDialog.setIcon(R.drawable.ic_baseline_error_24);
                callDialog.setMessage("Are you sure you want to call 999?");
                callDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //For Yes
                        Call();
                    }
                });

                callDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //For No
                    }
                });
                callDialog.show();
            }
        });


        //Button
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    private void Call() {
        final String number = "9nine9"; // For safety I didn't use the actual number
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(MenuActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MenuActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    public void logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(MenuActivity.this, LoginActivity.class));
    }
}