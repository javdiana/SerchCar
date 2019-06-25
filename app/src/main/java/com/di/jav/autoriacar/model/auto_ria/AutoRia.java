package com.di.jav.autoriacar.model.auto_ria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AutoRia {
    private AdditionalParams additionalParams;
    private Result result;
    private String site;
    private String name;
    private String desc;
    private String link;
    private String elementPureHtml;
}
