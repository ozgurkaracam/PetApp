package com.example.veterineruygulamas.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.veterineruygulamas.Pojos.SoruPojo;
import com.example.veterineruygulamas.R;
import com.example.veterineruygulamas.RestApi.ApiServ;
import com.example.veterineruygulamas.Utils.Auth;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SoruActivity extends AppCompatActivity {
    Button buttonSoruSor;
    EditText editTextSoru;
    Auth auth;
    ApiServ apiServ;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru);
        prepare();
        buttonSoruSor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiServ.postSoru(editTextSoru.getText().toString(),auth.getId()).enqueue(new Callback<List<SoruPojo>>() {
                    @Override
                    public void onResponse(Call<List<SoruPojo>> call, Response<List<SoruPojo>> response) {
                        if(response.isSuccessful()){

                            Snackbar.make(linearLayout,response.code()+" Sorunuz başarıyla eklendi.",Snackbar.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<List<SoruPojo>> call, Throwable t) {

                    }
                });
            }
        });


    }

    private void prepare(){
        auth=new Auth(this);
        apiServ=new ApiServ();
        linearLayout=findViewById(R.id.linearLayout);
        buttonSoruSor=findViewById(R.id.buttonSoruSor);
        editTextSoru=findViewById(R.id.editTextSoru);
    }
}
