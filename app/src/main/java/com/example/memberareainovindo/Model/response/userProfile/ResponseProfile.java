package com.example.memberareainovindo.Model.response.userProfile;

import com.example.memberareainovindo.Model.response.login.Data;
import com.google.gson.annotations.SerializedName;

public class ResponseProfile {

    private String message;
    private Boolean error;

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private Data data;

    @SerializedName("gambar_url")
    private String gambar_url;

    public String getGambar_url() {
        return gambar_url;
    }

    public void setGambar_url(String gambar_url) {
        this.gambar_url = gambar_url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public Data getData() {
        return data;
    }
}
