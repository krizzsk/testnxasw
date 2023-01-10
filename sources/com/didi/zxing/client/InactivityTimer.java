package com.didi.zxing.client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.util.Log;

public final class InactivityTimer {

    /* renamed from: a */
    private static final String f48137a = "InactivityTimer";

    /* renamed from: b */
    private static final long f48138b = 300000;

    /* renamed from: c */
    private final Context f48139c;

    /* renamed from: d */
    private final BroadcastReceiver f48140d;

    /* renamed from: e */
    private boolean f48141e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Handler f48142f;

    /* renamed from: g */
    private Runnable f48143g;

    /* renamed from: h */
    private boolean f48144h;

    public InactivityTimer(Context context, Runnable runnable) {
        this.f48139c = context;
        this.f48143g = runnable;
        this.f48140d = new PowerStatusReceiver();
        this.f48142f = new Handler();
    }

    public void activity() {
        m36107c();
        if (this.f48144h) {
            this.f48142f.postDelayed(this.f48143g, 300000);
        }
    }

    public void start() {
        m36106b();
        activity();
    }

    public void cancel() {
        m36107c();
        m36103a();
    }

    /* renamed from: a */
    private void m36103a() {
        if (this.f48141e) {
            try {
                this.f48139c.unregisterReceiver(this.f48140d);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f48141e = false;
        }
    }

    /* renamed from: b */
    private void m36106b() {
        if (!this.f48141e) {
            try {
                this.f48139c.registerReceiver(this.f48140d, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
            this.f48141e = true;
        }
    }

    /* renamed from: c */
    private void m36107c() {
        this.f48142f.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36105a(boolean z) {
        this.f48144h = z;
        if (this.f48141e) {
            activity();
        }
    }

    private final class PowerStatusReceiver extends BroadcastReceiver {
        private PowerStatusReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                final boolean z = intent.getIntExtra("plugged", -1) <= 0;
                InactivityTimer.this.f48142f.post(new Runnable() {
                    public void run() {
                        InactivityTimer.this.m36105a(z);
                    }
                });
            }
        }
    }
}
