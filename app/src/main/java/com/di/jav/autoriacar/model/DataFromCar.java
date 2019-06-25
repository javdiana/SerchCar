package com.di.jav.autoriacar.model;

import com.di.jav.autoriacar.model.ab.Result;
import com.di.jav.autoriacar.model.auto_ria.car.Car;
import com.di.jav.autoriacar.util.AutoUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DataFromCar {
    private Long id;
    private String originSite;//название сайта
    private String locationCityName; // Город
    private String auctionPossible;// Торг
    private String exchangePossible;// Обмен
    private String realtyExchange; // Обмен на надвижимость
    private String USD;// Стоимость в доларах США
    private String UAH;// Стоимость в гривнах
    private String EUR;// Стоимость в евро
    private String autoData;// Характеристики машины
    //        "description": "Итак. Пришло время в срочном порядке продать свой любимый автомобиль.
    // " +"\r\nПокупал его в августе 2013 года. \r\nПолностью обслужен на о", // Описание
    private String year;// id объявления
    private String race;// Пробег
    private String raceInt;// -
    private String fuelName;// Тип топлива
    private String gearboxName;// Тип привода
    private String isSold;// Этот параметр показывает или машына продана или нет
    private String mainCurrency;// Основная валюта
    private String markName;// Марка автомобиля
    private String modelName;// Модель автомобиля
    private String photoData;//3// Фотографии!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private String linkToView;// Линк на объявление, перехід на сторінку з машиною!!!!!!!!!!!!!!!!!!
    private String title; // Название, повна назва машини!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private String isActive;

    public DataFromCar(Car car) {
        setOriginSite(AutoUtil.RIA_URL);
        setLocationCityName(car.getLocationCityName());
        setAuctionPossible(car.getAuctionPossible());
        setExchangePossible(car.getExchangePossible());
        setRealtyExchange(car.getRealtyExchange());
        setUSD(car.getUSD());
        setUAH(car.getUAH());
        setEUR(car.getEUR());

        setAutoData(car.getAutoData().getDescription());
        setYear(car.getAutoData().getYear());
        setRace(car.getAutoData().getRace());
        setRaceInt(car.getAutoData().getRaceInt());
        setFuelName(car.getAutoData().getFuelName());
        setGearboxName(car.getAutoData().getGearboxName());
        setIsSold(car.getAutoData().getIsSold());
        setMainCurrency(getMainCurrency());

        setMarkName(car.getMarkName());
        setModelName(car.getModelName());

        setPhotoData(car.getPhotoData().getSeoLinkB());

        setLinkToView(car.getLinkToView());
        setTitle(car.getTitle());
        setIsActive(car.getOldTop().getIsActive());
    }

    public DataFromCar(Result car) {
        setOriginSite(AutoUtil.AB_URL_DEVELOPERS);
        setLocationCityName(car.getLocation().getTitle());
        setUSD(car.getPrice().get(0).getValue().toString());

        setAuctionPossible("");
        setExchangePossible("");
        setRealtyExchange("");
        setUAH("");
        setEUR("");

        setAutoData(car.getDescription());
        setYear(car.getYear().toString());
        setRace("");
        setRaceInt("");
        setFuelName("");
        if (car.getCharacteristics().getGearbox() != null) {
            String gearboxName = car.getCharacteristics().getGearbox().getTitle();
            setGearboxName(gearboxName);
        } else {
            setGearboxName("");
        }
        setMainCurrency(getMainCurrency());

        setMarkName(car.getMake().getTitle());
        setModelName(car.getModel().getTitle());

        if (car.getPhotos() != null && car.getPhotos().size() > 0) {
            setPhotoData(car.getPhotos().get(0).getImage());
        } else {
            setPhotoData("");
        }

        setLinkToView(car.getPermalink());
        setTitle(car.getTitle());
        setIsActive("");
    }
}
