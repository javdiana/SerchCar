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
public class Additional {
    private ArrayList<Object> user_auto_positions;
    private SearchParams search_params;
    private Object query_string;
}
