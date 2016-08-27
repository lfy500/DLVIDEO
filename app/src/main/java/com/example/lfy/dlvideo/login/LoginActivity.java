package com.example.lfy.dlvideo.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lfy.dlvideo.R;
import com.example.lfy.dlvideo.UIActivity;

/**
 * Created by lfy on 2016/8/27.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FindView();
    }

    private void FindView() {
        button = (Button) findViewById(R.id.login_button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                Intent intent = new Intent(LoginActivity.this, UIActivity.class);
                startActivity(intent);
                break;
        }
    }
}
