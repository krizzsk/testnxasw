package com.didi.soda.router;

import android.os.Bundle;
import com.didichuxing.bigdata.p174dp.locsdk.Const;

public class Response {
    public static final int CODE_DOWNGRADE = -6;
    public static final int CODE_ERROR_PATH = -2;
    public static final int CODE_INTERCEPTED = -5;
    public static final int CODE_NOT_FOUND_HUB = -3;
    public static final int CODE_NOT_FOUND_HUB_HANDLER = -4;
    public static final int CODE_NOT_START = -7;
    public static final int CODE_NO_INIT = -1;
    public static final int CODE_SUCCESS = 0;

    /* renamed from: a */
    private int f46218a = 0;

    /* renamed from: b */
    private String f46219b;

    /* renamed from: c */
    private String f46220c;

    /* renamed from: d */
    private Class<?> f46221d;

    /* renamed from: e */
    private Bundle f46222e;
    protected Bundle responseExtras;

    public static String codeToString(int i) {
        switch (i) {
            case -7:
                return "CODE_NOT_START";
            case -6:
                return "CODE_DOWNGRADE";
            case -5:
                return "CODE_INTERCEPTED";
            case -4:
                return "CODE_NOT_FOUND_HUB_HANDLER";
            case -3:
                return "CODE_NOT_FOUND_HUB";
            case -2:
                return "CODE_ERROR_PATH";
            case -1:
                return "CODE_NO_INIT";
            case 0:
                return "CODE_SUCCESS";
            default:
                return "Unknown";
        }
    }

    Response(Request request) {
        this.f46220c = request.getPath();
        this.f46221d = request.getTarget();
        this.f46222e = request.getExtras();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115197a(int i) {
        this.f46218a = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115199a(String str) {
        this.f46219b = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115198a(Request request) {
        this.f46220c = request.getPath();
        this.f46221d = request.getTarget();
        this.f46222e = request.getExtras();
    }

    public int getCode() {
        return this.f46218a;
    }

    public boolean isSuccessful() {
        return this.f46218a == 0;
    }

    public String getMessage() {
        return this.f46219b;
    }

    public void setResponseExtras(Bundle bundle) {
        this.responseExtras = bundle;
    }

    public Bundle getResponseExtras() {
        return this.responseExtras;
    }

    public Bundle getRequestExtras() {
        return this.f46222e;
    }

    public Class<?> getRequestTarget() {
        return this.f46221d;
    }

    public String getRequestPath() {
        return this.f46220c;
    }

    public String toString() {
        return "Response[code:" + codeToString(this.f46218a) + "(" + this.f46218a + ")" + ", message:" + this.f46219b + ", [requestPath:" + this.f46220c + ", requestTarget:" + this.f46221d + ", requestExtras:" + this.f46222e + "], responseExtras:" + this.responseExtras + Const.jaRight;
    }
}
