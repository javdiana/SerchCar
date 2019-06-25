package com.di.jav.autoriacar.model.auto_ria.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CheckedVin {
    private String isChecked;
    private String vin;
    private String checkDate;
    private String linkToReport;
    private String hasRestrictions;
    private String isShow;


}
