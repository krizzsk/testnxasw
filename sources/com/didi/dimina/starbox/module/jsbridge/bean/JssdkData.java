package com.didi.dimina.starbox.module.jsbridge.bean;

import java.util.ArrayList;

public class JssdkData {

    /* renamed from: a */
    private ArrayList<JssdkBean> f19909a;

    /* renamed from: b */
    private int f19910b;

    public ArrayList<JssdkBean> getData() {
        return this.f19909a;
    }

    public void setData(ArrayList<JssdkBean> arrayList) {
        this.f19909a = arrayList;
    }

    public int getErrorCode() {
        return this.f19910b;
    }

    public void setErrorCode(int i) {
        this.f19910b = i;
    }

    public String toString() {
        return "JssdkData{data=" + this.f19909a + ", errorCode=" + this.f19910b + '}';
    }
}
