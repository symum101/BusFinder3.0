package com.example.busfinder3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class AnnouncementActivity extends AppCompatActivity {

    WebView webView;
    BottomNavigationView navbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);


        navbar = findViewById(R.id.navbar_announcement);
        navbar.setSelectedItemId(R.id.announcements);
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
                        return true;

                    case R.id.menu:
                        //Toast.makeText(MainActivity.this,"Menu",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplication(), MenuActivity.class));
                        break;
                    default:

                }
                return false;
            }
        });

        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient((new WebViewClient()));
        webView.loadUrl("https://www.bracu.ac.bd/#announcement");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }


    @Override
    public void onBackPressed() {

        if(webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();
        }

    }
}