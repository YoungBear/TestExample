package com.ysx.testexample.login;


/**
 * @author ysx
 * @date 2017/11/16
 * @description
 */

public class LoginPresenter {
    private static final String TAG = "LoginPresenter";

    private final UserManager mUserManager;
    private final PasswordValidator mPasswordValidator;

    public LoginPresenter(UserManager userManager, PasswordValidator passwordValidator) {
        mUserManager = userManager;
        mPasswordValidator = passwordValidator;
    }

    public void login(String username, String password) {
        if (username == null || username.length() == 0) {
            return;
        }
        if (password == null || password.length() == 0) {
            return;
        }

        if (!mPasswordValidator.verifyPassword(password)) {
            return;
        }

        mUserManager.performLogin(username, password);
    }
}
