package com.jacky.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginView{
    private EditText et_account,et_password;
    private Button bt_login;
    private ProgressBar pb_progress;
    private LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_account = (EditText) findViewById(R.id.et_account);
        et_password = (EditText) findViewById(R.id.et_password);
        bt_login = (Button) findViewById(R.id.bt_login);
        pb_progress = (ProgressBar) findViewById(R.id.pb_progress);

        loginPresenter = new LoginPresenterImpl(this);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onStartLogin();
            }
        });
    }


    @Override
    public void onStartLogin() {
        pb_progress.setVisibility(View.VISIBLE);
        loginPresenter.verify(et_account.getText().toString(),et_password.getText().toString());
    }

    @Override
    public void onSuccess() {
        Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
        pb_progress.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(int status) {
        if(status == 0){
            et_account.setError("账号不能为空");
        }
        if(status == 1){
            et_password.setError("密码不能为空");
        }
        if(status == 2){
            Toast.makeText(this,"账号与密码不对应",Toast.LENGTH_SHORT).show();
        }
        pb_progress.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }
}
