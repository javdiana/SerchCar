package com.di.jav.autoriacar.service.api;

import com.di.jav.autoriacar.model.auto_ria.AutoRia;
import com.di.jav.autoriacar.model.auto_ria.car.Car;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AutoRiaApi {
    @GET("auto/search")
    Call<AutoRia> getData(@Query("api_key") String apiKey,
                          @Query("page") int page);

    @GET("auto/info")
    Call<Car> getCar(@Query("api_key") String apiKey, @Query("auto_id") Long id);
}
