package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.StatusBroadcastManager */
public class StatusBroadcastManager {
    public static final String ACTION_LOCATION_STATUS_CHANGED = "com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.ACTION_LOCATION_STATUS_CHANGED";
    public static final String EXTRA_KEY_STATUS_TYPE = "com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.EXTRA_KEY_STATUS_TYPE";
    public static final String EXTRA_KEY_STATUS_VALUE = "com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.EXTRA_KEY_STATUS_VALUE";

    /* renamed from: a */
    private LocalBroadcastManager f48562a;

    /* renamed from: b */
    private Context f48563b;

    public void unRegisterStatusReceiver(BroadcastReceiver broadcastReceiver) {
        LocalBroadcastManager localBroadcastManager = this.f48562a;
        if (localBroadcastManager != null) {
            localBroadcastManager.unregisterReceiver(broadcastReceiver);
        }
    }

    public void broadcastStatus(String str, int i) {
        if (this.f48562a != null) {
            Intent intent = new Intent("com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.ACTION_LOCATION_STATUS_CHANGED");
            intent.putExtra("com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.EXTRA_KEY_STATUS_TYPE", str);
            intent.putExtra("com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.EXTRA_KEY_STATUS_VALUE", i);
            this.f48562a.sendBroadcast(intent);
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.StatusBroadcastManager$InstanceHolder */
    private static class InstanceHolder {
        static final StatusBroadcastManager sInstance = new StatusBroadcastManager();

        private InstanceHolder() {
        }
    }

    public static StatusBroadcastManager getInstance() {
        return InstanceHolder.sInstance;
    }

    private StatusBroadcastManager() {
    }

    public void init(Context context) {
        if (this.f48563b == null || this.f48562a == null) {
            this.f48563b = context;
            this.f48562a = LocalBroadcastManager.getInstance(context);
        }
    }

    public void registerStatusReceiver(BroadcastReceiver broadcastReceiver) {
        if (this.f48562a != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.ACTION_LOCATION_STATUS_CHANGED");
            this.f48562a.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
