package com.example.handyconnect.session;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SessionNotNull {

    private static final String PREF_NAME = "affitousa_device_token";
    private static final String PREF_NAME_TWO = "affitousa_device_token_two";

    private SharedPreferences.Editor editor;
    private SharedPreferences pref;

     SharedPreferences.Editor editorTwo;
     SharedPreferences prefTwo;
     int PRIVATE_MODE;
     Context _context;
     int securityQuestionLength = 0;


    public SessionNotNull(Context context) {

        PRIVATE_MODE = 0;
        _context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();

        prefTwo = _context.getSharedPreferences(PREF_NAME_TWO, PRIVATE_MODE);
        editorTwo = prefTwo.edit();

    }


    public Boolean isRememberMe() {
        return prefTwo.getBoolean("is_remember_me", false);
    }

    public void setRememberMe(boolean mFlag) {
        editorTwo.putBoolean("is_remember_me", mFlag);
        editorTwo.commit();
    }

    public Boolean isLogin() {
        return pref.getBoolean("is_login", false);
    }

    public void setLogin(boolean mFlag) {
        editor.putBoolean("is_login", mFlag);
        editor.commit();
    }

    public String getEmailRememberMe() {
        return prefTwo.getString("EmailRememberMe", "");
    }

    public void setEmailRememberMe(String mEmail) {
        editorTwo.putString("EmailRememberMe", mEmail);
        editorTwo.commit();

    }


    public String getPwdRememberMe() {
        return prefTwo.getString("PwdRememberMe", "");
    }

    public void setPwdRememberMe(String mPwd) {
        editorTwo.putString("PwdRememberMe", mPwd);
        editorTwo.commit();
    }

//    public void setLoginData(Data data) {
//          Gson gson = new Gson();
//          String sData = gson.toJson(data,Data.class);
//          editor.putString("loginData",sData);
//          editor.commit();
//    }
//
//    public Data getLoginData(){
//        return new Gson().fromJson(pref.getString("loginData", ""), Data.class);
//    }


//    public String getAfterSignupToken() {
//        return pref.getString("after_signup_token", "");
//    }
//
//    public void setAfterSignupToken(String mToken) {
//        editor.putString("after_signup_token", mToken);
//        editor.commit();
//    }
//
//
//    public Boolean isAfterSignup() {
//        return pref.getBoolean("is_after_signup", false);
//    }
//
//    public void setAfterSignup(boolean mFlag) {
//        editor.putBoolean("is_after_signup", mFlag);
//        editor.commit();
//
//    }


    public void clearSession() {
        editor.clear();
        editor.commit();
    }

    public String getDeviceFCMToken() {
        return pref.getString("device_fcm_token", "");
    }


    public void setDeviceFCMToken(String token) {
        editor.putString("device_fcm_token", token);
        editor.commit();
    }
}
