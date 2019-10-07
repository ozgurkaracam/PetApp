package com.example.veterineruygulamas.RestApi;


import com.example.veterineruygulamas.Pojos.SignUpPojo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("signup.php")
    Call<SignUpPojo> at(@Field("username") String username,
                        @Field("emailadress") String emailadress,
                        @Field("password") String password);

}
