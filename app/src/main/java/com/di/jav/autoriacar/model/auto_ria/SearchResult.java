package com.di.jav.autoriacar.model.auto_ria;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchResult {
    private ArrayList<Long> ids;
    private int count;
    private int last_id;
}
