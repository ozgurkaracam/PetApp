package com.example.veterineruygulamas.Pojos;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignInPojos {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("role")
    @Expose
    private Integer role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(int role){this.role=role;}

    public Integer getRole(){return this.role;}

}