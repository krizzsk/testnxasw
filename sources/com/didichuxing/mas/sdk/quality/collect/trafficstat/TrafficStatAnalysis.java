package com.didichuxing.mas.sdk.quality.collect.trafficstat;

import android.content.Context;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.cache.TrafficCache;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.config.TrafficConfig;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.datareader.TrafficDataReader;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.utils.TrafficUtils;
import com.didichuxing.mas.sdk.quality.report.backend.AppStateMonitor;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadPoolHelp;
import com.didichuxing.mas.sdk.quality.report.utils.JsonUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TrafficStatAnalysis {

    /* renamed from: a */
    private static TrafficStatAnalysis f50777a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static int f50778b;

    /* renamed from: b */
    static /* synthetic */ int m37800b() {
        int i = f50778b;
        f50778b = i + 1;
        return i;
    }

    private TrafficStatAnalysis() {
    }

    public static synchronized TrafficStatAnalysis getInstance() {
        TrafficStatAnalysis trafficStatAnalysis;
        synchronized (TrafficStatAnalysis.class) {
            if (f50777a == null) {
                f50777a = new TrafficStatAnalysis();
            }
            trafficStatAnalysis = f50777a;
        }
        return trafficStatAnalysis;
    }

    public void start(Context context) {
        TrafficUtils.init(context);
        m37801c();
        ThreadPoolHelp.Builder.schedule(1).scheduleBuilder().scheduleAtFixedRate(new Runnable() {
            public void run() {
                Thread.currentThread().setName("OmegaSDK.TrafficCache");
                Thread.currentThread().setPriority(1);
                TrafficDataReader.getInstance().getTrafficSnapshot();
                if (((long) TrafficStatAnalysis.f50778b) >= TrafficConfig.TRAFFIC_UOLOAD_INTERVAL) {
                    int unused = TrafficStatAnalysis.f50778b = 0;
                    TrafficStatAnalysis.this.m37802d();
                }
                TrafficStatAnalysis.m37800b();
            }
        }, 0, TrafficConfig.TRAFFIC_STAT_INTERVAL, TimeUnit.MILLISECONDS);
    }

    /* renamed from: c */
    private void m37801c() {
        AppStateMonitor.getInstance().registerAppStateListener(new AppStateMonitor.AppStateListener() {
            public void onInForeground() {
            }

            public void onInBackground() {
                TrafficDataReader.getInstance().getTrafficSnapshot();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m37802d() {
        Map<String, Object> readMapDataFromFile;
        if (TrafficConfig.SWITCH_TRAFFIC_GENERAL_STAT && !TrafficUtils.isUpperLimitByDay() && (readMapDataFromFile = TrafficCache.getTrafficCacheInstance().readMapDataFromFile()) != null && !readMapDataFromFile.isEmpty() && TrafficUtils.containsAllKey(readMapDataFromFile)) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : readMapDataFromFile.entrySet()) {
                hashMap.put((String) next.getKey(), JsonUtil.map2Json((Map) next.getValue()));
            }
            OmegaSDKAdapter.trackMasEvent("omega_generic_traffic_stat", (String) null, hashMap);
            TrafficUtils.addNetEventNum();
        }
    }
}
