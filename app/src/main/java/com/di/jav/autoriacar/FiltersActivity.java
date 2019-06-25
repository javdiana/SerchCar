package com.di.jav.autoriacar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.di.jav.autoriacar.service.dbservice.DBHelperCar;

import java.util.Objects;

public class FiltersActivity extends AppCompatActivity {

    private EditText etMarkCar_;
    private EditText etModelCar;
    private EditText etRegionCar;
    private EditText etCostLow;
    private EditText etCostUp;
    private EditText etYearLow;
    private EditText etYearUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            addDataToMap();
            super.onBackPressed();

        });

        etMarkCar_ = findViewById(R.id.etMarkCar_);
        etModelCar = findViewById(R.id.etModelCar);
        etRegionCar = findViewById(R.id.etRegionCar);
        etCostLow = findViewById(R.id.etCostLow);
        etCostUp = findViewById(R.id.etCostUp);
        etYearLow = findViewById(R.id.etYearLow);
        etYearUp = findViewById(R.id.etYearUp);
    }

    public void addDataToMap() {
        MainActivity.filter.clear();
        if (Objects.nonNull(etMarkCar_.getText()) && !etMarkCar_.getText().toString().equals("")) {
            MainActivity.filter.put(DBHelperCar.KEY_MARK_NAME, etMarkCar_.getText().toString());
        }
        if (Objects.nonNull(etModelCar.getText()) && !etModelCar.getText().toString().equals("")) {
            MainActivity.filter.put(DBHelperCar.KEY_MODEL_NAME, etModelCar.getText().toString());
        }
        if (Objects.nonNull(etRegionCar.getText()) && !etRegionCar.getText().toString().equals("")) {
            MainActivity.filter.put(DBHelperCar.KEY_LOCATION_CITY_NAME, etRegionCar.getText().toString());
        }
        if (Objects.nonNull(etCostLow.getText()) && !etCostLow.getText().toString().equals("")) {
            MainActivity.filter.put("priceFrom", etCostLow.getText().toString());
        }
        if (Objects.nonNull(etCostUp.getText()) && !etCostUp.getText().toString().equals("")) {
            MainActivity.filter.put("priceTo", etCostUp.getText().toString());
        }
        if (Objects.nonNull(etYearLow.getText()) && !etYearLow.getText().toString().equals("")) {
            MainActivity.filter.put("yearFrom", etYearLow.getText().toString());
        }
        if (Objects.nonNull(etYearUp.getText()) && !etYearUp.getText().toString().equals("")) {
            MainActivity.filter.put("yearTo", etYearUp.getText().toString());
        }
    }
}