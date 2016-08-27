package com.example.lfy.dlvideo.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lfy.dlvideo.R;

/**
 * Created by lfy on 2016/8/27.
 */
public class IndexActivity extends AppCompatActivity implements View.OnClickListener {

    Button login;
    Button register;
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        FindView();
    }

    private void FindView() {
        login = (Button) findViewById(R.id.index_login);
        register = (Button) findViewById(R.id.index_register);

        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.index_login:
                Log.d("我是点击事件", "登录");
                intent = new Intent(IndexActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.index_register:
                Log.d("我是点击事件", "注册");
                intent = new Intent(IndexActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
