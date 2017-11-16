package com.ysx.testexample;

import com.ysx.testexample.login.LoginPresenter;
import com.ysx.testexample.login.UserManager;

import org.junit.Test;

import static org.mockito.Mockito.*;


/**
 * @author ysx
 * @date 2017/11/16
 * @description
 */

public class LoginPresenterTest {

    @Test
    public void testLogin() throws Exception {

        UserManager mockUserManager = mock(UserManager.class);
        LoginPresenter loginPresenter = new LoginPresenter(mockUserManager);
        loginPresenter.login("youngbear", "123456");


        verify(mockUserManager).performLogin("youngbear", "123456");
        /**
         * 调用次数
         */
        verify(mockUserManager, times(1)).performLogin("youngbear", "123456");
        verify(mockUserManager, atMost(1)).performLogin("youngbear", "123456");
        verify(mockUserManager, atLeast(1)).performLogin("youngbear", "123456");
        verify(mockUserManager, atLeastOnce()).performLogin("youngbear", "123456");
//        verify(mockUserManager, never()).performLogin("youngbear", "123456");

        /**
         * 参数
         */
        verify(mockUserManager).performLogin(anyString(), anyString());
    }
}
