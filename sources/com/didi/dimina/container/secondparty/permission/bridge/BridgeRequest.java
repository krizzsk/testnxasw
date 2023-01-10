package com.didi.dimina.container.secondparty.permission.bridge;

import com.didi.dimina.container.secondparty.permission.source.Source;

public final class BridgeRequest {
    public static final int TYPE_ALERT_WINDOW = 5;
    public static final int TYPE_APP_DETAILS = 1;
    public static final int TYPE_INSTALL = 3;
    public static final int TYPE_NOTIFY = 6;
    public static final int TYPE_NOTIFY_LISTENER = 7;
    public static final int TYPE_OVERLAY = 4;
    public static final int TYPE_PERMISSION = 2;
    public static final int TYPE_WRITE_SETTING = 8;

    /* renamed from: a */
    private final Source f19224a;

    /* renamed from: b */
    private int f19225b;

    /* renamed from: c */
    private Callback f19226c;

    /* renamed from: d */
    private String[] f19227d;

    public interface Callback {
        void onCallback();
    }

    public BridgeRequest(Source source) {
        this.f19224a = source;
    }

    public Source getSource() {
        return this.f19224a;
    }

    public int getType() {
        return this.f19225b;
    }

    public void setType(int i) {
        this.f19225b = i;
    }

    public Callback getCallback() {
        return this.f19226c;
    }

    public void setCallback(Callback callback) {
        this.f19226c = callback;
    }

    public String[] getPermissions() {
        return this.f19227d;
    }

    public void setPermissions(String[] strArr) {
        this.f19227d = strArr;
    }
}
