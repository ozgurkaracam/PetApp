package com.example.veterineruygulamas.RestApi;


import com.example.veterineruygulamas.Pojos.AsiPojo;
import com.example.veterineruygulamas.Pojos.DuyuruPojo;
import com.example.veterineruygulamas.Pojos.PetPojos;
import com.example.veterineruygulamas.Pojos.SignInPojos;
import com.example.veterineruygulamas.Pojos.SignUpPojo;
import com.example.veterineruygulamas.Pojos.SoruPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @FormUrlEncoded
    @POST("users")
    Call<SignUpPojo> at(@Field("username") String username,
                        @Field("emailadress") String emailadress,
                        @Field("password") String password);

    @FormUrlEncoded
    @POST("users/login")
    Call<SignInPojos> signIn(@Field("emailadress") String email,
                             @Field("password") String password);

    @GET("pets/{id}")
    Call<List<PetPojos>> getPets(@Path("id") String id);

    @FormUrlEncoded
    @POST("soru/")
    Call<List<SoruPojo>> postSoru(@Field("questiontext") String questiontext,
                                  @Field("creator") String creator);

    @GET("soru/{id}")
    Call<List<SoruPojo>> getSoru(@Path("id") String id);

    @DELETE("soru/{id}")
    Call<List<SoruPojo>> deleteSoru(@Path("id") String id);

    @GET("asi/sahip/{id}")
    Call<List<AsiPojo>> getAsi(@Path("id") String id);

    @GET("duyuru")
    Call<List<DuyuruPojo>> getDuyuru();
}
