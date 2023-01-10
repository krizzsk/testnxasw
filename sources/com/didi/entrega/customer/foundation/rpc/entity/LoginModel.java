package com.didi.entrega.customer.foundation.rpc.entity;

import com.didi.entrega.customer.foundation.util.LoginUtil;

public class LoginModel {

    /* renamed from: a */
    private boolean f21864a = false;

    /* renamed from: b */
    private boolean f21865b = true;

    /* renamed from: c */
    private String f21866c;

    public static LoginModel newInstance() {
        LoginModel loginModel = new LoginModel();
        loginModel.setLogin(LoginUtil.isLogin());
        loginModel.setToken(LoginUtil.getToken());
        loginModel.setNeedPopToRoot(true);
        return loginModel;
    }

    public boolean ismNeedPopToRoot() {
        return this.f21865b;
    }

    public void setNeedPopToRoot(boolean z) {
        this.f21865b = z;
    }

    public String getToken() {
        return this.f21866c;
    }

    public void setToken(String str) {
        this.f21866c = str;
    }

    public boolean isLogin() {
        return this.f21864a;
    }

    public void setLogin(boolean z) {
        this.f21864a = z;
    }
}
