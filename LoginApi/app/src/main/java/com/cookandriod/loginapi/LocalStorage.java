package com.cookandriod.loginapi;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalStorage {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Context context;
    String token;

    public LocalStorage(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("Storage_login_api", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public String getToken(){
        token = sharedPreferences.getString("Token", "");
        return token;
    }

    public void setToken(String token){
        editor.putString("Token", token);
        editor.commit();
        this.token = token;
    }
}
