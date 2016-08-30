package com.example.lfy.dlvideo.bean;

import java.util.List;

/**
 * Created by lfy on 2016/8/28.
 */
public class FirstBean {

    //{"Ret":1,"Msg":"1472477101","Data":null}

    String Ret;
    String Msg;
    List<String> data;

    public String getRet() {
        return Ret;
    }

    public void setRet(String ret) {
        Ret = ret;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
