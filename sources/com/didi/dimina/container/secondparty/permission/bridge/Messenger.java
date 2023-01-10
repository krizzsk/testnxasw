package com.didi.dimina.container.secondparty.permission.bridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

class Messenger extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f19228a = "com.didi.dimina.container.secondparty.permission.bridge";

    /* renamed from: b */
    private final Context f19229b;

    /* renamed from: c */
    private final Callback f19230c;

    public interface Callback {
        void onCallback();
    }

    /* renamed from: a */
    public static void m16324a(Context context) {
        context.sendBroadcast(new Intent(f19228a));
    }

    public Messenger(Context context, Callback callback) {
        this.f19229b = context;
        this.f19230c = callback;
    }

    /* renamed from: a */
    public void mo60854a() {
        try {
            this.f19229b.registerReceiver(this, new IntentFilter(f19228a));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    /* renamed from: b */
    public void mo60855b() {
        try {
            this.f19229b.unregisterReceiver(this);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
    }

    public void onReceive(Context context, Intent intent) {
        this.f19230c.onCallback();
    }
}
