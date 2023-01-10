package com.didi.unifylogin.flutter;

import com.didi.unifylogin.store.LoginStore;
import com.google.gson.Gson;
import com.taxis99.R;

public class Result {

    /* renamed from: a */
    private int f47439a = -1;

    /* renamed from: b */
    private String f47440b = "";

    public static String error(int i, String str) {
        Result result = new Result();
        result.f47439a = i;
        result.f47440b = str;
        return result.toString();
    }

    public static String error(String str) {
        Result result = new Result();
        result.f47440b = str;
        return result.toString();
    }

    public static String error() {
        Result result = new Result();
        result.f47440b = LoginStore.getContext().getString(R.string.login_unify_net_error);
        return result.toString();
    }

    public static String from(Object obj) {
        return new Gson().toJson(obj);
    }

    /* renamed from: ok */
    public static String m35294ok() {
        Result result = new Result();
        result.f47439a = 0;
        return result.toString();
    }

    public String toString() {
        return "{\"errno\":" + this.f47439a + ",\"error\":\"" + this.f47440b + "\"}";
    }
}
