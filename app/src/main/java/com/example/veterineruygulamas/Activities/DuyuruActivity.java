package com.example.veterineruygulamas.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.veterineruygulamas.Adapters.DuyuruAdapter;
import com.example.veterineruygulamas.Pojos.DuyuruPojo;
import com.example.veterineruygulamas.R;
import com.example.veterineruygulamas.RestApi.ApiServ;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DuyuruActivity extends AppCompatActivity {
    ApiServ apiServ;
    RecyclerView duyuruRecyclerView;
    DuyuruAdapter duyuruAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duyuru);
        arragemenets();
        getDuyuru();
    }

    private void getDuyuru(){
        apiServ.getDuyuru().enqueue(new Callback<List<DuyuruPojo>>() {
            @Override
            public void onResponse(Call<List<DuyuruPojo>> call, Response<List<DuyuruPojo>> response) {
                    duyuruAdapter=new DuyuruAdapter(DuyuruActivity.this,response.body());
                    duyuruRecyclerView.setAdapter(duyuruAdapter);
                    duyuruRecyclerView.setHasFixedSize(true);
                    duyuruRecyclerView.setLayoutManager(new LinearLayoutManager(DuyuruActivity.this));
            }

            @Override
            public void onFailure(Call<List<DuyuruPojo>> call, Throwable t) {

            }
        });

    }
    private void arragemenets(){
        apiServ=new ApiServ();
        duyuruRecyclerView=findViewById(R.id.duyuruRecyclerView);

    }
}
