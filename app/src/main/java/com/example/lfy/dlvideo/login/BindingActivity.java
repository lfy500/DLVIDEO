package com.example.lfy.dlvideo.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lfy.dlvideo.R;
import com.example.lfy.dlvideo.UIActivity;

/**
 * Created by lfy on 2016/8/27.
 */
public class BindingActivity extends AppCompatActivity implements View.OnClickListener {

    EditText binding_phone;
    EditText binding_identifying;
    TextView binding_send;
    Button binding_success;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binding);
        FindView();
    }

    private void FindView() {
        binding_phone = (EditText) findViewById(R.id.binding_phone);
        binding_identifying = (EditText) findViewById(R.id.binding_identifying);
        binding_send = (TextView) findViewById(R.id.binding_send);
        binding_success = (Button) findViewById(R.id.binding_success);


        binding_send.setOnClickListener(this);
        binding_success.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.binding_send:

                break;
            case R.id.binding_success:
                BindingSuccess();
                break;
        }
    }

    private void BindingSuccess() {
        Intent intent = new Intent(BindingActivity.this, UIActivity.class);
        startActivity(intent);
    }
}
