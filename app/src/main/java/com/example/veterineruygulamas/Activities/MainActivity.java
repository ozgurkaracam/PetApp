package com.example.veterineruygulamas.Activities;

import androidx.appcompat.app.AppCompatActivity;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=new Auth(MainActivity.this);
    }
}
