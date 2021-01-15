package com.h5190039.yigitcan_alasoy_final.activitys;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.h5190039.yigitcan_alasoy_final.utils.ConstantsClass;
import com.h5190039.yigitcan_alasoy_final.R;
import com.h5190039.yigitcan_alasoy_final.utils.AlertDialogUtil;
import com.h5190039.yigitcan_alasoy_final.utils.PrefUtil;

public class SplashActivity extends AppCompatActivity {
    CountDownTimer timer;
    ConstraintLayout clArkaPlan;
    ImageView logoImageView;
    Intent listeEkraniActivity;
    String alertDialogNegativeButtonText,alertDialogTitle,alertDialogMessage,alertDialogPositiveButtonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initialize();
    }

    private void initialize() {

        logoImageView = findViewById(R.id.imgLogo);
        clArkaPlan=findViewById(R.id.clArkaplan);

        logoResminiYukle();
        arkaplanResminiYukle();
        timerbaslat();
    }

    private void logoResminiYukle(){
        logoImageView.setImageResource(R.drawable.logo);
    }

    private void arkaplanResminiYukle(){
        clArkaPlan.setBackgroundResource(R.drawable.arkaplan);
    }

    private void timerbaslat() {

        timer= new CountDownTimer(ConstantsClass.SPLASH_BEKLEME_SURESI,ConstantsClass.SPLASH_BEKLEME_SURESI_ARTMASI) {
            @Override
            public void onTick(long millisUntilFinished) {}
            @Override
            public void onFinish() {
                internetKontrolu();
            }
        }.start();
    }

    private void internetKontrolu(){
        internetKontrolAlertDialogDegerleriniAta();


        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getActiveNetworkInfo()!=null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected()){
            listeEkraniActivityAc();
        }
        else{
            PrefUtil.setStringPref(getApplicationContext(), ConstantsClass.PREF_SECILEN_ALERT_DIALOG, ConstantsClass.PREF_INTERNET_KONTROL_ALERT_DIALOG);
            AlertDialogUtil.ortakAlertDialog(SplashActivity.this,alertDialogTitle,alertDialogMessage,alertDialogPositiveButtonText,alertDialogNegativeButtonText);
        }
    }

    private void listeEkraniActivityAc(){
        listeEkraniActivity =new Intent(SplashActivity.this,ListeActivity.class);
        startActivity(listeEkraniActivity);
        SplashActivity.this.finish();
    }
    private void internetKontrolAlertDialogDegerleriniAta(){
        alertDialogTitle = String.valueOf(R.string.internetKontrolAlertTitle);
        alertDialogMessage = String.valueOf(R.string.internetKontrolAlertMessage);
        alertDialogPositiveButtonText = String.valueOf(R.string.internetKontrolAlertPositiveButtonText);
        alertDialogNegativeButtonText = String.valueOf(R.string.internetKontrolAlertNegativeButtonText);
    }


}