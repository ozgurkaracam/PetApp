package com.example.veterineruygulamas.RestApi;

import com.example.veterineruygulamas.Pojos.SignUpPojo;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServ {

    Retrofit retrofit;
    ApiService apis ;

    public ApiServ() {
        this.retrofit = new Retrofit.Builder().baseUrl(APIUrl.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();;
        this.apis = this.retrofit.create(ApiService.class);;
    }

    public Call<SignUpPojo> signUp(String username,String emailadress,String password){
        return apis.at(username,emailadress,password);
    }

}
