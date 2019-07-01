package com.joe.androidkeystore;

import android.content.Context;

public class UtilSp {
    private static KeyStoreHelper keyStoreHelper;
    private static SharedPreferencesHelper preferencesHelper;

    public static KeyStoreHelper getKeyStoreHelper(Context context){
        if (keyStoreHelper==null){
            keyStoreHelper = new KeyStoreHelper(context, preferencesHelper);
        }
        return keyStoreHelper;
    }

    public static SharedPreferencesHelper getSharedPreferencesHelper(Context context){
        if (preferencesHelper==null){
            preferencesHelper = new SharedPreferencesHelper(context);
        }
        return preferencesHelper;
    }
}
