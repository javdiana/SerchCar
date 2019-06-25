package com.di.jav.autoriacar.service.dbservice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperCar extends SQLiteOpenHelper {
    public static  int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "autoriacardb";
    public static final String TABLE_CARS = "cars";

    public static final String KEY_ID = "_id";
    public static final String KEY_ORIGIN_SITE = "originSite";
    public static final String KEY_LOCATION_CITY_NAME = "locationCityName";
    public static final String KEY_AUCTION_POSSIBLE = "auctionPossible";
    public static final String KEY_EXCHANGE_POSSIBLE = "exchangePossible";
    public static final String KEY_REALTY_EXCHANGE = "realtyExchange";
    public static final String KEY_USD = "USD";
    public static final String KEY_UAH = "UAH";
    public static final String KEY_EUR = "EUR";
    public static final String KEY_AUTODATA = "autoData";
    public static final String KEY_YEAR = "year";
    public static final String KEY_RACE = "race";
    public static final String KEY_RACE_INT = "raceInt";
    public static final String KEY_FUEL_NAME = "fuelName";
    public static final String KEY_GEARBOX_NAME = "gearboxName";
    public static final String KEY_IS_SOLID = "isSolid";
    public static final String KEY_MAIN_CURRENCY = "mainCurrency";
    public static final String KEY_MARK_NAME = "markName";
    public static final String KEY_MODEL_NAME = "modelName";
    public static final String KEY_PHOTODATA = "photoData";
    public static final String KEY_LINK_TO_VIEW = "linkToView";
    public static final String KEY_TITLE = "title";
    public static final String KEY_IS_ACTIVE = "isActive";

    public DBHelperCar(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_CARS + "(" + KEY_ID
                + " integer primary key,"
                + KEY_ORIGIN_SITE + " text,"
                + KEY_LOCATION_CITY_NAME + " text,"
                + KEY_AUCTION_POSSIBLE + " text,"
                + KEY_EXCHANGE_POSSIBLE + " text,"
                + KEY_REALTY_EXCHANGE + " text,"
                + KEY_USD + " text,"
                + KEY_UAH + " text,"
                + KEY_EUR + " text,"
                + KEY_AUTODATA + " text,"
                + KEY_YEAR + " text,"
                + KEY_RACE + " text,"
                + KEY_RACE_INT + " text,"
                + KEY_FUEL_NAME + " text,"
                + KEY_GEARBOX_NAME + " text,"
                + KEY_IS_SOLID + " text,"
                + KEY_MAIN_CURRENCY + " text,"
                + KEY_MARK_NAME + " text,"
                + KEY_MODEL_NAME + " text,"
                + KEY_PHOTODATA + " text,"
                + KEY_LINK_TO_VIEW + " text,"
                + KEY_TITLE + " text,"
                + KEY_IS_ACTIVE + " text"
                + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CARS);
        onCreate(db);
    }
}
