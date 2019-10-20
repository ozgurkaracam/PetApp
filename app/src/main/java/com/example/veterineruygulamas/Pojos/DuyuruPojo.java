package com.example.veterineruygulamas.Pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DuyuruPojo {

    @SerializedName("duyururesim")
    @Expose
    private String duyururesim;
    @SerializedName("duyurutarih")
    @Expose
    private String duyurutarih;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("duyurutext")
    @Expose
    private String duyurutext;
    @SerializedName("__V")
    @Expose
    private Integer v;

    public String getDuyururesim() {
        return duyururesim;
    }

    public void setDuyururesim(String duyururesim) {
        this.duyururesim = duyururesim;
    }

    public String getDuyurutarih() {
        return duyurutarih;
    }

    public void setDuyurutarih(String duyurutarih) {
        this.duyurutarih = duyurutarih;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDuyurutext() {
        return duyurutext;
    }

    public void setDuyurutext(String duyurutext) {
        this.duyurutext = duyurutext;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}