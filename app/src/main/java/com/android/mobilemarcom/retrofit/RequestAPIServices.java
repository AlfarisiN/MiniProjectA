package com.android.mobilemarcom.retrofit;

import com.android.mobilemarcom.event.modelevent.EventModul;
import com.android.mobilemarcom.model.ModelEvent;
import com.android.mobilemarcom.model.modelevent.ModelEventRetrofit;
import com.android.mobilemarcom.model.modelevent.ModelEventRetrofit;
import com.android.mobilemarcom.unit.modelunit.DataList;
import com.android.mobilemarcom.unit.modelunit.ModelUnitRetrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Irfan Naufal Ridi on 11/10/2018.
 */

public interface RequestAPIServices {
    //deklarasi method semua yg ada di API yg akan kita gunakan

    //ambil list news

    @POST("marcomm-ws/api/unit/create")
    Call<ModelUnitRetrofit> createUnit(@Header("Content-Type") String head,
                                       @Body DataList dataList);

    @PUT("marcomm-ws/api/unit/update")
    Call<ModelUnitRetrofit> editUnit(@Header("Content-Type")String head,
                                     @Header("Authorization")String auth,
                                     @Body DataList dataList);

    @PUT("marcomm-ws/api/unit/deactivate/{id}")
    Call<ModelUnitRetrofit> deactiveUnit(@Header("Content-Type")String head,
                                         @Header("Authorization")String auth,
                                         @Path("id") String dataList);

    @GET("marcomm-ws/api/unit/name/{path}")
    Call<ModelUnitRetrofit> searchUnit(@Header("Authorization")String auth,
                                       @Path("path")String id);

    @POST("marcomm-ws/api/event/create")
    Call<ModelEventRetrofit> createEvent(@Header("Content-Type")String head,
                                        @Header("Authorization")String auth,
                                        @Body com.android.mobilemarcom.model.modelevent.DataList eventModul);

    @GET("marcomm-ws/api/event/code/{pathID}")
    Call<ModelEventRetrofit> searchEvent(@Header("Authorization")String auth,
                                         @Path("pathID") String id);

    @PUT("marcomm-ws/api/unit/update")
    Call<ModelEventRetrofit> editEvent(@Header("Content-Type")String head,
                                        @Header("Authorization")String auth,
                                        @Body com.android.mobilemarcom.model.modelevent.DataList dataList);

    @GET("marcomm-ws/api/event/key/{pathID}")
    Call<ModelEventRetrofit> autoCompleteEvent(@Header("Authorization")String auth,
                                         @Path("pathID") String id);

    @PUT("marcomm-ws/api/event/reject/{pathID}/{reason}")
    Call<ModelEventRetrofit> rejectEvent(@Header("Content-Type")String head,
                                       @Header("Authorization")String auth,
                                       @Path("pathID") String pathID,
                                       @Path("reason") String reason);

    @PUT("marcomm-ws/api/event/close/{pathID}")
    Call<ModelEventRetrofit> closeEvent(@Header("Content-Type")String head,
                                         @Header("Authorization")String auth,
                                         @Path("pathID") String pathID);

    @PUT("marcomm-ws/api/event/approve/{pathID1}/{pathID2}")
    Call<ModelEventRetrofit> approvalEvent(@Header("Content-Type")String head,
                                           @Header("Authorization")String auth,
                                           @Path("pathID1") String path1,
                                           @Path("pathID2") String path2);
}
