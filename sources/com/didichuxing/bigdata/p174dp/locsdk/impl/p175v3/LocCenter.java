package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.didi.mapbizinterface.track.MapTrackExtraDataProvider;
import com.didi.trackupload.sdk.Constants;
import com.didichuxing.bigdata.p174dp.locsdk.Config;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p174dp.locsdk.FLPDiffInfoGetter;
import com.didichuxing.bigdata.p174dp.locsdk.ntp.TimeServiceManager;
import com.didichuxing.bigdata.p174dp.locsdk.utils.ApolloProxy;
import com.didichuxing.bigdata.p174dp.locsdk.utils.Utils;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import rui.config.RConfigConstants;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocCenter */
public class LocCenter {
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static boolean f48513j = ApolloProxy.getInstance().justifyStartAtStopErr();

    /* renamed from: o */
    private static CountDownLatch f48514o = null;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public HashSet<LocationListenerWrapper> f48515a;

    /* renamed from: b */
    private ReadWriteLock f48516b = new ReentrantReadWriteLock();

    /* renamed from: c */
    private Context f48517c = null;

    /* renamed from: d */
    private LocConfessor f48518d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public volatile boolean f48519e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public volatile boolean f48520f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ErrInfo f48521g = null;

    /* renamed from: h */
    private long f48522h;

    /* renamed from: i */
    private StatusBroadcastManager f48523i;

    /* renamed from: k */
    private BroadcastReceiver f48524k = new BroadcastReceiver() {
        public void onReceive(Context context, final Intent intent) {
            ThreadDispatcher.getMainThread().run(new Runnable() {
                public void run() {
                    LocCenter.this.m36380a(intent.getStringExtra("com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.EXTRA_KEY_STATUS_TYPE"), intent.getIntExtra("com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.EXTRA_KEY_STATUS_VALUE", -1), "");
                }
            });
        }
    };

    /* renamed from: l */
    private LocationUpdateInternalListener f48525l = new LocationUpdateInternalListener() {
        public void onLocationUpdate(final DIDILocation dIDILocation, final long j) {
            if (LocCenter.this.m36387b(dIDILocation)) {
                ThreadDispatcher.getMainThread().removeCallbacks((int) Const.MESSAGE_WHAT_ERRINFO);
                ThreadDispatcher.getMainThread().post(new Runnable() {
                    public void run() {
                        if (LocCenter.this.f48519e) {
                            LocationStorage.getInstance().mo121126a(dIDILocation, "loop");
                            if (LocCenter.this.f48515a != null) {
                                LocCenter.this.m36373a(dIDILocation, (int) j);
                            }
                        }
                    }
                });
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("internal listener # on location update but zero loc, provider:");
            sb.append(dIDILocation != null ? dIDILocation.getProvider() : null);
            DLog.m36225d(sb.toString());
        }

        public void onLocationErr(final ErrInfo errInfo, long j) {
            ThreadDispatcher.getMainThread().postDelayed(Const.MESSAGE_WHAT_ERRINFO, new Runnable() {
                public void run() {
                    if (LocCenter.this.f48519e && LocCenter.this.f48515a != null) {
                        ErrInfo unused = LocCenter.this.f48521g = errInfo;
                        LocCenter.this.f48521g.setLocalTime(System.currentTimeMillis());
                        LocCenter.this.m36375a(errInfo);
                        DLog.m36225d(String.valueOf(errInfo));
                    }
                }
            }, Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
        }
    };

    /* renamed from: m */
    private LocationUpdateInternalListener f48526m = new LocationUpdateInternalListener() {
        public void onLocationErr(ErrInfo errInfo, long j) {
        }

        public void onLocationUpdate(final DIDILocation dIDILocation, final long j) {
            if (LocCenter.this.m36387b(dIDILocation)) {
                if ((LocCenter.this.f48520f || LocCenter.this.m36390d()) && (!DIDILocation.SOURCE_FLP_INERTIAL.equals(dIDILocation.getSource()) || LocCenter.this.f48527n)) {
                    LocationStorage.getInstance().mo121126a(dIDILocation, "direct");
                }
                if (LocCenter.this.f48520f) {
                    ThreadDispatcher.getMainThread().removeCallbacks((int) Const.MESSAGE_WHAT_ERRINFO);
                    ThreadDispatcher.getMainThread().post(new Runnable() {
                        public void run() {
                            if (LocCenter.this.f48519e && LocCenter.this.f48515a != null) {
                                LocCenter.this.m36373a(dIDILocation, (int) j);
                            }
                        }
                    });
                }
                ThreadDispatcher.getMainThread().post(new Runnable() {
                    public void run() {
                        if (LocCenter.this.f48519e && LocCenter.this.f48515a != null) {
                            LocCenter.this.m36372a(dIDILocation);
                        }
                    }
                });
                if (DIDILocation.SOURCE_FLP_INERTIAL.equals(dIDILocation.getSource()) && !LocCenter.this.f48527n) {
                    MapTrackExtraDataProvider.getInstance().updateBizInfo(4098, dIDILocation);
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f48527n = false;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36372a(DIDILocation dIDILocation) {
        HashSet<LocationListenerWrapper> hashSet;
        if (dIDILocation != null && (hashSet = this.f48515a) != null && hashSet.size() > 0) {
            StringBuilder sb = new StringBuilder();
            Iterator<LocationListenerWrapper> it = this.f48515a.iterator();
            while (it.hasNext()) {
                LocationListenerWrapper next = it.next();
                if (next.getOption().isDirectNotify()) {
                    long elapsedRealtime = dIDILocation.getElapsedRealtime() - next.getNotifyLocTime();
                    long directNotifyValue = next.getOption().getInterval().getDirectNotifyValue();
                    sb.append(Const.jaLeft);
                    sb.append(next.getOption().getHexModuleKey());
                    sb.append(":");
                    sb.append(directNotifyValue);
                    sb.append(":");
                    sb.append(elapsedRealtime);
                    if (elapsedRealtime >= directNotifyValue) {
                        next.setNotifyLocTime(dIDILocation.getElapsedRealtime());
                        if (!DIDILocation.SOURCE_FLP_INERTIAL.equals(dIDILocation.getSource()) || this.f48527n) {
                            next.getListener().onLocationChanged(dIDILocation);
                        } else if (next.getListener() == Config.mNaviLocListener) {
                            next.getListener().onLocationChanged(dIDILocation);
                        }
                        sb.append(":");
                        sb.append(dIDILocation.getTime());
                        sb.append(":");
                        sb.append(dIDILocation.getLongitude());
                        sb.append(":");
                        sb.append(dIDILocation.getLatitude());
                    }
                    sb.append(Const.jaRight);
                }
            }
            DLog.m36225d(sb.toString());
        }
    }

    public ErrInfo getLastErrInfo() {
        return this.f48521g;
    }

    public LocCenter(Context context) {
        DLog.m36225d("-LocCenter- LocCenter#onCreate");
        this.f48517c = context;
        this.f48515a = new HashSet<>();
        DLog.m36225d("-LocCenter- new locConfessor");
        this.f48518d = new LocConfessor(this.f48517c);
        StatusBroadcastManager instance = StatusBroadcastManager.getInstance();
        this.f48523i = instance;
        instance.init(this.f48517c);
    }

    public void stop() {
        if (f48513j) {
            f48514o = new CountDownLatch(1);
        }
        this.f48519e = false;
        this.f48520f = false;
        this.f48521g = null;
        ThreadDispatcher.getWorkThread().post(new Runnable() {
            public void run() {
                DLog.m36225d("[stop]justify start at stop:" + LocCenter.f48513j + ",runing:" + LocCenter.this.f48519e);
                if (!LocCenter.this.f48519e || !LocCenter.f48513j) {
                    LocCenter.this.m36389c();
                }
            }
        });
        this.f48523i.unRegisterStatusReceiver(this.f48524k);
        this.f48527n = false;
    }

    public void start(LocationListenerWrapper locationListenerWrapper, final String str) {
        CountDownLatch countDownLatch;
        if (f48513j && (countDownLatch = f48514o) != null) {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        LocationStorage.getInstance().setAppId(str);
        this.f48519e = true;
        this.f48522h = Utils.getTimeBoot();
        this.f48521g = null;
        addLocListener(locationListenerWrapper);
        OmegaSDKAdapter.trackEvent("firstlocate_start");
        this.f48520f = true;
        DLog.m36225d("firstlocate_start");
        ThreadDispatcher.getWorkThread().start();
        ThreadDispatcher.getNetThread().start();
        ThreadDispatcher.getWorkThread().post(new Runnable() {
            public void run() {
                DLog.m36225d("[start]justify start at stop:" + LocCenter.f48513j + ",runing:" + LocCenter.this.f48519e);
                if (LocCenter.this.f48519e || !LocCenter.f48513j) {
                    LocCenter.this.m36379a(str);
                }
            }
        });
        this.f48523i.registerStatusReceiver(this.f48524k);
        this.f48527n = ApolloProxy.getInstance().enableInertialVDRAsNormal();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36379a(String str) {
        DLog.m36225d("-LocCenter- start cmd");
        TimeServiceManager.getInstance().start(this.f48517c, Utils.isGlobal());
        try {
            this.f48518d.mo121101a(this.f48525l);
            this.f48518d.mo121106b(this.f48526m);
            this.f48518d.mo121102a(str);
        } catch (Throwable th) {
            DLog.m36225d("LocCenter # start request didi location exception, " + th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m36389c() {
        CountDownLatch countDownLatch;
        DLog.m36225d("-LocCenter- stop cmd");
        try {
            if (this.f48518d != null) {
                this.f48518d.mo121105b();
            }
        } catch (Throwable th) {
            DLog.m36225d("LocCenter # stop remove didi location exception, " + th.getMessage());
        }
        TimeServiceManager.getInstance().stop(this.f48517c);
        ThreadDispatcher.getWorkThread().stop();
        ThreadDispatcher.getNetThread().stop();
        if (f48513j && (countDownLatch = f48514o) != null) {
            countDownLatch.countDown();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m36387b(DIDILocation dIDILocation) {
        return dIDILocation != null && dIDILocation.getError() == 0 && Math.abs(dIDILocation.getLongitude()) > 1.0E-7d && Math.abs(dIDILocation.getLatitude()) > 1.0E-7d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo121081a() {
        return this.f48519e;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36375a(ErrInfo errInfo) {
        Lock readLock = this.f48516b.readLock();
        try {
            readLock.lock();
            if (this.f48515a != null && this.f48515a.size() > 0) {
                Iterator<LocationListenerWrapper> it = this.f48515a.iterator();
                while (it.hasNext()) {
                    it.next().getListener().onLocationError(errInfo.getErrNo(), errInfo);
                }
            }
        } finally {
            readLock.unlock();
        }
    }

    public long getMinInterval() {
        LocConfessor locConfessor = this.f48518d;
        if (locConfessor != null) {
            return locConfessor.mo121107c();
        }
        return 0;
    }

    public String getListenersInfo() {
        LocConfessor locConfessor = this.f48518d;
        return locConfessor != null ? locConfessor.mo121099a() : "";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36373a(DIDILocation dIDILocation, int i) {
        if (this.f48515a != null) {
            m36374a(dIDILocation, (long) i);
        }
        if (this.f48520f) {
            this.f48520f = false;
            HashMap hashMap = new HashMap();
            hashMap.put("first_loc_time", Long.valueOf(Utils.getTimeBoot() - this.f48522h));
            hashMap.put("provider", dIDILocation.getSource());
            OmegaSDKAdapter.trackEvent(FLPDiffInfoGetter.getInstance().getJustStartOmegaKey(), (Map<String, Object>) hashMap);
            DLog.m36225d("firstlocate_suc");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36380a(String str, int i, String str2) {
        Lock readLock = this.f48516b.readLock();
        try {
            readLock.lock();
            if (this.f48515a != null && this.f48515a.size() > 0) {
                Iterator<LocationListenerWrapper> it = this.f48515a.iterator();
                while (it.hasNext()) {
                    it.next().getListener().onStatusUpdate(str, i, str2);
                }
            }
        } finally {
            readLock.unlock();
        }
    }

    /* renamed from: a */
    private void m36374a(DIDILocation dIDILocation, long j) {
        Lock readLock = this.f48516b.readLock();
        try {
            readLock.lock();
            if (!(dIDILocation == null || this.f48515a == null || this.f48515a.size() <= 0)) {
                StringBuilder sb = new StringBuilder();
                sb.append(dIDILocation);
                sb.append("@");
                sb.append(j);
                Iterator<LocationListenerWrapper> it = this.f48515a.iterator();
                while (it.hasNext()) {
                    LocationListenerWrapper next = it.next();
                    if (j % next.getOption().getInterval().getValue() == 0) {
                        if (!DIDILocation.SOURCE_GOOGLE_FLP.equals(dIDILocation.getSource())) {
                            if (!DIDILocation.SOURCE_HUAWEI_FLP.equals(dIDILocation.getSource())) {
                                if (!"gps".equals(dIDILocation.getProvider())) {
                                    sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
                                    sb.append(next.getOption().getHexModuleKey());
                                    next.getListener().onLocationChanged(dIDILocation);
                                }
                            }
                        }
                        if (!next.getOption().isDirectNotify()) {
                            sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
                            sb.append(next.getOption().getHexModuleKey());
                            next.getListener().onLocationChanged(dIDILocation);
                        } else if (SystemClock.elapsedRealtime() - next.getNotifyLocTime() > 60000 && SystemClock.elapsedRealtime() - next.f48543a > 30000) {
                            Event event = new Event("locsdk_err_direct_notify_not_work");
                            event.putAttr("t_loc", Long.valueOf(dIDILocation.getElapsedRealtime()));
                            event.putAttr("t_sys", Long.valueOf(SystemClock.elapsedRealtime()));
                            event.putAttr("t_notify", Long.valueOf(next.getNotifyLocTime()));
                            event.putAttr("key", next.getOption().getModuleKey());
                            OmegaSDKAdapter.trackEvent("locsdk_err_direct_notify_not_work");
                            next.f48543a = SystemClock.elapsedRealtime();
                        }
                    }
                }
                DLog.m36225d(sb.toString());
            }
        } finally {
            readLock.unlock();
        }
    }

    public void addLocListener(LocationListenerWrapper locationListenerWrapper) {
        if (locationListenerWrapper != null) {
            Lock writeLock = this.f48516b.writeLock();
            try {
                writeLock.lock();
                if (!this.f48515a.contains(locationListenerWrapper)) {
                    boolean z = false;
                    Iterator<LocationListenerWrapper> it = this.f48515a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        LocationListenerWrapper next = it.next();
                        if (next.getListener() == locationListenerWrapper.getListener()) {
                            next.setOption(locationListenerWrapper.getOption());
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        this.f48515a.add(locationListenerWrapper);
                    }
                    long a = m36370a(this.f48515a);
                    if (!(this.f48518d == null || a == this.f48518d.mo121107c())) {
                        this.f48518d.mo121100a(a);
                    }
                    this.f48518d.mo121104a((Set<LocationListenerWrapper>) this.f48515a);
                    writeLock.unlock();
                    DLog.m36225d("-LocCenter- loclisteners added, now size is " + this.f48515a.size());
                }
            } finally {
                writeLock.unlock();
            }
        }
    }

    public void removeLocListener(DIDILocationListener dIDILocationListener) {
        Lock writeLock = this.f48516b.writeLock();
        try {
            writeLock.lock();
            Iterator<LocationListenerWrapper> it = this.f48515a.iterator();
            while (it.hasNext()) {
                LocationListenerWrapper next = it.next();
                if (next.getListener() == dIDILocationListener) {
                    this.f48515a.remove(next);
                    if (this.f48515a.size() > 0) {
                        long a = m36370a(this.f48515a);
                        if (!(this.f48518d == null || a == this.f48518d.mo121107c())) {
                            this.f48518d.mo121100a(a);
                        }
                    }
                    this.f48518d.mo121104a((Set<LocationListenerWrapper>) this.f48515a);
                    return;
                }
            }
            writeLock.unlock();
            DLog.m36225d("-LocCenter- loclisteners removed, now size is " + this.f48515a.size());
        } finally {
            writeLock.unlock();
        }
    }

    public void removeAllLocListeners() {
        Lock writeLock = this.f48516b.writeLock();
        try {
            writeLock.lock();
            this.f48515a.clear();
            this.f48518d.mo121104a((Set<LocationListenerWrapper>) this.f48515a);
        } finally {
            writeLock.unlock();
        }
    }

    /* renamed from: a */
    private long m36370a(HashSet<LocationListenerWrapper> hashSet) {
        long value = DIDILocationUpdateOption.IntervalMode.BATTERY_SAVE.getValue();
        Iterator<LocationListenerWrapper> it = hashSet.iterator();
        while (it.hasNext()) {
            LocationListenerWrapper next = it.next();
            if (value > next.getOption().getInterval().getValue()) {
                value = next.getOption().getInterval().getValue();
            }
        }
        return value;
    }

    public int getLocListenersLength() {
        return this.f48515a.size();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m36390d() {
        Lock readLock = this.f48516b.readLock();
        try {
            readLock.lock();
            boolean z = false;
            if (this.f48515a != null && this.f48515a.size() > 0) {
                Iterator<LocationListenerWrapper> it = this.f48515a.iterator();
                while (it.hasNext()) {
                    if (it.next().getOption().isDirectNotify()) {
                        z = true;
                    }
                }
            }
            return z;
        } finally {
            readLock.unlock();
        }
    }
}
