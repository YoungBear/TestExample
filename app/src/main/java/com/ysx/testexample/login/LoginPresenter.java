package com.ysx.testexample.login;


import android.text.TextUtils;
import android.util.Log;

/**
 * @author ysx
 * @date 2017/11/16
 * @description
 */

public class LoginPresenter {
    private static final String TAG = "LoginPresenter";

    private final UserManager mUserManager = new UserManager();

    public void login(String username, String password) {
        Log.d(TAG, "login: username: " + username + ", password: " + password);
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            return;
        }

        mUserManager.performLogin(username, password);
    }

}
