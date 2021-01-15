package com.h5190039.yigitcan_alasoy_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UlkeModel {

    @SerializedName("UlkeAdi")
    @Expose
    private String ulkeAdi;
    @SerializedName("Kurulus")
    @Expose
    private String kurulus;
    @SerializedName("BayrakUrl")
    @Expose
    private String bayrakUrl;
    @SerializedName("Kurucusu")
    @Expose
    private String kurucusu;
    @SerializedName("BulunduguYerUrl")
    @Expose
    private String bulunduguYerUrl;
    @SerializedName("ResmiDil")
    @Expose
    private String resmiDil;
    @SerializedName("ParaBirimi")
    @Expose
    private String paraBirimi;
    @SerializedName("Baskent")
    @Expose
    private String baskent;
    @SerializedName("Nufus")
    @Expose
    private String nufus;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;

    public String getUlkeAdi() {
        return ulkeAdi;
    }

    public void setUlkeAdi(String ulkeAdi) {
        this.ulkeAdi = ulkeAdi;
    }

    public String getKurulus() {
        return kurulus;
    }

    public void setKurulus(String kurulus) {
        this.kurulus = kurulus;
    }

    public String getBayrakUrl() {
        return bayrakUrl;
    }

    public void setBayrakUrl(String bayrakUrl) {
        this.bayrakUrl = bayrakUrl;
    }

    public String getKurucusu() {
        return kurucusu;
    }

    public void setKurucusu(String kurucusu) {
        this.kurucusu = kurucusu;
    }

    public String getBulunduguYerUrl() {
        return bulunduguYerUrl;
    }

    public void setBulunduguYerUrl(String bulunduguYerUrl) {
        this.bulunduguYerUrl = bulunduguYerUrl;
    }

    public String getResmiDil() {
        return resmiDil;
    }

    public void setResmiDil(String resmiDil) {
        this.resmiDil = resmiDil;
    }

    public String getParaBirimi() {
        return paraBirimi;
    }

    public void setParaBirimi(String paraBirimi) {
        this.paraBirimi = paraBirimi;
    }

    public String getBaskent() {
        return baskent;
    }

    public void setBaskent(String baskent) {
        this.baskent = baskent;
    }

    public String getNufus() {
        return nufus;
    }

    public void setNufus(String nufus) {
        this.nufus = nufus;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

}