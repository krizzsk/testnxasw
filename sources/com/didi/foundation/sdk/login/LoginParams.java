package com.didi.foundation.sdk.login;

import com.didi.foundation.sdk.login.LoginCallbacks;
import com.didi.unifylogin.base.log.LogListener;
import com.didi.unifylogin.base.net.LoginNetModeListener;

public class LoginParams {

    /* renamed from: a */
    private int f23097a;

    /* renamed from: b */
    private int f23098b;

    /* renamed from: c */
    private LoginCallbacks.LocationListener f23099c;

    /* renamed from: d */
    private LoginCallbacks.RiskParamListener f23100d;

    /* renamed from: e */
    private LoginCallbacks.WebViewListener f23101e;

    /* renamed from: f */
    private LogListener f23102f;

    /* renamed from: g */
    private LoginNetModeListener f23103g;

    /* renamed from: h */
    private LoginCallbacks.LoginListener f23104h;

    /* renamed from: i */
    private LoginCallbacks.LoginOutListener f23105i;

    /* renamed from: j */
    private boolean f23106j;

    LoginParams(Builder builder) {
        this.f23097a = builder.mAppId;
        this.f23098b = builder.mDefCountryId;
        this.f23099c = builder.mLocationListener;
        this.f23100d = builder.mRiskParamListener;
        this.f23101e = builder.mWebViewListener;
        this.f23102f = builder.mLogListener;
        this.f23103g = builder.mNetModeListener;
        this.f23104h = builder.mLoginListener;
        this.f23105i = builder.mLogoutListener;
        this.f23106j = builder.mIsGlobal;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo68156a() {
        return this.f23097a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo68157b() {
        return this.f23098b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public LoginCallbacks.LocationListener mo68158c() {
        return this.f23099c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public LoginCallbacks.RiskParamListener mo68159d() {
        return this.f23100d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public LoginCallbacks.WebViewListener mo68160e() {
        return this.f23101e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public LogListener mo68161f() {
        return this.f23102f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public LoginNetModeListener mo68162g() {
        return this.f23103g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public LoginCallbacks.LoginListener mo68163h() {
        return this.f23104h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public LoginCallbacks.LoginOutListener mo68164i() {
        return this.f23105i;
    }

    public boolean isGlobal() {
        return this.f23106j;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public int mAppId;
        /* access modifiers changed from: private */
        public int mDefCountryId = -1;
        /* access modifiers changed from: private */
        public boolean mIsGlobal = true;
        /* access modifiers changed from: private */
        public LoginCallbacks.LocationListener mLocationListener;
        /* access modifiers changed from: private */
        public LoginCallbacks.LogListener mLogListener;
        /* access modifiers changed from: private */
        public LoginCallbacks.LoginListener mLoginListener;
        /* access modifiers changed from: private */
        public LoginCallbacks.LoginOutListener mLogoutListener;
        /* access modifiers changed from: private */
        public LoginNetModeListener mNetModeListener;
        /* access modifiers changed from: private */
        public LoginCallbacks.RiskParamListener mRiskParamListener;
        /* access modifiers changed from: private */
        public LoginCallbacks.WebViewListener mWebViewListener;

        public Builder(int i) {
            this.mAppId = i;
        }

        public Builder setDefCountryId(int i) {
            this.mDefCountryId = i;
            return this;
        }

        public Builder setLocationListener(LoginCallbacks.LocationListener locationListener) {
            this.mLocationListener = locationListener;
            return this;
        }

        public Builder setRiskParamListener(LoginCallbacks.RiskParamListener riskParamListener) {
            this.mRiskParamListener = riskParamListener;
            return this;
        }

        public Builder setWebViewListener(LoginCallbacks.WebViewListener webViewListener) {
            this.mWebViewListener = webViewListener;
            return this;
        }

        public Builder setLogListener(LoginCallbacks.LogListener logListener) {
            this.mLogListener = logListener;
            return this;
        }

        public Builder setNetModeListener(LoginNetModeListener loginNetModeListener) {
            this.mNetModeListener = loginNetModeListener;
            return this;
        }

        public Builder setLoginListener(LoginCallbacks.LoginListener loginListener) {
            this.mLoginListener = loginListener;
            return this;
        }

        public Builder setLogoutListener(LoginCallbacks.LoginOutListener loginOutListener) {
            this.mLogoutListener = loginOutListener;
            return this;
        }

        public Builder setGlobal(boolean z) {
            this.mIsGlobal = z;
            return this;
        }

        public LoginParams build() {
            return new LoginParams(this);
        }
    }
}
