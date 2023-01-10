package com.didi.entrega.router;

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
    private int f22883a = 0;

    /* renamed from: b */
    private String f22884b;

    /* renamed from: c */
    private String f22885c;

    /* renamed from: d */
    private Class<?> f22886d;

    /* renamed from: e */
    private Bundle f22887e;
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
        this.f22885c = request.getPath();
        this.f22886d = request.getTarget();
        this.f22887e = request.getExtras();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67653a(int i) {
        this.f22883a = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67655a(String str) {
        this.f22884b = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo67654a(Request request) {
        this.f22885c = request.getPath();
        this.f22886d = request.getTarget();
        this.f22887e = request.getExtras();
    }

    public int getCode() {
        return this.f22883a;
    }

    public boolean isSuccessful() {
        return this.f22883a == 0;
    }

    public String getMessage() {
        return this.f22884b;
    }

    public void setResponseExtras(Bundle bundle) {
        this.responseExtras = bundle;
    }

    public Bundle getResponseExtras() {
        return this.responseExtras;
    }

    public Bundle getRequestExtras() {
        return this.f22887e;
    }

    public Class<?> getRequestTarget() {
        return this.f22886d;
    }

    public String getRequestPath() {
        return this.f22885c;
    }

    public String toString() {
        return "Response[code:" + codeToString(this.f22883a) + "(" + this.f22883a + ")" + ", message:" + this.f22884b + ", [requestPath:" + this.f22885c + ", requestTarget:" + this.f22886d + ", requestExtras:" + this.f22887e + "], responseExtras:" + this.responseExtras + Const.jaRight;
    }
}
