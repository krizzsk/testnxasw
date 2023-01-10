package com.didi.trackupload.sdk;

import android.content.Context;
import android.os.SystemClock;
import com.didi.mapbizinterface.common.AppStateMonitor;
import com.didi.mapbizinterface.track.MapTrackExtraDataProvider;
import com.didi.trackupload.sdk.core.CleanUpController;
import com.didi.trackupload.sdk.core.CoreThread;
import com.didi.trackupload.sdk.core.CrashRecoveryController;
import com.didi.trackupload.sdk.core.GatherController;
import com.didi.trackupload.sdk.core.NetworkConnectMonitor;
import com.didi.trackupload.sdk.core.UploadController;
import com.didi.trackupload.sdk.datachannel.DataChannel;
import com.didi.trackupload.sdk.datachannel.IDataChannel;
import com.didi.trackupload.sdk.location.LocationCenter;
import com.didi.trackupload.sdk.storage.TrackDataStorage;
import com.didi.trackupload.sdk.utils.TrackLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TrackController implements AppStateMonitor.OnAppStateChangedListener {

    /* renamed from: a */
    private static final String f46533a = "TrackController";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f46534b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public GatherController f46535c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public UploadController f46536d;

    /* renamed from: e */
    private TrackInitParams f46537e;

    /* renamed from: f */
    private Map<String, TrackClient> f46538f;

    /* renamed from: g */
    private boolean f46539g;

    private TrackController() {
        this.f46535c = new GatherController();
        this.f46536d = new UploadController();
        this.f46537e = new TrackInitParams((IDataChannel) null, (ICommonInfoDelegate) null, false, (File) null);
        this.f46538f = new HashMap();
        this.f46539g = false;
    }

    private static class SingletonHolder {
        static final TrackController INSTANCE = new TrackController();

        private SingletonHolder() {
        }
    }

    public static TrackController getIntance() {
        return SingletonHolder.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo115845a(Context context, TrackInitParams trackInitParams) {
        if (m34705f() == 0) {
            this.f46534b = context.getApplicationContext();
            this.f46537e = trackInitParams;
        }
    }

    public synchronized TrackInitParams getInitParams() {
        return this.f46537e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized int mo115841a() {
        int f = m34705f();
        if (f != 0) {
            return f;
        }
        int g = m34707g();
        if (g != 0) {
            return g;
        }
        CoreThread.create();
        CoreThread.post(new Runnable() {
            public void run() {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                TrackLog.m34830d(TrackController.f46533a, "initService first runnable begin");
                MapTrackExtraDataProvider.getInstance().init(TrackController.this.f46534b);
                LocationCenter.getIntance().init(TrackController.this.f46534b);
                TrackDataStorage.getInstance().init(TrackController.this.f46534b);
                DataChannel.getIntance().init(TrackController.this.f46534b);
                CleanUpController.getIntance().cleanUpBizNodes();
                NetworkConnectMonitor.getInstance().init(TrackController.this.f46534b);
                CrashRecoveryController.getInstance().init();
                AppStateMonitor.getInstance().addOnAppStateChangedListener(TrackController.this);
                TrackLog.m34830d(TrackController.f46533a, "initService first runnable done timediff=" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
            }
        });
        this.f46539g = true;
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized int mo115846b() {
        int e = m34702e();
        if (e != 0) {
            return e;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m34699c() {
        TrackLog.m34830d(f46533a, "onServiceStart");
        NetworkConnectMonitor.getInstance().start();
        HeartBeatTask.getInstance().start();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m34701d() {
        TrackLog.m34830d(f46533a, "onServiceStop");
        NetworkConnectMonitor.getInstance().stop();
        HeartBeatTask.getInstance().stop();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized TrackClient mo115844a(TrackClientType trackClientType, String str) {
        return new TrackClient(trackClientType, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized int mo115842a(TrackClient trackClient) {
        int e = m34702e();
        if (e != 0) {
            return e;
        }
        int e2 = m34703e(trackClient);
        if (e2 != 0) {
            return e2;
        }
        int g = m34708g(trackClient);
        if (g != 0) {
            return g;
        }
        if (this.f46538f.size() == 0) {
            CoreThread.post(new Runnable() {
                public void run() {
                    TrackController.this.m34699c();
                }
            });
        }
        final TrackClient a = trackClient.mo115825a();
        this.f46538f.put(a.getTrackTag(), a);
        TrackLog.m34830d(f46533a, "startTrackClient client=" + trackClient.toSimpleString() + " activeClientSize=" + this.f46538f.size());
        CoreThread.post(new Runnable() {
            public void run() {
                TrackController.this.f46535c.addClient(a);
                TrackController.this.f46536d.addClient(a);
            }
        });
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized int mo115847b(TrackClient trackClient) {
        int e = m34702e();
        if (e != 0) {
            return e;
        }
        int f = m34706f(trackClient);
        if (f != 0) {
            return f;
        }
        final TrackClient a = trackClient.mo115825a();
        this.f46538f.remove(a.getTrackTag());
        TrackLog.m34830d(f46533a, "stopTrackClient client=" + trackClient.toSimpleString() + " activeClientSize=" + this.f46538f.size());
        this.f46536d.removeClient(a);
        CoreThread.post(new Runnable() {
            public void run() {
                TrackController.this.f46535c.removeClient(a);
            }
        });
        if (this.f46538f.size() == 0) {
            CoreThread.post(new Runnable() {
                public void run() {
                    TrackController.this.m34701d();
                }
            });
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized int mo115848c(TrackClient trackClient) {
        int e = m34702e();
        if (e != 0) {
            return e;
        }
        if (m34706f(trackClient) == 0) {
            int e2 = m34703e(trackClient);
            if (e2 != 0) {
                return e2;
            }
            final TrackClient a = trackClient.mo115825a();
            this.f46538f.put(a.getTrackTag(), a);
            TrackLog.m34830d(f46533a, "updateTrackClient client=" + trackClient.toSimpleString() + " activeClientSize=" + this.f46538f.size());
            CoreThread.post(new Runnable() {
                public void run() {
                    TrackController.this.f46535c.updateClient(a);
                    TrackController.this.f46536d.updateClient(a);
                }
            });
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized boolean mo115849d(TrackClient trackClient) {
        return m34706f(trackClient) == 0;
    }

    public synchronized int getRunningClientSize() {
        return this.f46538f.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized int mo115843a(final TrackOnceClient trackOnceClient) {
        int e = m34702e();
        if (e != 0) {
            return e;
        }
        int b = m34696b(trackOnceClient);
        if (b != 0) {
            return b;
        }
        TrackLog.m34830d(f46533a, "startTrackOnceClient client=" + trackOnceClient.toSimpleString());
        CoreThread.post(new Runnable() {
            public void run() {
                TrackController.this.f46536d.startOnceClient(trackOnceClient);
            }
        });
        return 0;
    }

    /* renamed from: e */
    private int m34702e() {
        return this.f46539g ? 0 : 101;
    }

    /* renamed from: f */
    private int m34705f() {
        return !this.f46539g ? 0 : 102;
    }

    /* renamed from: g */
    private int m34707g() {
        if (this.f46534b == null) {
            return 104;
        }
        if (getInitParams().getDataChannel() == null) {
            return 105;
        }
        return getInitParams().getCommonInfoDelegate() == null ? 106 : 0;
    }

    /* renamed from: e */
    private int m34703e(TrackClient trackClient) {
        if (trackClient.getClientType() == null) {
            return 204;
        }
        if (trackClient.getTrackId() == null) {
            return 205;
        }
        if (trackClient.getTrackOptions() == null || !trackClient.getTrackOptions().checkVaild()) {
            return 206;
        }
        return trackClient.getTrackDataDelegate() == null ? 207 : 0;
    }

    /* renamed from: b */
    private int m34696b(TrackOnceClient trackOnceClient) {
        if (trackOnceClient.getClientType() == null) {
            return 204;
        }
        if (trackOnceClient.mo115878b() == null) {
            return 205;
        }
        return trackOnceClient.getTrackDataDelegate() == null ? 207 : 0;
    }

    /* renamed from: f */
    private int m34706f(TrackClient trackClient) {
        return this.f46538f.get(trackClient.getTrackTag()) != null ? 0 : 203;
    }

    /* renamed from: g */
    private int m34708g(TrackClient trackClient) {
        return this.f46538f.get(trackClient.getTrackTag()) == null ? 0 : 202;
    }

    public void onAppStateChanged(AppStateMonitor.AppState appState, String str) {
        TrackLog.m34830d(f46533a, "onAppStateChanged state=" + appState + " page=" + str);
    }

    private static class HeartBeatTask implements Runnable {
        private static final long INTERVAL_MILLIS = 60000;

        private HeartBeatTask() {
        }

        private static class SingletonHolder {
            /* access modifiers changed from: private */
            public static final HeartBeatTask INSTANCE = new HeartBeatTask();

            private SingletonHolder() {
            }
        }

        static HeartBeatTask getInstance() {
            return SingletonHolder.INSTANCE;
        }

        /* access modifiers changed from: package-private */
        public void start() {
            TrackLog.m34830d("TrackHeartBeat", "start");
            CoreThread.post(this);
        }

        /* access modifiers changed from: package-private */
        public void stop() {
            TrackLog.m34830d("TrackHeartBeat", "stop");
            CoreThread.cancel(this);
        }

        public void run() {
            TrackLog.m34830d("TrackHeartBeat", "onHeartBeat");
            CoreThread.postDelayed(this, 60000);
        }
    }
}
