package com.develop.windexit.finalproject.Remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by WINDEX IT on 01-Apr-18.
 */

public interface IGoogleService {
    @GET
    Call<String> getAdressName(@Url String url);
}
