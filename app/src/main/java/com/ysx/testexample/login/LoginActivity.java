package com.ysx.testexample.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.ysx.testexample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @author ysx
 */
public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    @BindView(R.id.et_user_name)
    EditText mEtUserName;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.btn_login)
    Button mBtnLogin;

    private LoginPresenter mLoginPresenter;
    private UserManager mUserManager;
    private PasswordValidator mPasswordValidator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mUserManager = new UserManager();
        mPasswordValidator = new PasswordValidator();
        mLoginPresenter = new LoginPresenter(mUserManager, mPasswordValidator);
    }


    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        Log.d(TAG, "onViewClicked: ");

        mLoginPresenter.login(mEtUserName.getText().toString(), mEtPassword.getText().toString());
    }
}

