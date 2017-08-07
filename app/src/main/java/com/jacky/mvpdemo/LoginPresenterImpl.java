package com.jacky.mvpdemo;

import android.text.TextUtils;

/**
 * Created by Jacky-PC on 2017/8/3.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginModel loginModel;
    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginModel = new LoginModelImpl();
        this.loginView = loginView;
    }

    @Override
    public void onStartLogin() {
        loginView.onStartLogin();
    }

    @Override
    public void verify(String name, String password) {
        boolean error = false;
        if(TextUtils.isEmpty(name)){
           loginView.onFailure(0);
            error = true;
        }
        if(TextUtils.isEmpty(password)){
            loginView.onFailure(1);
            error = true;
        }

        if(!error){
            loginModel.login(name,password,loginView);
        }

    }

    @Override
    public void onDestroy() {
        loginView = null;
    }
}
