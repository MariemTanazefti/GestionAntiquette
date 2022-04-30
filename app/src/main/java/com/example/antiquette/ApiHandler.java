package com.example.antiquette;

import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

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

    @GET("WebServices/GetProduct.php")
    Call<List<Produit>> getProducts(@Query("key") String keyword);
    @FormUrlEncoded
    @POST("WebServices/insertCart.php")
    Call<Produit> insertProduct(@Field ("nameProductCart") String nameProductCart,
                                @Field("priceProductCart") String priceProductCart,
                                @Field("imageProductCart") String imageProductCart


    );
}
