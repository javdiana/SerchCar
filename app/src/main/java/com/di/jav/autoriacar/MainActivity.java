package com.di.jav.autoriacar;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.di.jav.autoriacar.model.DataFromCar;
import com.di.jav.autoriacar.service.AutoRiaAdapter;
import com.di.jav.autoriacar.service.RecyclerItemClickListener;
import com.di.jav.autoriacar.service.api.HttpService;
import com.di.jav.autoriacar.service.dbservice.DBHelperCar;
import com.di.jav.autoriacar.service.dbservice.DefaultDBService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    private EditText etMarkCar;
    private Button btnSearch;
    private TextView tvFilter;

    private RecyclerView recyclerView;
    private List<DataFromCar> cars;

    private SQLiteDatabase database;
    private DBHelperCar dbHelperCar;
    private DefaultDBService dbService;

    public static Map<String, String> filter = new HashMap<>();

    public static DataFromCar car;

    public SwipeRefreshLayout stf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            initDataInRecyclerView();
            recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Intent intent = new Intent(MainActivity.this, InfoFromAutoActivity.class);
                    car = cars.get(position);
                    startActivity(intent);
                }

                @Override
                public void onLongItemClick(View view, int position) {
                }

            }));
        });


        etMarkCar = findViewById(R.id.etMarkCar);
        btnSearch = findViewById(R.id.btnSearch);
        tvFilter = findViewById(R.id.tvFilter);

        btnSearch.setOnClickListener(this);

        dbHelperCar = new DBHelperCar(this);
        database = dbHelperCar.getReadableDatabase();
        getCars(filter);



        tvFilter.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FiltersActivity.class);
            startActivity(intent);
        });
        fab.performClick();

        stf = findViewById(R.id.swipeToRefresh);

        stf.setOnRefreshListener(() -> {
            refreshData();
            stf.setRefreshing(true);
            dropGet();
        });

        stf.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);
    }

    private void dropGet() {
        dbHelperCar.onUpgrade(database, DBHelperCar.DATABASE_VERSION, DBHelperCar.DATABASE_VERSION++);
        refreshData();
        filter.clear();
        getCars(filter);
        initDataInRecyclerView();
        stf.setRefreshing(false);
    }

    public void getCars(Map<String, String> filter) {
        dbService = new DefaultDBService(database, dbHelperCar);
        cars = dbService.getByFilters(filter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSearch:
                search();
                break;
        }
    }

    private void refreshData() {
        HttpService httpService = new HttpService(dbService, this);
        for (int i = 0; i < 15; i++) {
            httpService.getDataFromAutoRia(i);
        }
        httpService.getDataFromAB();
    }

    private void search() {
        if (Objects.nonNull(etMarkCar.getText()) && !etMarkCar.getText().toString().equals("")) {
            filter.clear();
            filter.put(DBHelperCar.KEY_MARK_NAME, etMarkCar.getText().toString());
        }
        getCars(filter);
        if (cars.size() == 0) {
            Toast.makeText(this, "За заданими фільтрами немає машин", Toast.LENGTH_SHORT).show();
        }
        initDataInRecyclerView();
    }

    public void initDataInRecyclerView() {
        recyclerView = findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        AutoRiaAdapter adapter = new AutoRiaAdapter(cars, this, database, dbHelperCar);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        refreshData();
    }
}