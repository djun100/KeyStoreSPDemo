package com.joe.androidkeystore;

import com.cy.app.UtilContext;

/**
 * Created by Cy on 2019/7/1.
 */
public class UtilSafeSP {
    private static KeyStoreHelper keyStoreHelper;
    private static SharedPreferencesHelper preferencesHelper;

    private static KeyStoreHelper getKeyStoreHelper() {
        if (keyStoreHelper == null) {
            keyStoreHelper = new KeyStoreHelper(UtilContext.getContext(), getPreferencesHelper());
        }
        return keyStoreHelper;
    }

    private static SharedPreferencesHelper getPreferencesHelper() {
        if (preferencesHelper == null) {
            preferencesHelper = new SharedPreferencesHelper(UtilContext.getContext());
        }
        return preferencesHelper;
    }

    public static void save(String key, String value) {
        String encryptedText = getKeyStoreHelper().encrypt(value);
        getPreferencesHelper().setInput(getKeyStoreHelper().encrypt(key), encryptedText);
    }

    public static String fetch(String key) {
        String encryptedText = getPreferencesHelper().getInput(getKeyStoreHelper().encrypt(key));
        String plainInput = getKeyStoreHelper().decrypt(encryptedText);
        return plainInput;
    }
}
