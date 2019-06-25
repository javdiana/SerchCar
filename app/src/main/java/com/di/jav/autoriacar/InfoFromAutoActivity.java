package com.di.jav.autoriacar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.di.jav.autoriacar.model.DataFromCar;
import com.squareup.picasso.Picasso;

public class InfoFromAutoActivity extends AppCompatActivity {
    private ImageView ivCar;

    private TextView tvMarkAndModel;
    private TextView tvPrice;

    private EditText etRegion;
    private EditText etYearCar;
    private EditText etRace;
    private EditText etGearBox;
    private TextView etDescription;

    private TextView tvLinkToView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_from_auto);

        ivCar = findViewById(R.id.imageCar);
        tvMarkAndModel = findViewById(R.id.tvMarkAndModel);
        tvPrice = findViewById(R.id.tvPrice);

        etRegion = findViewById(R.id.etRegion);
        etYearCar = findViewById(R.id.etYearCar);
        etRace = findViewById(R.id.etRace);
        etGearBox = findViewById(R.id.etGearBox);
        etDescription = findViewById(R.id.etDescription);

        tvLinkToView = findViewById(R.id.tvLinkToView);
        setData(MainActivity.car);
    }

    public void setData(DataFromCar car) {
        if (car.getPhotoData().isEmpty()) {
            ivCar.setImageResource(R.drawable.ic_local_car_wash_black_24dp);
        }
        Picasso.with(this).load(car.getPhotoData()).into(ivCar);
        tvMarkAndModel.setText(car.getTitle());
        tvMarkAndModel.setTextColor(Color.BLACK);
        tvPrice.setText(String.format("%s$", car.getUSD()));
        tvPrice.setTextColor(Color.BLACK);
        etRegion.setText(car.getLocationCityName());
        etRegion.setTextColor(Color.BLACK);
        etYearCar.setText(car.getYear());
        etYearCar.setTextColor(Color.BLACK);
        etRace.setText(car.getRace());
        etRace.setTextColor(Color.BLACK);
        etGearBox.setText(car.getGearboxName());
        etDescription.setText(car.getAutoData());
        etGearBox.setTextColor(Color.BLACK);
        etDescription.setTextColor(Color.BLACK);
        tvLinkToView.setText(String.format("%s%s", car.getOriginSite(), car.getLinkToView()));

    }

}
