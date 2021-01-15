package com.h5190039.yigitcan_alasoy_final.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190039.yigitcan_alasoy_final.adaptor.UlkeAdapter;
import com.h5190039.yigitcan_alasoy_final.model.UlkeModel;
import com.h5190039.yigitcan_alasoy_final.network.Service;
import com.h5190039.yigitcan_alasoy_final.R;
import com.h5190039.yigitcan_alasoy_final.utils.AlertDialogUtil;
import com.h5190039.yigitcan_alasoy_final.utils.ConstantsClass;
import com.h5190039.yigitcan_alasoy_final.utils.GlideUtil;
import com.h5190039.yigitcan_alasoy_final.utils.ObjectUtil;
import com.h5190039.yigitcan_alasoy_final.utils.PrefUtil;
import com.h5190039.yigitcan_alasoy_final.utils.ProgressDialogUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imgUlkeBayraklari;
    String alertDialogNegativeButtonText,alertDialogTitle,alertDialogMessage,alertDialogPositiveButtonText,tiklananUlkeString;
    Intent detayEkraniActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        initialize();
    }

    private void initialize() {
        kapakResminiGetir();
        ulkeleriListele();
        cikisAlertDialogDegerleriniAta();
    }

    private void kapakResminiGetir(){
        imgUlkeBayraklari = findViewById(R.id.imgUlkeBayraklari);
        GlideUtil.resmiIndiripGoster(ListeActivity.this, getApplicationContext().getResources().getString(R.string.ulkelerImgUrl),imgUlkeBayraklari);
    }


    void  ulkeleriListele()
    {
        progressDialogGoster();
        new Service().getServiceApi().ulkeleriGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UlkeModel>>() {

                    List<UlkeModel> ulkeler=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onNext(List<UlkeModel> ulkeList) {
                        ulkeler=ulkeList;
                    }

                    @Override
                    public void onError(Throwable e) {}

                    @Override
                    public void onComplete()
                    {
                        if(ulkeler.size()>0) {
                            initRecycleView(ulkeler);
                            ProgressDialogUtil.progressDialogBitir();
                        }
                    }


                });
    }

    private void initRecycleView(List<UlkeModel>ulkeList){
        recyclerView = findViewById(R.id.rcvUlkeler);
        UlkeAdapter ulkeAdapter = new UlkeAdapter(ulkeList, getApplicationContext(), new UlkeAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {

                UlkeModel tiklananUlke = ulkeList.get(position);
                detayActivityAc(tiklananUlke);

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(ulkeAdapter);
    }

    private final void progressDialogGoster(){
        ProgressDialogUtil.progressDialogBaslat(ListeActivity.this,getApplicationContext().getResources().getString(R.string.progressDialogMessage));
    }

    @Override
    public void onBackPressed() {
        PrefUtil.setStringPref(getApplicationContext(), ConstantsClass.PREF_SECILEN_ALERT_DIALOG, ConstantsClass.PREF_CIKIS_ALERT_DIALOG);
        AlertDialogUtil.ortakAlertDialog(ListeActivity.this,alertDialogTitle,alertDialogMessage,alertDialogPositiveButtonText,alertDialogNegativeButtonText);
    }

    private void cikisAlertDialogDegerleriniAta(){
        alertDialogTitle = String.valueOf(R.string.cikisAlertTitle);
        alertDialogMessage = String.valueOf(R.string.cikisAlertMessage);
        alertDialogPositiveButtonText = String.valueOf(R.string.cikisAlertPositiveButtonText);
        alertDialogNegativeButtonText = String.valueOf(R.string.cikisAlertNegativeButtonText);
    }

    private void detayActivityAc(UlkeModel tiklananUlke){
        detayEkraniActivity =new Intent(ListeActivity.this,DetayActivity.class);
        tiklananUlkeString= ObjectUtil.ulkeToJsonString(tiklananUlke);
        detayEkraniActivity.putExtra(ConstantsClass.TIKLANAN_ULKE_KEY,tiklananUlkeString);
        startActivity(detayEkraniActivity);
    }
}