package com.h5190039.yigitcan_alasoy_final.activitys;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.h5190039.yigitcan_alasoy_final.model.UlkeModel;
import com.h5190039.yigitcan_alasoy_final.R;
import com.h5190039.yigitcan_alasoy_final.utils.ConstantsClass;
import com.h5190039.yigitcan_alasoy_final.utils.GlideUtil;
import com.h5190039.yigitcan_alasoy_final.utils.ObjectUtil;

public class DetayActivity extends AppCompatActivity {

    String tasinanUlkeString,ulkeDetayHtml;
    ImageView imgUlkeBayrak,imgUlkeBulunduguYer;
    TextView txtUlkeAdi,txtUlkeKurulus,txtUlkeKurucusu,txtUlkeNufus,txtUlkeDetay;
    UlkeModel tasinanUlkeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        initialize();

    }

    private void initialize() {
        degiskenleriTanimla();
        secilenUlkeDegerleriYazdir();
    }


    private void secilenUlkeDegerleriYazdir(){
        tasinanUlkeString=getIntent().getStringExtra(ConstantsClass.TIKLANAN_ULKE_KEY);
        tasinanUlkeModel = ObjectUtil.jsonStringToUlke(tasinanUlkeString);

        txtUlkeAdi.setText(tasinanUlkeModel.getUlkeAdi());
        txtUlkeKurulus.setText(tasinanUlkeModel.getKurulus());
        txtUlkeKurucusu.setText(tasinanUlkeModel.getKurucusu());
        txtUlkeNufus.setText(tasinanUlkeModel.getNufus());
        ulkeDetayHtml = tasinanUlkeModel.getAciklama();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
        {
            txtUlkeDetay.setText(Html.fromHtml(ulkeDetayHtml,Html.FROM_HTML_MODE_LEGACY));
        }
        else
        {
            txtUlkeDetay.setText(Html.fromHtml(ulkeDetayHtml));
        }

        ulkeBayrakImgGetir();
        ulkeBulunduguYerImgGetir();
    }

    private void degiskenleriTanimla(){
        imgUlkeBayrak=findViewById(R.id.imgUlkeBayrak);
        imgUlkeBulunduguYer=findViewById(R.id.imgUlkeLokasyon);
        txtUlkeAdi=findViewById(R.id.txtUlkeAdi);
        txtUlkeKurulus=findViewById(R.id.txtUlkeKurulus);
        txtUlkeKurucusu=findViewById(R.id.txtUlkeKurucusu);
        txtUlkeNufus=findViewById(R.id.txtUlkeNufus);
        txtUlkeDetay=findViewById(R.id.txtUlkeDetay);
    }


    private void ulkeBayrakImgGetir(){
        GlideUtil.resmiIndiripGoster(DetayActivity.this, tasinanUlkeModel.getBayrakUrl(),imgUlkeBayrak);
    }

    private void ulkeBulunduguYerImgGetir(){
        GlideUtil.resmiIndiripGoster(DetayActivity.this, tasinanUlkeModel.getBulunduguYerUrl(),imgUlkeBulunduguYer);
    }

}