package com.example.antiquette;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

public interface ApiHandler {
    @FormUrlEncoded
    @POST("WebServices/InserUser.php")
    Call<User> insertUser(@Field("name") String name,
                          @Field("email") String email,
                          @Field("password") String password,
                          @Field("confirmPassword") String confirmPassword


    );
    @FormUrlEncoded
    @POST("WebServices/LoginUser.php")
    Call <User>LoginUser(@Field("email") String email,
                         @Field("password") String password
    );
}
