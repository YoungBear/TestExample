package com.ysx.testexample;

import com.ysx.testexample.login.LoginPresenter;
import com.ysx.testexample.login.UserManager;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author ysx
 * @date 2017/11/16
 * @description
 */

public class LoginPresenterTest {

    @Test
    public void testLogin() throws Exception {

        UserManager mockUserManager = Mockito.mock(UserManager.class);
        LoginPresenter loginPresenter = new LoginPresenter(mockUserManager);
        loginPresenter.login("youngbear", "123456");


        Mockito.verify(mockUserManager).performLogin("youngbear", "123456");
    }
}
