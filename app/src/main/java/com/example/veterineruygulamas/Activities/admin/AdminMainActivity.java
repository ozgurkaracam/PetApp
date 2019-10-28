package com.example.veterineruygulamas.Activities.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.veterineruygulamas.Activities.LoginActivity;
import com.example.veterineruygulamas.Fragments.MainAdminFragment;
import com.example.veterineruygulamas.Fragments.gelensorular;
import com.example.veterineruygulamas.R;
import com.example.veterineruygulamas.Utils.Auth;
import com.google.android.material.navigation.NavigationView;

public class AdminMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ConstraintLayout constraintLayout;
    ImageView ımageView;
    Toolbar toolbar;
    Auth auth;
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        arregements();
        listeners();

        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.app_name,R.string.app_name);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    private void arregements(){
        ımageView=findViewById(R.id.adminLogout);
        toolbar=findViewById(R.id.admintoolbar);
        auth=new Auth(this);
        setSupportActionBar(toolbar);
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new MainAdminFragment()).commit();

    }

    private void listeners(){
        ımageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Auth(AdminMainActivity.this).outAuth();
                startActivity(new Intent(AdminMainActivity.this, LoginActivity.class));
            }
        });
    }


    private void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameLayout,fragment).commit();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.action_gelenSorular:
                changeFragment(new gelensorular());
                break;
            case R.id.action_home:
                changeFragment(new MainAdminFragment());
                break;
        }
        drawer.closeDrawers();
        return false;
    }
}
