package com.didi.map.sdk.maprouter;

import android.text.TextUtils;

public class DriverOrderHandler {

    /* renamed from: a */
    private static DriverOrderHandler f30741a = new DriverOrderHandler();

    /* renamed from: b */
    private String f30742b = "";

    private DriverOrderHandler() {
    }

    public static DriverOrderHandler getInstance() {
        return f30741a;
    }

    public void updateOrderId(String str) {
        if (!TextUtils.equals(this.f30742b, str)) {
            this.f30742b = str;
        }
    }

    public String getCurrentOrderId() {
        return this.f30742b;
    }
}
