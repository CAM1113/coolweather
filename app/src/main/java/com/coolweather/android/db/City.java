package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

/**
 * Created by dell on 2017/8/9.
 */

public class City extends DataSupport {

    private int id;
    private String cityName;
    private int cityCode;
    private int provinceId;

    public void setId(int i){id=i;}
    public int getId(){return id;}

    public void setCityName(String name){cityName=name;}
    public String getCityName(){return cityName;}

    public void setCityCode(int code){cityCode=code;}
    public int getCityCode(){return cityCode;}

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
