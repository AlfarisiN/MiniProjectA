package com.android.mobilemarcom.employee;

public interface RequestAPIServices2 {

    //method untuk create user
    @FormUrlEncoded
    @POST("users")
    Call<ModelCreateUsers> createNewUser(@Header("token") String token,
                                          @Header("client-id") String clientId,
                                          @Field("name") String name,
                                          @Field("job") String job);

    //method untuk register user
    @FormUrlEncoded
    @POST("register")
    Call<ModelRegisterUsers> registerNewUser (@Field("email") String email,
                                              @Field("password") String password);

    //method untuk get user List
    @GET("users")
    Call<ModelListUser> getListUser(@Query("page") int page);
}
