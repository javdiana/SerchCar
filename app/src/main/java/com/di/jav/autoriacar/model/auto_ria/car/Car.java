package com.di.jav.autoriacar.model.auto_ria.car;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {
    private String isLeasing;
    private String markId;
    private String withInfoBar;
    private String hasWebP;
    private String sendComments;
    private String exchangeTypeId;
    private String dontComment;
    private String partnerId;
    private String canSetSpecificPhoneToAdvert;
    private String[] optionStyles;
    private String markNameEng;
    private Dealer dealer;
    private String soldDate;
    private String title;
    private String chipsCount;
    private AutoData autoData;

    @SerializedName("photoData")
    @Expose
    private PhotoData photoData;

    @SerializedName("UAH")
    @Expose
    private String UAH;

    private String linkToView;
    private String userId;
    private String isAutoAddedByPartner;
    private String infoBarText;
    private String addDate;
    private LevelData levelData;

    @SerializedName("markName")
    @Expose
    private String markName;

    private String locationCityName;
    private CheckedVin checkedVin;
    private String realtyExchange;
    private String modelNameEng;
    private String userHideADSStatus;
    private String exchangePossible;
    private String exchangeType;
    private OldTop oldTop;
    private String updateDate;
    private String cityLocative;
    private String modelId;
    private String[] badges;
    private String EUR;

    @SerializedName("modelName")
    @Expose
    private String modelName;

    private UserPhoneData userPhoneData;
    private StateData stateData;
    private String expireDate;
    private String USD;
    private String auctionPossible;

    @SerializedName("site")
    @Expose
    private String site;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("desc")
    @Expose
    private String desc;

    @SerializedName("link")
    @Expose
    private String link;

    @SerializedName("elementPureHtml")
    @Expose
    private String elementPureHtml;
}
