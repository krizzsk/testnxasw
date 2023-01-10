package com.didi.dimina.starbox.module.jsbridge.bean;

import java.util.ArrayList;

public class JssdkBean {

    /* renamed from: a */
    private int f19901a;

    /* renamed from: b */
    private ArrayList<JssdkModuleBean> f19902b;

    /* renamed from: c */
    private String f19903c;

    /* renamed from: d */
    private String f19904d;

    /* renamed from: e */
    private String f19905e;

    /* renamed from: f */
    private int f19906f;

    /* renamed from: g */
    private String f19907g;

    /* renamed from: h */
    private String f19908h;

    public int getGray() {
        return this.f19901a;
    }

    public void setGray(int i) {
        this.f19901a = i;
    }

    public ArrayList<JssdkModuleBean> getModules() {
        return this.f19902b;
    }

    public void setModules(ArrayList<JssdkModuleBean> arrayList) {
        this.f19902b = arrayList;
    }

    public String getAppId() {
        return this.f19903c;
    }

    public void setAppId(String str) {
        this.f19903c = str;
    }

    public String getChannel() {
        return this.f19904d;
    }

    public void setChannel(String str) {
        this.f19904d = str;
    }

    public String getVersion() {
        return this.f19905e;
    }

    public void setVersion(String str) {
        this.f19905e = str;
    }

    public int getPlatform() {
        return this.f19906f;
    }

    public void setPlatform(int i) {
        this.f19906f = i;
    }

    public String getOperator() {
        return this.f19907g;
    }

    public void setOperator(String str) {
        this.f19907g = str;
    }

    public String getOperatorId() {
        return this.f19908h;
    }

    public void setOperatorId(String str) {
        this.f19908h = str;
    }

    public String toString() {
        return "JssdkBean{gray=" + this.f19901a + ", modules=" + this.f19902b + ", appId='" + this.f19903c + '\'' + ", channel='" + this.f19904d + '\'' + ", version='" + this.f19905e + '\'' + ", platform=" + this.f19906f + ", operator='" + this.f19907g + '\'' + ", operatorId='" + this.f19908h + '\'' + '}';
    }
}
