package com.example.veterineruygulamas.Adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
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
import com.example.veterineruygulamas.Pojos.AsiPojo;
import com.example.veterineruygulamas.R;
import com.example.veterineruygulamas.RestApi.ApiServ;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetHolder> {
        List<PetAdapterModal> PetModal;
        Context context;
        ApiServ apiServ;

    public PetAdapter(List<PetAdapterModal> petModal, Context context) {
        PetModal = petModal;
        this.context = context;
        apiServ=new ApiServ();
    }

    @NonNull
    @Override
    public PetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.petsrecycler,null);
        return new PetHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PetHolder holder, int position) {
        apiServ.getPetAsi(PetModal.get(position).getId()).enqueue(new Callback<List<AsiPojo>>() {
            @Override
            public void onResponse(Call<List<AsiPojo>> call, Response<List<AsiPojo>> response) {
                SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
                StringBuilder stringBuilder=new StringBuilder();
                StringBuilder asikarnesi=new StringBuilder();
                StringBuilder gunugelecek=new StringBuilder();
                for(AsiPojo asiPojo:response.body()){

                    try {
                        Date tarih=dateFormat.parse(asiPojo.getTarih());
                        Date today= Calendar.getInstance().getTime();
                        if(tarih.compareTo(today)>0 && asiPojo.getAsidurum()==false){
                            gunugelecek.append(asiPojo.getTarih() + "\t "+asiPojo.getAsiad()+"\n");
                        }
                        if(tarih.compareTo(today)<0 && asiPojo.getAsidurum()==true){
                            asikarnesi.append(asiPojo.getTarih() + "\t "+asiPojo.getAsiad()+"\n");
                        }
                        if(tarih.compareTo(today)<0 && asiPojo.getAsidurum()==false){
                            holder.gunugecenbaslik.setVisibility(View.VISIBLE);
                            stringBuilder.append(asiPojo.getTarih() + "\t "+asiPojo.getAsiad()+"\n");
                        }





                    } catch (ParseException e) {
                        e.printStackTrace();
                    }




                }
                holder.gelecekAsilar.setText(gunugelecek);
                holder.petAsiKarnesi.setText(asikarnesi);
                holder.gunuGecenAsilar.setText(stringBuilder);
            }

            @Override
            public void onFailure(Call<List<AsiPojo>> call, Throwable t) {

            }
        });
            holder.petName.setText(PetModal.get(position).getAd());
            holder.petCins.setText("Cinsi : "+PetModal.get(position).getCins());
        holder.textViewPetKilo.setText("Kilosu :"+PetModal.get(position).getKilo());
        Picasso.get().load(PetModal.get(position).getImage()).into(holder.image);



    }

    @Override
    public int getItemCount() {
        return PetModal.size();
    }

    public class PetHolder extends RecyclerView.ViewHolder {
        TextView petName,petCins,textViewPetKilo,gunuGecenAsilar,gelecekAsilar,petAsiKarnesi,gunugecenbaslik;
        CardView petCardView;

        de.hdodenhof.circleimageview.CircleImageView image;
        public PetHolder(@NonNull View itemView) {
            super(itemView);
            textViewPetKilo=itemView.findViewById(R.id.textViewPetKilo);
            petCardView=itemView.findViewById(R.id.petCardView);
            petName=itemView.findViewById(R.id.petName);
            petCins=itemView.findViewById(R.id.petCins);
            image=itemView.findViewById(R.id.imagess);
            gunuGecenAsilar=itemView.findViewById(R.id.gunuGecenAsilar);
            gelecekAsilar=itemView.findViewById(R.id.gelecekAsilar);
            petAsiKarnesi=itemView.findViewById(R.id.petAsiKarnesi);
            gunugecenbaslik=itemView.findViewById(R.id.gunugecenbaslik);
        }
    }
}
