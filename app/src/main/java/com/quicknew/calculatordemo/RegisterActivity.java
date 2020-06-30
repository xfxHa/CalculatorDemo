package com.quicknew.calculatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 *
 */
public class RegisterActivity extends AppCompatActivity {
    private EditText mUserName, mUserPassword, mIsUserPassword;
    private Button mRegister, mBack;
    private SharedPreferences.Editor edit;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        mUserName = findViewById(R.id.user_name_et);
        mUserPassword = findViewById(R.id.password_et);
        mIsUserPassword = findViewById(R.id.password_et1);
        mRegister = findViewById(R.id.register_btn);
        mBack = findViewById(R.id.back_btn);

        mSharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
        edit = mSharedPreferences.edit();
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    /**
     * 注册
     */
    private void register() {
        if (mUserName.getText().toString().trim().equals("")) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mUserPassword.getText().toString().trim().equals("")) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mIsUserPassword.getText().toString().trim().equals("")) {
            Toast.makeText(this, "请再次输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mUserPassword.getText().toString().trim().equals(mIsUserPassword.getText().toString().trim())) {
            //保存账号
            edit.putString("RegisterName", mUserName.getText().toString().trim());
            edit.putString("RegisterPassword", mUserPassword.getText().toString().trim());
            edit.commit();
            finish();
        } else {
            Toast.makeText(this, "两次密码不同", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
