package com.android.mobilemarcom.employee;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RequestAPIServices2 {

    //method untuk create user
    @FormUrlEncoded
    @POST("users")
    Call<ModelEmployee> createNewUser(@Header("token") String token,
                                      @Header("client-id") String clientId,
                                      @Field("name") String name,
                                      @Field("job") String job);

    //method untuk register user
//    @FormUrlEncoded
//    @POST("register")
//    Call<ModelRegisterUsers> registerNewUser (@Field("email") String email,
//                                              @Field("password") String password);
//
//    //method untuk get user List
//    @GET("users")
//    Call<ModelListUser> getListUser(@Query("page") int page);
}
