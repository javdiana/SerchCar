package com.di.jav.autoriacar.model.auto_ria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private SearchResult search_result;
    private Object active_marka;
    private Object active_model;
    private Object active_state;
    private Object active_city;
    private Object revies;
    private Additional additional;
}
