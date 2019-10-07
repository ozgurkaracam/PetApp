package com.example.veterineruygulamas.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.veterineruygulamas.Pojos.SignUpPojo;
import com.example.veterineruygulamas.R;
import com.example.veterineruygulamas.RestApi.ApiServ;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    Button buttonSignUp;
    TextView editEmail,editUsername,editPassword;
    ApiServ apiServ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        buttonSignUp=findViewById(R.id.buttonSignUp);
        editEmail=findViewById(R.id.editEmail);
        editUsername=findViewById(R.id.editUsername);
        editPassword=findViewById(R.id.editPassword);
        apiServ=new ApiServ();

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("d","deneme");
                apiServ.signUp(editUsername.getText().toString(),editEmail.getText().toString(),editPassword.getText().toString()).enqueue(new Callback<SignUpPojo>() {
                    @Override
                    public void onResponse(Call<SignUpPojo> call, Response<SignUpPojo> response) {
                        Toast.makeText(SignUpActivity.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<SignUpPojo> call, Throwable t) {
                        Log.e("Error:",t.getLocalizedMessage());
                    }
                });
            }
        });
    }
}
