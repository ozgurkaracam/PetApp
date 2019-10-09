package com.example.veterineruygulamas.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.veterineruygulamas.R;
import com.example.veterineruygulamas.Utils.Auth;

public class MainActivity extends AppCompatActivity {
    Auth auth;
    CardView sanalKarneler;
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
    }
}
