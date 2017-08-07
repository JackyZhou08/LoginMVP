package com.jacky.mvpdemo;

/**
 * Created by Jacky-PC on 2017/8/3.
 */

public interface LoginView {

    void onStartLogin();

    void onSuccess();

    /**
     *
     * @param status 0为账号为空，1为密码为空,2为其它
     */
    void onFailure(int status);
}
