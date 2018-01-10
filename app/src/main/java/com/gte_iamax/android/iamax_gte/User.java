package com.gte_iamax.android.iamax_gte;

/**
 * Created by nikki on 11/22/2017.
 */

public class User {
    private int id;
    private String username;
    private String password;
    private String mobileNum;
    private String s_pin;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getS_pin() {
        return s_pin;
    }

    public void setS_pin(String s_pin) {
        this.s_pin = s_pin;
    }
}
