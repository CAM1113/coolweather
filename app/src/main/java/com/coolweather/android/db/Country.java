package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

/**
 * Created by dell on 2017/8/9.
 */

public class Country extends DataSupport {

    private int id;
    private String countryName;
    private String weatherId;
    private int cityId;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getWeatherId() {
        return weatherId;
    }
    public void setWeatherId(String i){weatherId=i;}
}
