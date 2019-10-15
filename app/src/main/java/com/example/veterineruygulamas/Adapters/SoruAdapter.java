package com.example.veterineruygulamas.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.veterineruygulamas.Pojos.AskPojo;
import com.example.veterineruygulamas.Pojos.SoruPojo;
import com.example.veterineruygulamas.R;
import com.example.veterineruygulamas.RestApi.ApiServ;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SoruAdapter extends RecyclerView.Adapter<SoruAdapter.PetHolder> {
    List<SoruPojo> Soru;
    Context context;
    ApiServ apiServ;

    public SoruAdapter(List<SoruPojo> petModal, Context context) {
        Soru = petModal;
        this.context = context;
        apiServ=new ApiServ();
    }

    @NonNull
    @Override
    public PetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.sorurecycler,null);
        return new PetHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PetHolder holder, final int position) {

            holder.textViewSoru.setText(Soru.get(position).getQuestiontext());
            if(Soru.get(position).getAskes().isEmpty()){
                    holder.cevapKontrol.setText("Sorunuz Henüz Cevaplanmamıştır.");

            }
            else{

                holder.cevapKontrol.setText("Sorunuz Cevaplanmıştır. Cevabı görmek için tıklayınız.");
                holder.cardViewSoru.setClickable(true);
                holder.cardViewSoru.setBackgroundColor(Color.parseColor("#76FF03"));
                holder.cardViewSoru.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final AlertDialog.Builder builder=new AlertDialog.Builder(context);
                        builder.setTitle("Sorunuzun cevabı :");
                        builder.setCancelable(true);
                        StringBuilder sb=new StringBuilder();
                        for(AskPojo askPojo:Soru.get(position).getAskes()){
                            sb.append(askPojo.getCevaptext()+"\n\n\n");
                        }
                        builder.setPositiveButton("Çıkış", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        builder.setNegativeButton("Soruyu Sil", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                    apiServ.deleteSoru(Soru.get(position).getId()).enqueue(new Callback<List<SoruPojo>>() {
                                        @Override
                                        public void onResponse(Call<List<SoruPojo>> call, Response<List<SoruPojo>> response) {
                                            Toast.makeText(context,"Soru silindi.",Toast.LENGTH_SHORT).show();

                                            Soru.remove(position);
                                            notifyDataSetChanged();
                                            Soru.notifyAll();
                                            Soru.notify();
                                        }

                                        @Override
                                        public void onFailure(Call<List<SoruPojo>> call, Throwable t) {

                                        }
                                    });
                            }
                        });
                        builder.setMessage(sb);
                        builder.create().show();
                    }
                });
            }


    }

    @Override
    public int getItemCount() {
        return Soru.size();
    }

    public class PetHolder extends RecyclerView.ViewHolder {
        TextView textViewSoru,cevapKontrol;
        CardView cardViewSoru;
        public PetHolder(@NonNull View itemView) {
            super(itemView);
            textViewSoru=itemView.findViewById(R.id.textViewSoru);
            cevapKontrol=itemView.findViewById(R.id.cevapKontrol);
            cardViewSoru=itemView.findViewById(R.id.cardViewSoru);
        }
    }
}
