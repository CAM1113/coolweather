package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.Country;
import com.coolweather.android.db.Province;
import com.coolweather.android.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dell on 2017/8/9.
 */

public class Utility {
    /**
     *解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvince=new JSONArray(response);
                for(int i=0;i<allProvince.length();i++){
                    JSONObject provinceObject=allProvince.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }

        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response,int provinceId){

        if(!TextUtils.isEmpty(response)){

            try{

                JSONArray allCitys=new JSONArray(response);
                for(int i=0;i<allCitys.length();i++){
                    JSONObject cityObject=allCitys.getJSONObject(i);

                    City city=new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch(JSONException e){e.printStackTrace();}
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountryResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try{
            JSONArray allcountries=new JSONArray(response);
            for(int i=0;i<allcountries.length();i++){
                JSONObject countryObject=allcountries.getJSONObject(i);
                Country country=new Country();
                country.setCountryName(countryObject.getString("name"));
                country.setWeatherId(countryObject.getString("weather_id"));
                country.setCityId(cityId);
                country.save();
            }
            return true;

        }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Weather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject=new JSONObject(response);
            JSONArray jsonArray=jsonObject.getJSONArray("HeWeather");
            String weatherContent=jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}