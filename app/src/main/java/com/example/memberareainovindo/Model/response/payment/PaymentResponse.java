package com.example.memberareainovindo.Model.response.payment;

import com.example.memberareainovindo.Model.response.login.Data;
import com.google.gson.annotations.SerializedName;

public class PaymentResponse {
    private String message;
    private Boolean error;

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private Data data;

    @SerializedName("bukti_url")
    private String bukti_url;

    public String getBukti_url() {
        return bukti_url;
    }

    public void setBukti_url(String bukti_url) {
        this.bukti_url = bukti_url;
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
