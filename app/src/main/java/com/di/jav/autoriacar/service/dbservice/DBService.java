package com.di.jav.autoriacar.service.dbservice;

import com.di.jav.autoriacar.model.DataFromCar;

import java.util.List;

public interface DBService {
    void save(DataFromCar car);
    void delete(Long id);
    List<DataFromCar> getAll();
    int update(DataFromCar car);
}
