package com.example.veterineruygulamas.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.veterineruygulamas.Pojos.AsiPojo;
import com.example.veterineruygulamas.R;
import com.example.veterineruygulamas.RestApi.ApiServ;
import com.example.veterineruygulamas.Utils.Auth;
import com.squareup.timessquare.CalendarPickerView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TakvimActivity extends AppCompatActivity {
    CalendarPickerView calendarPickerView;
    SimpleDateFormat dateFormat;
    TextView textViewBilgi;
    ApiServ apiServ;
    ArrayList<Date> tarihler;
    Auth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takvim);
        dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        apiServ=new ApiServ();
        calendarPickerView=findViewById(R.id.calendarPickerView);
        textViewBilgi=findViewById(R.id.textViewBilgi);
        tarihler=new ArrayList<>();
        auth=new Auth(this);
        getAsilar();
        Calendar nextYear=Calendar.getInstance();
        nextYear.add(nextYear.YEAR,1);
//        Date today = new Date();
        Calendar pastYear=Calendar.getInstance();
        pastYear.add(pastYear.MONTH,-6);
        Date date=pastYear.getTime();
        calendarPickerView.init(date, nextYear.getTime())
                .inMode(CalendarPickerView.SelectionMode.MULTIPLE)
                .withSelectedDates(tarihler);





    }

    private void getAsilar(){
        apiServ.getAsi(auth.getId()).enqueue(new Callback<List<AsiPojo>>() {
            @Override
            public void onResponse(Call<List<AsiPojo>> call, Response<List<AsiPojo>> response) {
                for(AsiPojo asiPojo: response.body()) {
                    try {
                        calendarPickerView.selectDate(dateFormat.parse(asiPojo.getTarih()));
                        clickdate(response.body());

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                }
                if(response.body().size()==0){
                    Toast.makeText(TakvimActivity.this,"Herhangi bir aşınız bulunmamaktadır.",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(TakvimActivity.this,MainActivity.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<List<AsiPojo>> call, Throwable t) {


            }
        });

    }

    private void clickdate(final List<AsiPojo> asiPojo){
        calendarPickerView.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                calendarPickerView.selectDate(date,false);

        }

            @Override
            public void onDateUnselected(Date date) {
                AlertDialog.Builder builder=new AlertDialog.Builder(TakvimActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Aşı Bilgi");
                String petad="";
                String asiad="";
                StringBuilder sb=new StringBuilder();
                for(AsiPojo asi: asiPojo){
                    if(asi.getTarih().equals(dateFormat.format(date))){
                        asiad= asi.getAsiad();
                        petad=asi.getPet().getAd();
                        sb.append(dateFormat.format(date)+" tarihinde "+petad+"'ın "+asiad+" aşısı var.\n");
                    }
                }


                builder.setMessage(sb);
                builder.create().show();

                calendarPickerView.selectDate(date);

            }
        });

    }
}
