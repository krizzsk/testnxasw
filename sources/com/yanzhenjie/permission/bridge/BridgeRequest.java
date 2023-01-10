package com.yanzhenjie.permission.bridge;

import com.yanzhenjie.permission.source.Source;

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
    private final Source f58928a;

    /* renamed from: b */
    private int f58929b;

    /* renamed from: c */
    private Callback f58930c;

    /* renamed from: d */
    private String[] f58931d;

    public interface Callback {
        void onCallback();
    }

    public BridgeRequest(Source source) {
        this.f58928a = source;
    }

    public Source getSource() {
        return this.f58928a;
    }

    public int getType() {
        return this.f58929b;
    }

    public void setType(int i) {
        this.f58929b = i;
    }

    public Callback getCallback() {
        return this.f58930c;
    }

    public void setCallback(Callback callback) {
        this.f58930c = callback;
    }

    public String[] getPermissions() {
        return this.f58931d;
    }

    public void setPermissions(String[] strArr) {
        this.f58931d = strArr;
    }
}
