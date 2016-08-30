package com.example.lfy.dlvideo.login;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lfy.dlvideo.R;
import com.example.lfy.dlvideo.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lfy on 2016/8/27.
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    TextView register_school;
    EditText register_name;
    EditText register_birthday;
    Button register_begin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        FindView();
    }

    private void FindView() {
        register_school = (TextView) findViewById(R.id.register_school);
        register_name = (EditText) findViewById(R.id.register_name);
        register_birthday = (EditText) findViewById(R.id.register_birthday);
        register_begin = (Button) findViewById(R.id.register_begin);

        register_school.setOnClickListener(this);
        register_begin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_school:
                initPopupWindowView(getList(), register_school);
                break;
            case R.id.register_begin:
                Marry();
                break;
        }
    }

    private void Marry() {
        if (register_school.getText().toString().equals("")) {
            ToastUtils.showToast(this, "请选择孩子所在的学校");
        } else if (register_name.getText().toString().equals("")) {
            ToastUtils.showToast(this, "请输入孩子的姓名");
        } else if (register_birthday.getText().toString().equals("")) {
            ToastUtils.showToast(this, "请输入孩子的生日");
        } else {
            Intent intent = new Intent(RegisterActivity.this, BindingActivity.class);
            startActivity(intent);
        }
    }


    private List<String> getList() {
        List<String> Str = new ArrayList<>();
        Str.add("星期一");
        Str.add("星期二");
        Str.add("星期三");
        Str.add("星期四");
        Str.add("星期五");

        return Str;
    }

    PopupWindow popupWindow = null;
    SchoolAdapter spinnerAdapter = null;

    public void initPopupWindowView(final List<String> Str, TextView orderby4) {
        if (popupWindow == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.spinner_view, null);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.spinner_rv);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);

            spinnerAdapter = new SchoolAdapter();
            spinnerAdapter.setText(Str);
            recyclerView.setAdapter(spinnerAdapter);
            int a = Str.size() * 90;
            popupWindow = new PopupWindow(view, 1500, a > 500 ? 500 : a);
        }
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.showAsDropDown(orderby4, 0, 10);

        spinnerAdapter.setOnItemClickListen(new SchoolAdapter.SetOnClick() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void SetOnItemClick(String item) {
                register_school.setText(item);
                if (popupWindow != null)
                    popupWindow.dismiss();
            }
        });
    }
}
