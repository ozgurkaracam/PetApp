package com.example.veterineruygulamas.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.veterineruygulamas.Adapters.PetAdapter;
import com.example.veterineruygulamas.Modals.PetAdapterModal;
import com.example.veterineruygulamas.R;

import java.util.ArrayList;
import java.util.List;

public class PetsActivity extends AppCompatActivity {
    ArrayList<PetAdapterModal> petList;
    PetAdapter petAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);
        recyclerView=findViewById(R.id.recyclerView);
        petList=new ArrayList<>();
        petList.add(new PetAdapterModal("https://cdn.webshopapp.com/shops/15426/files/15847093/560x625x2/kek-amsterdam-duvar-cikartmasi-golden-retriever-ko.jpg","Şans","Golden"));

        petList.add(new PetAdapterModal("https://www.miyhav.com/icerik/uploads/2017/11/van-kedisi-820x510.jpg","Kedicik","Van Kedisi"));

        petAdapter=new PetAdapter(petList,PetsActivity.this);
        recyclerView.setAdapter(petAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

    }
}
