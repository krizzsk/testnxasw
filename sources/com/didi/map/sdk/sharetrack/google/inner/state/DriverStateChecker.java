package com.didi.map.sdk.sharetrack.google.inner.state;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.sdk.sharetrack.logger.DLog;

public class DriverStateChecker {
    public static final String ACTION_DRIVER_SCTX_ERR = "action_driver_sctx_err";
    public static final String ACTION_LINK_STATE_OFFLINE = "action_link_state_offline";
    public static final String ACTION_LINK_STATE_ONLINE = "action_link_state_online";

    /* renamed from: a */
    private static final String f31336a = "DriverStateChecker";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f31337b;

    /* renamed from: c */
    private LatLng f31338c;

    /* renamed from: d */
    private final int f31339d = 180;

    /* renamed from: e */
    private Handler f31340e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private boolean f31341f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f31342g = false;

    /* renamed from: h */
    private final BroadcastReceiver f31343h = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent == null ? null : intent.getAction();
            if (action != null) {
                char c = 65535;
                int hashCode = action.hashCode();
                if (hashCode != 753754141) {
                    if (hashCode == 1657052505 && action.equals(DriverStateChecker.ACTION_LINK_STATE_OFFLINE)) {
                        c = 0;
                    }
                } else if (action.equals(DriverStateChecker.ACTION_LINK_STATE_ONLINE)) {
                    c = 1;
                }
                if (c == 0) {
                    PlatInfo.getInstance().setPushConnect(false);
                } else if (c == 1) {
                    PlatInfo.getInstance().setPushConnect(true);
                }
                DLog.m23962d(DriverStateChecker.f31336a, " || receive push connect action = " + action, new Object[0]);
            }
        }
    };

    /* renamed from: i */
    private Runnable f31344i = new Runnable() {
        public void run() {
            if (DriverStateChecker.this.f31337b != null && !DriverStateChecker.this.f31342g) {
                boolean unused = DriverStateChecker.this.f31342g = true;
                LocalBroadcastManager.getInstance(DriverStateChecker.this.f31337b).sendBroadcast(new Intent(DriverStateChecker.ACTION_DRIVER_SCTX_ERR));
                DLog.m23962d(DriverStateChecker.f31336a, " || broad ACTION_DRIVER_SCTX_ERR", new Object[0]);
            }
        }
    };

    public DriverStateChecker(Context context) {
        this.f31337b = context;
    }

    public void create() {
        if (this.f31337b != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ACTION_LINK_STATE_OFFLINE);
            intentFilter.addAction(ACTION_LINK_STATE_ONLINE);
            LocalBroadcastManager.getInstance(this.f31337b).registerReceiver(this.f31343h, intentFilter);
            m23956a();
        }
    }

    public void destroy() {
        Context context = this.f31337b;
        if (context != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f31343h);
            this.f31337b = null;
            m23958b();
            this.f31340e = null;
        }
    }

    public void onMatched(LatLng latLng, int i) {
        if (latLng != null) {
            LatLng latLng2 = this.f31338c;
            if (latLng2 != null && !latLng2.equals(latLng) && i >= 0 && PlatInfo.getInstance().isPushConnect()) {
                m23958b();
                m23956a();
            }
            this.f31338c = latLng;
        }
    }

    /* renamed from: a */
    private void m23956a() {
        Handler handler = this.f31340e;
        if (handler != null && !this.f31341f && !this.f31342g) {
            handler.postDelayed(this.f31344i, 180000);
            this.f31341f = true;
        }
    }

    /* renamed from: b */
    private void m23958b() {
        Handler handler = this.f31340e;
        if (handler != null) {
            handler.removeCallbacks(this.f31344i);
            this.f31341f = false;
        }
    }
}
