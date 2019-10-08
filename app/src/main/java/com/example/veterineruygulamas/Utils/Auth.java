package com.example.veterineruygulamas.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.veterineruygulamas.Activities.LoginActivity;
import com.example.veterineruygulamas.Activities.MainActivity;

public class Auth {
    private SharedPreferences sharedPreferences;
    private int id;
    private String username;
    private String email;
    private boolean isAuth;
    private Context context;
    private SharedPreferences.Editor editor;
    public Auth(Context context){
            this.context=context;
            this.sharedPreferences= context.getSharedPreferences("auth",Context.MODE_PRIVATE);
            this.editor=sharedPreferences.edit();

    }
    public void setAuth(int id,String username,String email){
        this.email=email;
        this.id=id;
        this.username=username;
        this.isAuth=true;

        this.editor.putString("email",  this.email);
        this.editor.putInt("id",this.id);
        this.editor.putString("username",this.username);
        this.editor.putBoolean("isAuth", this.isAuth);
        this.editor.commit();
    }
    public boolean isAuth(){
        return this.sharedPreferences.getBoolean("isAuth",false);
    }
    public String getEmail(){
        return this.sharedPreferences.getString("email",null);
    }
    public String getId(){
        return this.sharedPreferences.getString("id",null);
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
