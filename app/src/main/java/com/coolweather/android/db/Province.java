package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

/**
 * Created by dell on 2017/8/9.
 */

public class Province extends DataSupport {

    private  int id;
    private int provinceCode;
    private String provinceName;

    public int getId(){ return id;}
    public  void setId(int id){this.id=id;}

    public int getProvinceCode(){return provinceCode;}
    public void setProvinceCode(int code){provinceCode=code;}

    public String getProvinceName(){return provinceName;}
    public void setProvinceName(String name){provinceName=name;}

}
