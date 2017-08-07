package com.jacky.mvpdemo;

/**
 * Created by Jacky-PC on 2017/8/3.
 */

public interface LoginPresenter {

    void onStartLogin();

    void verify(String name,String password);

    void onDestroy();
}
