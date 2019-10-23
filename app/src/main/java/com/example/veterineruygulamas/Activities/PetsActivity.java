package com.example.veterineruygulamas.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.veterineruygulamas.Adapters.PetAdapter;
import com.example.veterineruygulamas.Modals.PetAdapterModal;
import com.example.veterineruygulamas.Pojos.PetPojos;
import com.example.veterineruygulamas.R;
import com.example.veterineruygulamas.RestApi.ApiServ;
import com.example.veterineruygulamas.Utils.Auth;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetsActivity extends AppCompatActivity {
    ArrayList<PetAdapterModal> petList;
    PetAdapter petAdapter;
    RecyclerView recyclerView;
    ApiServ apiServ;
    Auth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);
        recyclerView=findViewById(R.id.recyclerView);
        apiServ=new ApiServ();
        auth=new Auth(this);
        petList=new ArrayList<PetAdapterModal>();
        apiServ.getPets(auth.getId()).enqueue(new Callback<List<PetPojos>>() {


            @Override
            public void onResponse(Call<List<PetPojos>> call, Response<List<PetPojos>> response) {

                    if(response.isSuccessful()){
                        for(PetPojos petPojos: response.body()){
                            petList.add(new PetAdapterModal(petPojos.getImage(),petPojos.getAd(),petPojos.getCins(),petPojos.getId(),petPojos.getKilo()));
                        }
                        petAdapter=new PetAdapter(petList,PetsActivity.this);
                        recyclerView.setAdapter(petAdapter);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new GridLayoutManager(PetsActivity.this,1));
                    }

            }



            @Override
            public void onFailure(Call<List<PetPojos>> call, Throwable t) {
                    Log.e("e",t.getLocalizedMessage());
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.setAdapter(petAdapter);
    }
}
