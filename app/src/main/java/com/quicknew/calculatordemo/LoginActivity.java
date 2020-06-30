package com.quicknew.calculatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mUserName, mUserPassword;
    private CheckBox mIsPassword;
    private Button mRegister, mLogin;
    private SharedPreferences.Editor edit;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
    }

    private void initView() {
        mUserName = findViewById(R.id.user_name_et);
        mUserPassword = findViewById(R.id.password_et);
        mIsPassword = findViewById(R.id.is_password_cb);
        mRegister = findViewById(R.id.register_btn);
        mLogin = findViewById(R.id.login_btn);
        mRegister.setOnClickListener(this);
        mLogin.setOnClickListener(this);
        mSharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
        edit = mSharedPreferences.edit();

        mUserName.setText(mSharedPreferences.getString("UserName", ""));
        mUserPassword.setText(mSharedPreferences.getString("password", ""));
    }


    private void initListener() {
        mUserName.setImeOptions(EditorInfo.IME_ACTION_NEXT);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_btn:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.login_btn:
                login();
                break;
        }
    }

    /**
     * 登陆
     */
    private void login() {

        if (mUserName.getText().toString().trim().equals("")) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mUserPassword.getText().toString().trim().equals("")) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        //判断账号密码是否正确
        if (mUserName.getText().toString().trim().equals(mSharedPreferences.getString("RegisterName", ""))
                && mUserPassword.getText().toString().trim().equals(mSharedPreferences.getString("RegisterPassword", ""))) {
            //是否记住密码 若记住密码 保存账号密码，若不记住密码，置空
            if (mIsPassword.isChecked()) {
                edit.putString("UserName", mUserName.getText().toString().trim());
                edit.putString("password", mUserPassword.getText().toString().trim());
                edit.commit();
            } else {
                edit.putString("UserName", "");
                edit.putString("password", "");
                edit.commit();
            }
            startActivity(new Intent(this, MainActivity.class));
            finish();

        } else {
            Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
        }
    }
}
