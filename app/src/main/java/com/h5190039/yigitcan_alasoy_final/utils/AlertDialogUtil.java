package com.h5190039.yigitcan_alasoy_final.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

public class AlertDialogUtil {

    public static void ortakAlertDialog(Activity activity, String alertTitle, String alertMessage, String alertPositiveButtonText, String alertNegativeButtonText){

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
        alertDialog.setMessage(Integer.parseInt(alertMessage));
        alertDialog.setTitle(Integer.parseInt(alertTitle));
        alertDialog.setPositiveButton(Integer.parseInt(alertPositiveButtonText), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if((PrefUtil.getStringPref(activity.getApplicationContext(), ConstantsClass.PREF_SECILEN_ALERT_DIALOG)).equals(ConstantsClass.PREF_INTERNET_KONTROL_ALERT_DIALOG)){
                    activity.startActivity(new Intent(Settings.ACTION_SETTINGS));
                }
                else if((PrefUtil.getStringPref(activity.getApplicationContext(), ConstantsClass.PREF_SECILEN_ALERT_DIALOG)).equals(ConstantsClass.PREF_CIKIS_ALERT_DIALOG)){

                }
            }
        });
        alertDialog.setNegativeButton(Integer.parseInt(alertNegativeButtonText), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(PrefUtil.getStringPref(activity.getApplicationContext(), ConstantsClass.PREF_SECILEN_ALERT_DIALOG).equals(ConstantsClass.PREF_INTERNET_KONTROL_ALERT_DIALOG)){
                    activity.finish();
                }
                else if((PrefUtil.getStringPref(activity.getApplicationContext(), ConstantsClass.PREF_SECILEN_ALERT_DIALOG)).equals(ConstantsClass.PREF_CIKIS_ALERT_DIALOG)){
                    System.exit(0);
                }
            }
        }).show();

    }


}