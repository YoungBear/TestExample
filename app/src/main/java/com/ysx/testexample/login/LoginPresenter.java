package com.ysx.testexample.login;


/**
 * @author ysx
 * @date 2017/11/16
 * @description
 */

public class LoginPresenter {
    private static final String TAG = "LoginPresenter";

    private final UserManager mUserManager;

    public LoginPresenter(UserManager userManager) {
        mUserManager = userManager;
    }

    public void login(String username, String password) {
        if (username == null || username.length() == 0) {
            return;
        }
        if (password == null || password.length() == 0) {
            return;
        }

        mUserManager.performLogin(username, password);
    }
}
