package com.didichuxing.mas.sdk.quality.collect.trafficstat.datareader;

import android.os.Process;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.cache.TrafficCache;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.config.TagConfig;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.config.TrafficConfig;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.datareader.snapshot.NetworkStats;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.datareader.snapshot.NetworkStatsFactory;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.model.TrafficData;
import com.didichuxing.mas.sdk.quality.collect.trafficstat.utils.TrafficUtils;
import com.didichuxing.mas.sdk.quality.report.analysis.Tracker;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadPoolHelp;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadTaskObject;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TrafficDataReader {

    /* renamed from: a */
    private static NetworkStatsFactory f50782a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static NetworkStats f50783b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static NetworkStats f50784c;

    /* renamed from: d */
    private static TrafficDataReader f50785d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Lock f50786e = new ReentrantLock();

    private TrafficDataReader() {
        f50782a = new NetworkStatsFactory();
    }

    public static synchronized TrafficDataReader getInstance() {
        TrafficDataReader trafficDataReader;
        synchronized (TrafficDataReader.class) {
            if (f50785d == null) {
                f50785d = new TrafficDataReader();
            }
            trafficDataReader = f50785d;
        }
        return trafficDataReader;
    }

    public void getTrafficSnapshot() {
        if (TrafficConfig.SWITCH_TRAFFIC_GENERAL_STAT && !TrafficUtils.isUpperLimitByDay()) {
            new ThreadTaskObject() {
                public void run() {
                    ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                    Thread.currentThread().setPriority(1);
                    try {
                        TrafficDataReader.this.f50786e.lock();
                        NetworkStats unused = TrafficDataReader.f50784c = TrafficDataReader.this.m37815d();
                        if (!(TrafficDataReader.f50784c == null || TrafficDataReader.f50783b == null)) {
                            NetworkStats subtract = TrafficDataReader.f50784c.subtract(TrafficDataReader.f50783b);
                            if (!subtract.isEmpty()) {
                                TrafficCache.getTrafficCacheInstance().writeCacheFileAsync(TrafficDataReader.this.m37814c(subtract));
                            }
                        }
                        NetworkStats unused2 = TrafficDataReader.f50783b = TrafficDataReader.f50784c;
                    } catch (Exception e) {
                        Tracker.trackGood("omega_generic_traffic_stat:get Traffic Snapshot fail", e);
                        e.printStackTrace();
                    } catch (Throwable th) {
                        TrafficDataReader.this.f50786e.unlock();
                        throw th;
                    }
                    TrafficDataReader.this.f50786e.unlock();
                }
            }.start();
        }
    }

    /* renamed from: c */
    private NetworkStats m37813c() {
        return f50782a.readNetworkStatsSummaryXt();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public NetworkStats m37815d() {
        return f50782a.readNetworkStatsDetail(Process.myUid());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public Map<String, Object> m37814c(NetworkStats networkStats) {
        HashMap hashMap = new HashMap();
        int[] uniqueTags = networkStats.getUniqueTags();
        for (int i = 0; i < uniqueTags.length; i++) {
            Map<String, Object> a = m37808a(networkStats, uniqueTags[i]);
            if (TrafficData.isNotEmpty(a)) {
                String str = TagConfig.mapTable.get(new Integer(uniqueTags[i]));
                if (str == null || str.length() == 0) {
                    str = "unknow";
                }
                hashMap.put(str, a);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private Map<String, Object> m37808a(NetworkStats networkStats, int i) {
        Map<String, Object> emptyDataMap = TrafficData.getEmptyDataMap();
        for (int i2 = 0; i2 < networkStats.size(); i2++) {
            NetworkStats.Entry entry = new NetworkStats.Entry();
            networkStats.getValues(i2, entry);
            if (i == entry.tag) {
                if (entry.iface.indexOf("wlan") >= 0) {
                    if (entry.set == 0) {
                        emptyDataMap.put("bg_wifi_tx", Long.valueOf(entry.txBytes));
                        emptyDataMap.put("bg_wifi_rx", Long.valueOf(entry.rxBytes));
                    } else {
                        emptyDataMap.put("fg_wifi_tx", Long.valueOf(entry.txBytes));
                        emptyDataMap.put("fg_wifi_rx", Long.valueOf(entry.rxBytes));
                    }
                } else if (entry.iface.indexOf("rmnet") >= 0) {
                    if (entry.set == 0) {
                        emptyDataMap.put("bg_mobile_tx", Long.valueOf(entry.txBytes));
                        emptyDataMap.put("bg_mobile_rx", Long.valueOf(entry.rxBytes));
                    } else {
                        emptyDataMap.put("fg_mobile_tx", Long.valueOf(entry.txBytes));
                        emptyDataMap.put("fg_mobile_rx", Long.valueOf(entry.rxBytes));
                    }
                } else if (entry.set == 0) {
                    emptyDataMap.put("bg_other_tx", Long.valueOf(entry.txBytes));
                    emptyDataMap.put("bg_other_rx", Long.valueOf(entry.rxBytes));
                } else {
                    emptyDataMap.put("fg_other_tx", Long.valueOf(entry.txBytes));
                    emptyDataMap.put("fg_other_rx", Long.valueOf(entry.rxBytes));
                }
            }
        }
        return emptyDataMap;
    }
}
