package com.example.veterineruygulamas.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.veterineruygulamas.Activities.LoginActivity;
import com.example.veterineruygulamas.Activities.MainActivity;

public class Auth {
    private SharedPreferences sharedPreferences;
    String  id;
    private String username;
    private String email;
    private boolean isAuth;
    private Context context;
    private SharedPreferences.Editor editor;
    private int role;
    public Auth(Context context){
            this.context=context;
            this.sharedPreferences= context.getSharedPreferences("auth",Context.MODE_PRIVATE);
            this.editor=sharedPreferences.edit();

    }
    public int getRole(){
        return this.sharedPreferences.getInt("role",0);
    }
    public void setAuth(String id,String username,String email,int role){
        this.email=email;
        this.id=id;
        this.username=username;
        this.isAuth=true;
        this.role=role;
        this.editor.putString("email",  this.email);
        this.editor.putString("id",this.id);
        this.editor.putString("username",this.username);
        this.editor.putBoolean("isAuth", this.isAuth);
        this.editor.putInt("role",this.role);
        this.editor.commit();
    }
    public boolean isAuth(){
        return this.sharedPreferences.getBoolean("isAuth",false);
    }
    public String getEmail(){
        return this.sharedPreferences.getString("email",null);
    }
    public String getId(){
        return this.sharedPreferences.getString("id","denemeee");
    }
    public String getUsername(){
        return this.sharedPreferences.getString("username",null);
    }

    public boolean outAuth(){
        editor.putBoolean("isAuth", false);
        editor.commit();
        return true;
    }

}
