package com.example.felix.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Felix on 3/30/2018.
 */

public interface GetData {

    String BASE_URL = "http://52.26.101.89/Currency/";

    @GET("GetAll/")
    Call<CurrencyList> getMethodList();
}
