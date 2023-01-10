package com.didichuxing.bigdata.p174dp.locsdk.ntp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p174dp.locsdk.ApolloProxy;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.ntp.ITimeServiceScheduler;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.ntp.TimeServiceManager */
public class TimeServiceManager {

    /* renamed from: a */
    private static final String f48684a = "TimeServiceManager ";

    /* renamed from: f */
    private static final int f48685f = 4;

    /* renamed from: b */
    private InnerTimeServiceImpl f48686b;

    /* renamed from: c */
    private InnerTimeServiceImpl f48687c;

    /* renamed from: d */
    private TimeServiceScheduler f48688d;

    /* renamed from: e */
    private SyncNTPReceiver f48689e;

    /* renamed from: g */
    private int f48690g;

    /* renamed from: h */
    private int f48691h;

    /* renamed from: i */
    private ITimeServiceScheduler.OnTimeScheduleListener f48692i;

    private TimeServiceManager() {
        this.f48690g = 1;
        this.f48691h = 0;
        this.f48692i = new ITimeServiceScheduler.OnTimeScheduleListener() {
            public void onTimeTick(Context context) {
                DLog.m36225d("TimeServiceManager onTimeTick called");
                if (TimeServiceManager.this.m36534c()) {
                    TimeServiceManager.this.m36527a(context, "time_tick_retry");
                }
            }
        };
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.ntp.TimeServiceManager$SingletonHolder */
    private static class SingletonHolder {
        static final TimeServiceManager INSTANCE = new TimeServiceManager();

        private SingletonHolder() {
        }
    }

    public static TimeServiceManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void start(Context context, boolean z) {
        boolean isNTPEnabled = ApolloProxy.getInstance().isNTPEnabled();
        int nTPStatLocPercent = ApolloProxy.getInstance().getNTPStatLocPercent();
        DLog.m36225d("TimeServiceManager start context=" + context + " apolloEnabled=" + isNTPEnabled + " ntpLocStatPercent=" + nTPStatLocPercent);
        if (context != null && isNTPEnabled) {
            if (this.f48688d == null) {
                TimeServiceScheduler timeServiceScheduler = new TimeServiceScheduler(context);
                this.f48688d = timeServiceScheduler;
                timeServiceScheduler.setOnTimeScheduleListener(this.f48692i);
                this.f48688d.start();
                DLog.m36225d("TimeServiceManager TimeTicker started");
            }
            if (this.f48686b == null) {
                this.f48686b = new InnerTimeServiceImpl(context, z);
            }
            InnerTimeServiceImpl innerTimeServiceImpl = this.f48686b;
            if (innerTimeServiceImpl != null) {
                this.f48690g = 1;
                this.f48691h = 0;
                innerTimeServiceImpl.mo121224a();
                m36528a(this.f48686b);
                m36527a(context, "start_service");
                m36526a(context);
            }
        }
    }

    public void stop(Context context) {
        DLog.m36225d("TimeServiceManager stop context=" + context);
        if (context != null) {
            m36532b(context);
            m36528a((InnerTimeServiceImpl) null);
        }
        TimeServiceScheduler timeServiceScheduler = this.f48688d;
        if (timeServiceScheduler != null) {
            timeServiceScheduler.stop();
        }
    }

    public boolean isNTPEnabled() {
        return m36525a() != null;
    }

    public boolean isNTPAvailable() {
        InnerTimeServiceImpl a = m36525a();
        return a != null && a.isAvailable();
    }

    public long getNTPCurrenTimeMillis() {
        return System.currentTimeMillis() + getNTPTimeDiffMillis();
    }

    public long getNTPTimeDiffMillis() {
        InnerTimeServiceImpl a = m36525a();
        if (a != null) {
            return a.mo121228c();
        }
        return 0;
    }

    public void updateStandardTimeRef(TimeSource timeSource, long j) {
        InnerTimeServiceImpl a = m36525a();
        if (a != null) {
            a.mo121225a(timeSource, j);
        }
    }

    /* renamed from: a */
    private synchronized InnerTimeServiceImpl m36525a() {
        return this.f48687c;
    }

    /* renamed from: a */
    private synchronized void m36528a(InnerTimeServiceImpl innerTimeServiceImpl) {
        this.f48687c = innerTimeServiceImpl;
    }

    /* renamed from: a */
    private void m36526a(Context context) {
        if (this.f48689e == null) {
            this.f48689e = new SyncNTPReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
            try {
                try {
                    context.registerReceiver(this.f48689e, intentFilter);
                } catch (Exception e) {
                    Log.d("Context", "registerReceiver", e);
                }
            } catch (Exception e2) {
                DLog.m36225d("TimeServiceManager registerReceiver error=" + e2.getMessage());
            }
        }
    }

    /* renamed from: b */
    private void m36532b(Context context) {
        SyncNTPReceiver syncNTPReceiver = this.f48689e;
        if (syncNTPReceiver != null) {
            try {
                context.unregisterReceiver(syncNTPReceiver);
            } catch (Exception e) {
                try {
                    Log.d("Context", "unregisterReceiver", e);
                } catch (Exception e2) {
                    DLog.m36225d("TimeServiceManager unregisterReceiver error=" + e2.getMessage());
                }
            }
            this.f48689e = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m36531b() {
        InnerTimeServiceImpl a = m36525a();
        if (a != null) {
            a.mo121229d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36527a(Context context, String str) {
        if (context == null) {
            DLog.m36225d("TimeServiceManager syncNTPNetworkTime context is null");
            return;
        }
        boolean c = m36535c(context);
        InnerTimeServiceImpl a = m36525a();
        StringBuilder sb = new StringBuilder();
        sb.append("TimeServiceManager syncNTPNetworkTime scene=");
        sb.append(str);
        sb.append(" netAvailable=");
        sb.append(c);
        sb.append(" serviceAvailable=");
        sb.append(a != null);
        DLog.m36225d(sb.toString());
        if (c && a != null) {
            a.mo121226a(str);
        }
    }

    /* renamed from: c */
    private boolean m36535c(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m36534c() {
        if (isNTPAvailable()) {
            return false;
        }
        int i = this.f48691h + 1;
        this.f48691h = i;
        int i2 = this.f48690g;
        if (i % i2 != 0) {
            return false;
        }
        if (i2 < 4) {
            this.f48690g = i2 << 1;
        }
        return true;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.ntp.TimeServiceManager$SyncNTPReceiver */
    private class SyncNTPReceiver extends BroadcastReceiver {
        private SyncNTPReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            DLog.m36225d("TimeServiceManager SyncNTPReceiver onReceive action=" + action);
            if (action != null) {
                char c = 65535;
                int hashCode = action.hashCode();
                if (hashCode != -1172645946) {
                    if (hashCode != 502473491) {
                        if (hashCode == 505380757 && action.equals("android.intent.action.TIME_SET")) {
                            c = 0;
                        }
                    } else if (action.equals("android.intent.action.TIMEZONE_CHANGED")) {
                        c = 1;
                    }
                } else if (action.equals(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION)) {
                    c = 2;
                }
                if (c == 0 || c == 1) {
                    TimeServiceManager.this.m36531b();
                    TimeServiceManager.this.m36527a(context, "time_changed");
                } else if (c == 2) {
                    TimeServiceManager.this.m36527a(context, "net_changed");
                }
            }
        }
    }
}
