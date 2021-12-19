package com.example.memberareainovindo.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private String PREF_NAME = "SIMPAN";
    private String KEY_FULLNAME = "fullname";
    private String KEY_DATE_BIRTH = "date_birth";
    private String KEY_EMAIL = "email";
    private String KEY_GAMBAR = "gambar";
    private String KEY_GAMBAR_URL = "gambar_url";
    private String KEY_STATUS = "status";
    private String KEY_CONTACT_WA = "contact_wa";
    private String KEY_ADDRESS = "address";
    private String KEY_CREATED_AT = "created_at";
    private String KEY_UPDATED_AT = "updated_at";
    private String KEY_ID_USER = "id";

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public SessionManager(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void setFullname(String fullname) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(KEY_FULLNAME, fullname).apply();
    }

    public String getFullname() {
        return mSharedPreferences.getString(KEY_FULLNAME, null);
    }

    public void setDatebirth(String date_birth) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(KEY_DATE_BIRTH, date_birth).apply();
    }

    public String getDateBirth() {
        return mSharedPreferences.getString(KEY_DATE_BIRTH, null);
    }

    public void setEmail(String email) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(KEY_EMAIL, email).apply();
    }

    public String getEmail() {
        return mSharedPreferences.getString(KEY_EMAIL, null);
    }

    public void setGambar(String gambar) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(KEY_GAMBAR, gambar).apply();
    }

    public String getGambar() {
        return mSharedPreferences.getString(KEY_GAMBAR, null);
    }

    public void setStatus(String status) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(KEY_STATUS, status).apply();
    }

    public String getStatus() {
        return mSharedPreferences.getString(KEY_STATUS, null);
    }

    public void setContactWa(String contact_wa) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(KEY_CONTACT_WA, contact_wa).apply();
    }

    public String getContactWa() {
        return mSharedPreferences.getString(KEY_CONTACT_WA, null);
    }

    public void setAddress(String address) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(KEY_ADDRESS, address).apply();
    }

    public String getAddress() {
        return mSharedPreferences.getString(KEY_ADDRESS, null);
    }

    public void setCreatedAt(String created_at) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(KEY_CREATED_AT, created_at).apply();
    }

    public String getUpdateAt() {
        return mSharedPreferences.getString(KEY_UPDATED_AT, null);
    }

    public void logout() {
        mEditor = mSharedPreferences.edit();
        mEditor.clear().commit();
    }

    public void setId(String id) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(KEY_ID_USER, id).apply();
    }

    public String getId() {
        return mSharedPreferences.getString(KEY_ID_USER, null);
    }

    public void setGambarUrl(String gambar_url) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(KEY_GAMBAR_URL, gambar_url).apply();
    }

    public String getGambarUrl() {
        return mSharedPreferences.getString(KEY_GAMBAR_URL, null);
    }
}
