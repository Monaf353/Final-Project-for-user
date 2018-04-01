package com.develop.windexit.finalproject.Model;

/**
 * Created by WINDEX IT on 12-Mar-18.
 */

public class Token {
    private String token;
    private boolean isServerToken;


    public Token(String token, boolean isServerToken) {
        this.token = token;
        this.isServerToken = isServerToken;
    }
    public Token() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isServerToken() {
        return isServerToken;
    }

    public void setServerToken(boolean serverToken) {
        isServerToken = serverToken;
    }
}
