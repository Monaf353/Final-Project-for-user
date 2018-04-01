package com.develop.windexit.finalproject.Remote;

import com.develop.windexit.finalproject.Model.MyResponse;
import com.develop.windexit.finalproject.Model.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;



public interface APIService {
    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAgSNR7Pc:APA91bFE86nAW6YEbDrPTPzgSAJd3j77UvW_fA9M_XJRXbxjIuvrz7CZCig1CH-7ldgyZLxKH2qZjMcdU2QK46eYYOi-0UspBPQN33mg2o78MST2fYOuCkIJ7ye651wi9DeBB4WJ7Toq"
    })
    @POST("fcm/send")
  Call<MyResponse>sendNotification(@Body Sender body);
}
