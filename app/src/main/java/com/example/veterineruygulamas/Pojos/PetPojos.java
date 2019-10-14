package com.example.veterineruygulamas.Pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PetPojos {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("ad")
    @Expose
    private String ad;
    @SerializedName("cins")
    @Expose
    private String cins;
    @SerializedName("sahipid")
    @Expose
    private String sahipid;
    @SerializedName("kilo")
    @Expose
    private Integer kilo;
    @SerializedName("image")
    @Expose
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getCins() {
        return cins;
    }

    public void setCins(String cins) {
        this.cins = cins;
    }

    public String getSahipid() {
        return sahipid;
    }

    public void setSahipid(String sahipid) {
        this.sahipid = sahipid;
    }

    public Integer getKilo() {
        return kilo;
    }

    public void setKilo(Integer kilo) {
        this.kilo = kilo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}