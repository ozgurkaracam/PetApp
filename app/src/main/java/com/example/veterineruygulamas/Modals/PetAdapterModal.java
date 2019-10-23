package com.example.veterineruygulamas.Modals;

public class PetAdapterModal {
    private String image;
    private String ad;
    private String cins;
    private String id;
    private int kilo;

    public PetAdapterModal() {
    }

    public PetAdapterModal(String image, String ad, String cins,String id,int kilo) {
        this.image = image;
        this.ad = ad;
        this.cins = cins;
        this.id= id;
        this.kilo=kilo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getId() {
        return id;
    }

    public int getKilo(){return kilo;}

    public void setCins(String cins) {
        this.cins = cins;
    }
}
