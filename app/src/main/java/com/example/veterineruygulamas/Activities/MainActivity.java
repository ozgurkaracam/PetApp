package com.example.veterineruygulamas.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.veterineruygulamas.R;
import com.example.veterineruygulamas.Utils.Auth;

public class MainActivity extends AppCompatActivity {
    Auth auth;
    CardView sanalKarneler,soruSorCardView;
    Toolbar toolbar;
    TextView cikisyaptext,hosgeldiniztext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arragements();
        listeners();



    }
    private void arragements(){
        auth=new Auth(MainActivity.this);
        sanalKarneler=findViewById(R.id.cardViewSanalKarneler);
        soruSorCardView=findViewById(R.id.soruSorCardView);
        cikisyaptext=findViewById(R.id.cikisyaptext);
        hosgeldiniztext=findViewById(R.id.hosgeldiniztext);
        hosgeldiniztext.setText("Hoşgeldiniz :"+auth.getUsername());
    }
    private void authcontrol(){

    }
    private void listeners(){
        sanalKarneler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,PetsActivity.class));
            }
        });

        soruSorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SoruActivity.class));
            }
        });
        cikisyaptext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.outAuth();
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });

    }
}
