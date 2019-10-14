package com.example.veterineruygulamas.Modals;

public class PetAdapterModal {
    private String image;
    private String ad;
    private String cins;

    public PetAdapterModal() {
    }

    public PetAdapterModal(String image, String ad, String cins) {
        this.image = image;
        this.ad = ad;
        this.cins = cins;
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

    public void setCins(String cins) {
        this.cins = cins;
    }
}
