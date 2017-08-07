package com.jacky.mvpdemo;

import android.os.Handler;

/**
 * Created by Jacky-PC on 2017/8/3.
 */

public class LoginModelImpl implements LoginModel {
    @Override
    public void login(final String name, final String password, final LoginView loginView) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(name.equals("周学锐") && password.equals("12345")){
                    loginView.onSuccess();
                }else {
                    loginView.onFailure(2);
                }
            }
        },2000);
    }
}
