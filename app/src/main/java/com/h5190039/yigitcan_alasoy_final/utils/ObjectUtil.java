package com.h5190039.yigitcan_alasoy_final.utils;

import com.google.gson.Gson;
import com.h5190039.yigitcan_alasoy_final.model.UlkeModel;

public class ObjectUtil {

    public static String ulkeToJsonString (UlkeModel ulkeModel){
        Gson gson = new Gson();
        return gson.toJson(ulkeModel);
    }

    public static UlkeModel jsonStringToUlke (String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString,UlkeModel.class);
    }
}
