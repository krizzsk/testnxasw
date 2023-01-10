package com.didi.trackupload.sdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.trackupload.sdk.utils.TrackLog;

public class NetworkConnectMonitor {

    /* renamed from: a */
    private static final String f46557a = "TrackNetMonitor";

    /* renamed from: b */
    private NetworkReceiver f46558b = new NetworkReceiver();

    /* renamed from: c */
    private Context f46559c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Boolean f46560d;

    /* renamed from: e */
    private long f46561e = 0;

    private static class SingletonHolder {
        static NetworkConnectMonitor INSTANCE = new NetworkConnectMonitor();

        private SingletonHolder() {
        }
    }

    public static NetworkConnectMonitor getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(Context context) {
        this.f46559c = context.getApplicationContext();
    }

    public void start() {
        if (this.f46559c != null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
                try {
                    this.f46559c.registerReceiver(this.f46558b, intentFilter);
                } catch (Exception e) {
                    Log.d("Context", "registerReceiver", e);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void stop() {
        Context context = this.f46559c;
        if (context != null) {
            try {
                try {
                    context.unregisterReceiver(this.f46558b);
                } catch (Exception e) {
                    Log.d("Context", "unregisterReceiver", e);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34726a() {
        TrackLog.m34830d(f46557a, "onNetworkReconnected");
        if (SystemClock.elapsedRealtime() - this.f46561e > 40000) {
            TrackLog.m34830d(f46557a, "onNetworkReconnected run UploadCacheTask");
            CoreThread.post(new UploadCacheTask());
        }
        this.f46561e = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r2 = com.didi.sdk.apm.SystemUtils.getActiveNetworkInfo(r2);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m34727a(android.content.Context r2) {
        /*
            r1 = this;
            java.lang.String r0 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r0)
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2
            if (r2 == 0) goto L_0x001e
            android.net.NetworkInfo r2 = com.didi.sdk.apm.SystemUtils.getActiveNetworkInfo(r2)
            if (r2 == 0) goto L_0x001e
            boolean r0 = r2.isAvailable()
            if (r0 == 0) goto L_0x001e
            boolean r2 = r2.isConnected()
            if (r2 == 0) goto L_0x001e
            r2 = 1
            goto L_0x001f
        L_0x001e:
            r2 = 0
        L_0x001f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.core.NetworkConnectMonitor.m34727a(android.content.Context):boolean");
    }

    private class NetworkReceiver extends BroadcastReceiver {
        private NetworkReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION.equals(intent.getAction())) {
                boolean a = NetworkConnectMonitor.this.m34727a(context);
                if (NetworkConnectMonitor.this.f46560d != null && !NetworkConnectMonitor.this.f46560d.booleanValue() && a) {
                    NetworkConnectMonitor.this.m34726a();
                }
                Boolean unused = NetworkConnectMonitor.this.f46560d = Boolean.valueOf(a);
            }
        }
    }
}
