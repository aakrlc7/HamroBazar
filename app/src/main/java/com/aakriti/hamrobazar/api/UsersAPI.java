package com.aakriti.hamrobazar.api;

import com.aakriti.hamrobazar.model.ListedAds;
import com.aakriti.hamrobazar.model.TrendingAds;
import com.aakriti.hamrobazar.model.Users;
import com.aakriti.hamrobazar.serverresponse.ImageResponse;
import com.aakriti.hamrobazar.serverresponse.SignUpResponse;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UsersAPI {

    @POST("users/signup")
    Call<SignUpResponse> registerUser(@Body Users users);

    @FormUrlEncoded
    @POST("users/login")
    Call<SignUpResponse> checkUser(@Field("email") String email, @Field("password") String password);

    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @GET("users/me")
    Call<Users> getUserDetails(@Header("Authorization")String token);

    @GET("trendingads")
    Call<List<TrendingAds>>getTrentedAds();

    @GET("listedads")
    Call<List<ListedAds>>getListedAds();
}
