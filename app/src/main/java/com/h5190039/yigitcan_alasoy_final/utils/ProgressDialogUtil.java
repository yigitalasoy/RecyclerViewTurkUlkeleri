package com.h5190039.yigitcan_alasoy_final.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressDialogUtil {
    static ProgressDialog progressDialog;

    public static void progressDialogBaslat(Context context,String progressDialogMessage){
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(progressDialogMessage);
        progressDialog.show();

    }
    public static void progressDialogBitir(){
        progressDialog.dismiss();
    }
}
