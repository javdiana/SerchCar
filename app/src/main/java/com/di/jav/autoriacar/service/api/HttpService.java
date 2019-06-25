package com.di.jav.autoriacar.service.api;

import android.content.Context;
import android.widget.Toast;

import com.di.jav.autoriacar.model.DataFromCar;
import com.di.jav.autoriacar.model.ab.Autobazar;
import com.di.jav.autoriacar.model.auto_ria.AutoRia;
import com.di.jav.autoriacar.model.auto_ria.car.Car;
import com.di.jav.autoriacar.service.dbservice.DBService;
import com.di.jav.autoriacar.service.dbservice.DefaultDBService;
import com.di.jav.autoriacar.util.AutoUtil;

import lombok.NoArgsConstructor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@NoArgsConstructor
public class HttpService {
    private static AutoRiaApi autoRiaApi;
    private static AbApi abApi;

    private DBService dbService;
    public Context context;

    public HttpService(DefaultDBService dbService, Context context) {
        this.dbService = dbService;
        this.context = context;
    }

    public void getDataFromAutoRia(int page) {
        Retrofit retrofit;
        retrofit = new Retrofit.Builder()
                .baseUrl(AutoUtil.RIA_URL_DEVELOPERS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        autoRiaApi = retrofit.create(AutoRiaApi.class);
        autoRiaApi.getData(AutoUtil.RIA_API_KEY, page).enqueue(new Callback<AutoRia>() {
            @Override
            public void onResponse(Call<AutoRia> call, Response<AutoRia> response) {
                if (response.body() != null) {
                    response.body().getResult().getSearch_result().getIds().forEach((Long id) -> {
                        autoRiaApi.getCar(AutoUtil.RIA_API_KEY, id).enqueue(new Callback<Car>() {
                            @Override
                            public void onResponse(Call<Car> call, Response<Car> response) {
                                Car car = response.body();
                                DataFromCar data = new DataFromCar(car);
                                dbService.save(data);
                            }

                            @Override
                            public void onFailure(Call<Car> call, Throwable t) {

                            }
                        });
                    });
                }
            }

            @Override
            public void onFailure(Call<AutoRia> call, Throwable t) {
                Toast.makeText(context, "Дані не отримано з сайту AutoRIA!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getDataFromAB() {
        Retrofit retrofit;
        retrofit = new Retrofit.Builder()
                .baseUrl(AutoUtil.AB_URL_DEVELOPERS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        abApi = retrofit.create(AbApi.class);
        abApi.getData(
                "1",
                "uah",
                "0",
                "200",
                "1",
                "1",
                "1900",
                "2018"
        ).enqueue(new Callback<Autobazar>() {
            @Override
            public void onResponse(Call<Autobazar> call, Response<Autobazar> response) {
                Autobazar autobazar = response.body();
                autobazar.results.forEach(car -> {
                    DataFromCar data = new DataFromCar(car);
                    dbService.save(data);
                });
            }

            @Override
            public void onFailure(Call<Autobazar> call, Throwable t) {
                Toast.makeText(context, "Дані не отримано з сайту Автобазар!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
