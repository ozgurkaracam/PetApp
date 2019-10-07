package com.example.veterineruygulamas.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.veterineruygulamas.Pojos.SignInPojos;
import com.example.veterineruygulamas.R;
import com.example.veterineruygulamas.RestApi.ApiServ;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    TextView kayitOlText;
    Button buttonSignIn;
    ApiServ apiServ;
    EditText loginEmail,loginPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        kayitOlText=findViewById(R.id.kayitOlText);
        buttonSignIn=findViewById(R.id.buttonSignIn);
        apiServ=new ApiServ();
        loginEmail=findViewById(R.id.loginEmail);
        loginPassword=findViewById(R.id.loginPassword);
        kayitOlText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this,"asdas",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiServ.signIn(loginEmail.getText().toString(),loginPassword.getText().toString()).enqueue(new Callback<SignInPojos>() {
                    @Override
                    public void onResponse(Call<SignInPojos> call, Response<SignInPojos> response) {
                        Toast.makeText(LoginActivity.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<SignInPojos> call, Throwable t) {

                    }
                });
            }
        });
    }
}
