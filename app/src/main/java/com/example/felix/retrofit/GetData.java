package com.example.felix.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Felix on 3/30/2018.
 */

public interface GetData {

    String BASE_URL = "http://54.245.132.145/Currency/";

    @GET("GetCurrency")
    Call<List<Currencies>> getCurrencies();
}
