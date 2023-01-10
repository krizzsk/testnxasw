package com.yanzhenjie.permission.bridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

class Messenger extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f58932a = "com.yanzhenjie.permission.bridge";

    /* renamed from: b */
    private final Context f58933b;

    /* renamed from: c */
    private final Callback f58934c;

    public interface Callback {
        void onCallback();
    }

    /* renamed from: a */
    public static void m44543a(Context context) {
        context.sendBroadcast(new Intent(f58932a));
    }

    public Messenger(Context context, Callback callback) {
        this.f58933b = context;
        this.f58934c = callback;
    }

    /* renamed from: a */
    public void mo178859a() {
        try {
            this.f58933b.registerReceiver(this, new IntentFilter(f58932a));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* renamed from: b */
    public void mo178860b() {
        try {
            this.f58933b.unregisterReceiver(this);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
    }

    public void onReceive(Context context, Intent intent) {
        this.f58934c.onCallback();
    }
}
