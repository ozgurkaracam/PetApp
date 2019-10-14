package com.example.veterineruygulamas.RestApi;

import com.example.veterineruygulamas.Pojos.PetPojos;
import com.example.veterineruygulamas.Pojos.SignInPojos;
import com.example.veterineruygulamas.Pojos.SignUpPojo;

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

}
