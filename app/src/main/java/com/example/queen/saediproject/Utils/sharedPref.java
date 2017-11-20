package com.example.queen.saediproject.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by queen on 7/17/17.
 */

public class sharedPref {

    private static final String SHARED_PREF_NAME = "PrefToken";
    private static final String KEY_ACCESS_TOKEN = "token";

    private static Context mContext;
    private static sharedPref mInstance;

    private sharedPref(Context context) {
        mContext = context;
    }

    public static synchronized sharedPref getInstance(Context context) {
        if (mInstance == null)
            mInstance = new sharedPref(context);
        return mInstance;
    }

    public boolean storeToken(String token){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, mContext.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ACCESS_TOKEN, token);
        editor.apply();
        return true;
    }

    public String getToken(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, mContext.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_ACCESS_TOKEN, null);
    }
}
