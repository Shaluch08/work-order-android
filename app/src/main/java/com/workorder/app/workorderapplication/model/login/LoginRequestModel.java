package com.workorder.app.workorderapplication.model.login;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bharat Tripathi on 02-May-18.
 */

public class LoginRequestModel {
    @SerializedName("username")
   public String userName;
    @SerializedName("password")
   public String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
