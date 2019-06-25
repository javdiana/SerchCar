package com.di.jav.autoriacar.model.auto_ria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdditionalParams {
    private int lang_id;
    private int page;
    private int view_type_id;
    private String target;
    private String section;
    private String catalog_name;
    private boolean elastica;
    private boolean nodejs;
}
