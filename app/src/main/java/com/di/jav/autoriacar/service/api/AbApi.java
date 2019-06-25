package com.di.jav.autoriacar.service.api;

import com.di.jav.autoriacar.model.ab.Autobazar;
import com.di.jav.autoriacar.model.auto_ria.AutoRia;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AbApi {
    @GET("api/_posts/")
    Call<Autobazar> getData(@Query("capacity_unit") String capacityUnit,
                            @Query("currency") String currency,
                            @Query("is_new") String isNew,
                            @Query("per_page") String perPage,
                            @Query("power_unit") String powerUnit,
                            @Query("transport") String transport,
                            @Query("yearFrom") String yearFrom,
                            @Query("yearTo") String yearTo
                            );
}
