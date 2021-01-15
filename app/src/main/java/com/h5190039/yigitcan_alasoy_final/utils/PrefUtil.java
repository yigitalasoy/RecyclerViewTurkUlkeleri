package com.h5190039.yigitcan_alasoy_final.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefUtil {

    private  static SharedPreferences  getPrefs(Context context)
    {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setStringPref(Context context, String key, String deger)
    {
        getPrefs(context).edit().putString(key,deger).apply();
    }

    public static String getStringPref(Context context,String key)
    {
        return getPrefs(context).getString(key, ConstantsClass.PREF_VARSAYILAN_STRING);
    }


    public static void setIntPref(Context context,String key,int deger)
    {
        getPrefs(context).edit().putInt(key,deger).apply();
    }

    public static int getIntPref(Context context,String key)
    {
        return getPrefs(context).getInt(key,ConstantsClass.PREF_VARSAYILAN_INT);
    }
}
