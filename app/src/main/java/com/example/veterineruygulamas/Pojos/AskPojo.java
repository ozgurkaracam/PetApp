package com.example.veterineruygulamas.Pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AskPojo {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("cevaptext")
    @Expose
    private String cevaptext;
    @SerializedName("question")
    @Expose
    private String question;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCevaptext() {
        return cevaptext;
    }

    public void setCevaptext(String cevaptext) {
        this.cevaptext = cevaptext;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}

