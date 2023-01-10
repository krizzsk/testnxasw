package com.didi.lockscreen.framework;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class LockScreenService extends Service {

    /* renamed from: a */
    private LockScreenReceiver f26652a;

    /* renamed from: b */
    private IntentFilter f26653b = new IntentFilter();

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        this.f26653b.addAction("android.intent.action.SCREEN_ON");
        this.f26653b.setPriority(Integer.MAX_VALUE);
        if (this.f26652a == null) {
            this.f26652a = new LockScreenReceiver();
            this.f26653b.setPriority(Integer.MAX_VALUE);
            try {
                registerReceiver(this.f26652a, this.f26653b);
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        }
        return LockScreenAopllo.isAllowed() ? 2 : 1;
    }

    public void onDestroy() {
        LockScreenReceiver lockScreenReceiver = this.f26652a;
        if (lockScreenReceiver != null) {
            try {
                unregisterReceiver(lockScreenReceiver);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f26652a = null;
        }
        super.onDestroy();
    }
}
