package com.didi.sdk.audiorecorder.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

public class BroadcastHelper {
    public static final String ACTION = "com.didi.sdk.audiorecorder.omega";
    public static final String OMEGA_PARAM_MULTI_PROCESS_SERVICE_BIND = "3";
    public static final String OMEGA_PARAM_MULTI_PROCESS_SERVICE_DESTROY = "5";
    public static final String OMEGA_PARAM_RECORDING_CHANGED = "11";
    public static final String OMEGA_PARAM_RECORD_START = "9";
    public static final String OMEGA_PARAM_RECORD_STOP = "10";
    public static final int OMEGA_TYPE_RECORD_EXCEPTION = 10;
    public static final int OMEGA_TYPE_RECORD_LIFECYCLE = 9;
    public static final int OMEGA_TYPE_SERVICE = 13;
    public static final String PARAM_EXTRA = "extra";
    public static final String PARAM_PARAM = "param";
    public static final String PARAM_TIME = "time";
    public static final String PARAM_TYPE = "type";

    /* renamed from: a */
    private static final String f38325a = "BroadcastHelper -> ";

    /* renamed from: c */
    private static volatile BroadcastHelper f38326c;

    /* renamed from: b */
    private Context f38327b;

    private BroadcastHelper() {
    }

    public static BroadcastHelper getInstance() {
        if (f38326c == null) {
            synchronized (BroadcastHelper.class) {
                f38326c = new BroadcastHelper();
            }
        }
        return f38326c;
    }

    public void init(Context context) {
        this.f38327b = context;
    }

    public void sendBroadcast(int i, String str) {
        sendBroadcast(i, str, "{\"time\":" + (System.currentTimeMillis() / 1000) + "}");
    }

    public void sendBroadcast(int i, String str, String str2) {
        try {
            if (this.f38327b != null) {
                LogUtil.log("LogUtil", "sendBroadcast type = " + i + ", param = " + str + ", extra = " + str2);
                Bundle bundle = new Bundle();
                bundle.putInt("type", i);
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("param", str);
                }
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("extra", str2);
                }
                this.f38327b.sendBroadcast(new Intent(ACTION).putExtras(bundle));
            }
        } catch (Exception e) {
            LogUtil.log(f38325a, "Failed to send record event. ", e.getLocalizedMessage());
        }
    }
}
