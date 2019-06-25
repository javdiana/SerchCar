package com.di.jav.autoriacar.service.dbservice;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.di.jav.autoriacar.model.DataFromCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Setter;

import static com.di.jav.autoriacar.service.dbservice.DBHelperCar.KEY_ID;
import static com.di.jav.autoriacar.service.dbservice.DBHelperCar.TABLE_CARS;

@Setter
public class DefaultDBService implements DBService {
    private DBHelperCar dbHelperCar;
    private SQLiteDatabase database;
    String seletcQuery = "SELECT * FROM " + TABLE_CARS;

    public DefaultDBService(SQLiteDatabase database, DBHelperCar dbHelperCar) {
        setDatabase(database);
        setDbHelperCar(dbHelperCar);
    }

    @Override
    public void save(DataFromCar car) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelperCar.KEY_ORIGIN_SITE, car.getOriginSite());
        contentValues.put(DBHelperCar.KEY_LOCATION_CITY_NAME, car.getLocationCityName());
        contentValues.put(DBHelperCar.KEY_AUCTION_POSSIBLE, car.getAuctionPossible());
        contentValues.put(DBHelperCar.KEY_EXCHANGE_POSSIBLE, car.getExchangePossible());
        contentValues.put(DBHelperCar.KEY_REALTY_EXCHANGE, car.getRealtyExchange());
        contentValues.put(DBHelperCar.KEY_USD, car.getUSD());
        contentValues.put(DBHelperCar.KEY_UAH, car.getUAH());
        contentValues.put(DBHelperCar.KEY_EUR, car.getEUR());
        contentValues.put(DBHelperCar.KEY_AUTODATA, car.getAutoData());
        contentValues.put(DBHelperCar.KEY_YEAR, car.getYear());
        contentValues.put(DBHelperCar.KEY_RACE, car.getRace());
        contentValues.put(DBHelperCar.KEY_RACE_INT, car.getRaceInt());
        contentValues.put(DBHelperCar.KEY_FUEL_NAME, car.getFuelName());
        contentValues.put(DBHelperCar.KEY_GEARBOX_NAME, car.getGearboxName());
        contentValues.put(DBHelperCar.KEY_IS_SOLID, car.getIsSold());
        contentValues.put(DBHelperCar.KEY_MAIN_CURRENCY, car.getMainCurrency());
        contentValues.put(DBHelperCar.KEY_MARK_NAME, car.getMarkName());
        contentValues.put(DBHelperCar.KEY_MODEL_NAME, car.getModelName());
        contentValues.put(DBHelperCar.KEY_PHOTODATA, car.getPhotoData());
        contentValues.put(DBHelperCar.KEY_LINK_TO_VIEW, car.getLinkToView());
        contentValues.put(DBHelperCar.KEY_TITLE, car.getTitle());
        contentValues.put(DBHelperCar.KEY_IS_ACTIVE, car.getIsActive());

        database.insert(TABLE_CARS, null, contentValues);
    }

    @Override
    public void delete(Long id) {

    }

    private String buildQuery(Map<String, String> map) {
        StringBuilder builder = new StringBuilder();
        if (!map.isEmpty()) {
            map.forEach((k, v) -> {
                if (builder.length() == 0) {
                    builder.append(" WHERE ");
                } else {
                    builder.append(" AND ");
                }
                switch (k) {
                    case "priceFrom":
                        builder.append(DBHelperCar.KEY_USD).append(" > '").append(v).append("'");
                        break;
                    case "priceTo":
                        builder.append(DBHelperCar.KEY_USD).append(" < '").append(v).append("'");
                        break;
                    case "yearFrom":
                        builder.append(DBHelperCar.KEY_YEAR).append(" > '").append(v).append("'");
                        break;
                    case "yearTo":
                        builder.append(DBHelperCar.KEY_YEAR).append(" < '").append(v).append("'");
                        break;
                    default:
                        builder.append(k).append(" LIKE '").append(v).append("'");
                        break;
                }
            });
        }
        return seletcQuery + builder.toString();
    }

    public List<DataFromCar> getByFilters(Map<String, String> model) {
        List<DataFromCar> cars = new ArrayList<>();
        String query = buildQuery(model);
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                DataFromCar car = new DataFromCar();
                car.setId(Long.parseLong(cursor.getString(0)));
                car.setOriginSite(cursor.getString(1));
                car.setLocationCityName(cursor.getString(2));
                car.setAuctionPossible(cursor.getString(3));
                car.setExchangePossible(cursor.getString(4));
                car.setRealtyExchange(cursor.getString(5));
                car.setUSD(cursor.getString(6));
                car.setUAH(cursor.getString(7));
                car.setEUR(cursor.getString(8));
                car.setAutoData(cursor.getString(9));
                car.setYear(cursor.getString(10));
                car.setRace(cursor.getString(11));
                car.setRaceInt(cursor.getString(12));
                car.setFuelName(cursor.getString(13));
                car.setGearboxName(cursor.getString(14));
                car.setIsSold(cursor.getString(15));
                car.setMainCurrency(cursor.getString(16));
                car.setMarkName(cursor.getString(17));
                car.setModelName(cursor.getString(18));
                car.setPhotoData(cursor.getString(19));
                car.setLinkToView(cursor.getString(20));
                car.setTitle(cursor.getString(21));
                car.setIsActive(cursor.getString(22));

                cars.add(car);

            } while (cursor.moveToNext());
        }

        return cars;
    }

    @Override
    public List<DataFromCar> getAll() {
        List<DataFromCar> cars = new ArrayList<>();

        Cursor cursor = database.rawQuery(seletcQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DataFromCar car = new DataFromCar();
                car.setId(Long.parseLong(cursor.getString(0)));
                car.setOriginSite(cursor.getString(1));
                car.setLocationCityName(cursor.getString(2));
                car.setAuctionPossible(cursor.getString(3));
                car.setExchangePossible(cursor.getString(4));
                car.setRealtyExchange(cursor.getString(5));
                car.setUSD(cursor.getString(6));
                car.setUAH(cursor.getString(7));
                car.setEUR(cursor.getString(8));
                car.setAutoData(cursor.getString(9));
                car.setYear(cursor.getString(10));
                car.setRace(cursor.getString(11));
                car.setRaceInt(cursor.getString(12));
                car.setFuelName(cursor.getString(13));
                car.setGearboxName(cursor.getString(14));
                car.setIsSold(cursor.getString(15));
                car.setMainCurrency(cursor.getString(16));
                car.setMarkName(cursor.getString(17));
                car.setModelName(cursor.getString(18));
                car.setPhotoData(cursor.getString(19));
                car.setLinkToView(cursor.getString(20));
                car.setTitle(cursor.getString(21));
                car.setIsActive(cursor.getString(22));

                cars.add(car);

            } while (cursor.moveToNext());
        }
        return cars;
    }

    @Override
    public int update(DataFromCar car) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelperCar.KEY_ID, car.getId());
        contentValues.put(DBHelperCar.KEY_ORIGIN_SITE, car.getOriginSite());
        contentValues.put(DBHelperCar.KEY_LOCATION_CITY_NAME, car.getLocationCityName());
        contentValues.put(DBHelperCar.KEY_AUCTION_POSSIBLE, car.getAuctionPossible());
        contentValues.put(DBHelperCar.KEY_EXCHANGE_POSSIBLE, car.getExchangePossible());
        contentValues.put(DBHelperCar.KEY_REALTY_EXCHANGE, car.getRealtyExchange());
        contentValues.put(DBHelperCar.KEY_USD, car.getUSD());
        contentValues.put(DBHelperCar.KEY_UAH, car.getUAH());
        contentValues.put(DBHelperCar.KEY_EUR, car.getEUR());
        contentValues.put(DBHelperCar.KEY_AUTODATA, car.getAutoData());
        contentValues.put(DBHelperCar.KEY_YEAR, car.getYear());
        contentValues.put(DBHelperCar.KEY_RACE, car.getRace());
        contentValues.put(DBHelperCar.KEY_RACE_INT, car.getRaceInt());
        contentValues.put(DBHelperCar.KEY_FUEL_NAME, car.getFuelName());
        contentValues.put(DBHelperCar.KEY_GEARBOX_NAME, car.getGearboxName());
        contentValues.put(DBHelperCar.KEY_IS_SOLID, car.getIsSold());
        contentValues.put(DBHelperCar.KEY_MAIN_CURRENCY, car.getMainCurrency());
        contentValues.put(DBHelperCar.KEY_MARK_NAME, car.getMarkName());
        contentValues.put(DBHelperCar.KEY_MODEL_NAME, car.getModelName());
        contentValues.put(DBHelperCar.KEY_PHOTODATA, car.getPhotoData());
        contentValues.put(DBHelperCar.KEY_LINK_TO_VIEW, car.getLinkToView());
        contentValues.put(DBHelperCar.KEY_TITLE, car.getTitle());
        contentValues.put(DBHelperCar.KEY_IS_ACTIVE, car.getIsActive());

        return database.update(TABLE_CARS, contentValues, KEY_ID + " = ?", new String[]{String.valueOf(car.getId())});
    }
}
