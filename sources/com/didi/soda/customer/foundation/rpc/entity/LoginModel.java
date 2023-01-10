package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.customer.foundation.util.LoginUtil;

public class LoginModel {

    /* renamed from: a */
    private boolean f43626a = false;

    /* renamed from: b */
    private boolean f43627b = true;

    /* renamed from: c */
    private String f43628c;

    public static LoginModel newInstance() {
        LoginModel loginModel = new LoginModel();
        loginModel.setLogin(LoginUtil.isLogin());
        loginModel.setToken(LoginUtil.getToken());
        loginModel.setNeedPopToRoot(true);
        return loginModel;
    }

    public boolean ismNeedPopToRoot() {
        return this.f43627b;
    }

    public void setNeedPopToRoot(boolean z) {
        this.f43627b = z;
    }

    public String getToken() {
        return this.f43628c;
    }

    public void setToken(String str) {
        this.f43628c = str;
    }

    public boolean isLogin() {
        return this.f43626a;
    }

    public void setLogin(boolean z) {
        this.f43626a = z;
    }
}
