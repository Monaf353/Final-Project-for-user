package com.develop.windexit.finalproject.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by WINDEX IT on 31-Mar-18.
 */

public class RetrofitGoogleMapClient {
    private static Retrofit retrofit  = null;

    public static Retrofit getReofitGoogleMapClient(String baseURL)
    {
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
