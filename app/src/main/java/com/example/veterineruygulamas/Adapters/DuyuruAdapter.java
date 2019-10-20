package com.example.veterineruygulamas.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.veterineruygulamas.Pojos.DuyuruPojo;
import com.example.veterineruygulamas.R;

import java.util.List;

public class DuyuruAdapter extends RecyclerView.Adapter<DuyuruAdapter.ViewHolder> {
    private Context context;
    private List<DuyuruPojo> liste;

    public DuyuruAdapter(Context context, List<DuyuruPojo> liste) {
        this.context = context;
        this.liste = liste;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.duyururecycler,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewDuyuru.setText(liste.get(position).getDuyurutext());
        holder.textViewDuyuruTarih.setText(liste.get(position).getDuyurutarih());

    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewDuyuru;
        TextView textViewDuyuruTarih;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDuyuru=itemView.findViewById(R.id.textViewDuyuru);
            textViewDuyuruTarih=itemView.findViewById(R.id.duyuruTarih);
        }
    }
}
