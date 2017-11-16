package com.ysx.testexample.login;

import android.util.Log;

/**
 * @author ysx
 * @date 2017/11/16
 * @description
 */

public class UserManager {
    private static final String TAG = "UserManager";

    public UserManager() {

    }

    public void performLogin(String username, String password) {
        Log.d(TAG, "performLogin: username: " + username + ", password: " + password);
    }

    public void performRegister(String username, String password) {
    }
}
