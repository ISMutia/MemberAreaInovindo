package com.example.memberareainovindo.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private String PREF_NAME = "SIMPAN";
    private String KEY_FULLNAME = "fullname";


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

    public void logout() {
        mEditor = mSharedPreferences.edit();
        mEditor.clear().commit();
    }
}
