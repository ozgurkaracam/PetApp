package com.example.veterineruygulamas.RestApi;

import com.example.veterineruygulamas.Pojos.AsiPojo;
import com.example.veterineruygulamas.Pojos.DuyuruPojo;
import com.example.veterineruygulamas.Pojos.PetPojos;
import com.example.veterineruygulamas.Pojos.SignInPojos;
import com.example.veterineruygulamas.Pojos.SignUpPojo;
import com.example.veterineruygulamas.Pojos.SoruPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServ {

    Retrofit retrofit;
    ApiService apis ;

    public ApiServ() {
        this.retrofit = new Retrofit.Builder().baseUrl(APIUrl.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();;
        this.apis = this.retrofit.create(ApiService.class);
    }

    public Call<SignUpPojo> signUp(String username,String emailadress,String password){
        return apis.at(username,emailadress,password);
    }

    public Call<SignInPojos> signIn(String email,String password){
        return apis.signIn(email,password);
    }

    public Call<List<PetPojos>> getPets(String id){
        return apis.getPets(id);
    }

    public Call<List<SoruPojo>> postSoru(String questiontext, String creator){
        return apis.postSoru(questiontext,creator);
    }
    public Call<List<SoruPojo>> getSoru(String id){
        return apis.getSoru(id);
    }

    public Call<List<SoruPojo>> deleteSoru(String id) {return apis.deleteSoru(id);}

    public Call<List<AsiPojo>> getAsi(String id){return apis.getAsi(id);}

    public Call<List<DuyuruPojo>> getDuyuru(){return apis.getDuyuru();}

    public Call<List<AsiPojo>> getPetAsi(String id){return apis.getPetAsi(id);}
}
