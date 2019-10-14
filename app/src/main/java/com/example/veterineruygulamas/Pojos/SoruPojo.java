package com.example.veterineruygulamas.Pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SoruPojo {

    @SerializedName("askes")
    @Expose
    private List<AskPojo> askes = null;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("questiontext")
    @Expose
    private String questiontext;
    @SerializedName("creator")
    @Expose
    private String creator;

    public List<AskPojo> getAskes() {
        return askes;
    }

    public void setAskes(List<AskPojo> askes) {
        this.askes = askes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestiontext() {
        return questiontext;
    }

    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

}