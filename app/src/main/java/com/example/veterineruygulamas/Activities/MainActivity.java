package com.example.veterineruygulamas.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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
    CardView sanalKarneler,soruSorCardView,takvimCardView,cardViewDuyuru,cardViewCallUs;
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
        takvimCardView=findViewById(R.id.takvimCardView);
        cardViewDuyuru=findViewById(R.id.cardViewDuyuru);
        cardViewCallUs=findViewById(R.id.cardViewCallUs);
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

        takvimCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TakvimActivity.class));
            }
        });
        cardViewDuyuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,DuyuruActivity.class));
            }
        });
        cardViewCallUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:+905363475667"));
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
                }
                else{
                    startActivity(intent);
                }

            }
        });

    }
}
