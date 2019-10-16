package com.example.veterineruygulamas.Pojos;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AsiPojo {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("tarih")
    @Expose
    private String tarih;
    @SerializedName("asiad")
    @Expose
    private String asiad;
    @SerializedName("asiaciklama")
    @Expose
    private String asiaciklama;
    @SerializedName("pet")
    @Expose
    private PetPojos pet;
    @SerializedName("asidurum")
    @Expose
    private Boolean asidurum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getAsiad() {
        return asiad;
    }

    public void setAsiad(String asiad) {
        this.asiad = asiad;
    }

    public String getAsiaciklama() {
        return asiaciklama;
    }

    public void setAsiaciklama(String asiaciklama) {
        this.asiaciklama = asiaciklama;
    }

    public PetPojos getPet() {
        return pet;
    }

    public void setPet(PetPojos pet) {
        this.pet = pet;
    }

    public Boolean getAsidurum() {
        return asidurum;
    }

    public void setAsidurum(Boolean asidurum) {
        this.asidurum = asidurum;
    }

}