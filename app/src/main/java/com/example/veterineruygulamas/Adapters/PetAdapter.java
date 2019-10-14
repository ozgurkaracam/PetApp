package com.example.veterineruygulamas.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.veterineruygulamas.Activities.PetsActivity;
import com.example.veterineruygulamas.Modals.PetAdapterModal;
import com.example.veterineruygulamas.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetHolder> {
        List<PetAdapterModal> PetModal;
        Context context;

    public PetAdapter(List<PetAdapterModal> petModal, Context context) {
        PetModal = petModal;
        this.context = context;
    }

    @NonNull
    @Override
    public PetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.petsrecycler,null);
        return new PetHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PetHolder holder, int position) {

            holder.petName.setText(PetModal.get(position).getAd());
            holder.petCins.setText(PetModal.get(position).getCins());
        Picasso.get().load(PetModal.get(position).getImage()).into(holder.image);



    }

    @Override
    public int getItemCount() {
        return PetModal.size();
    }

    public class PetHolder extends RecyclerView.ViewHolder {
        TextView petName,petCins;
        CardView petCardView;
        de.hdodenhof.circleimageview.CircleImageView image;
        public PetHolder(@NonNull View itemView) {
            super(itemView);
            petCardView=itemView.findViewById(R.id.petCardView);
            petName=itemView.findViewById(R.id.petName);
            petCins=itemView.findViewById(R.id.petCins);
            image=itemView.findViewById(R.id.imagess);
        }
    }
}
