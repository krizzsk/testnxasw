package com.didi.sdk.logtime;

import android.content.Context;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

public class DiDiLaunchingLogTimer {

    /* renamed from: a */
    private static Logger f39494a = LoggerFactory.getLogger("LogTimer");

    /* renamed from: j */
    private static DiDiLaunchingLogTimer f39495j;

    /* renamed from: b */
    private HashMap<String, IntervalHolder> f39496b = new HashMap<>();

    /* renamed from: c */
    private Map<String, Object> f39497c = new HashMap();

    /* renamed from: d */
    private Map<String, IntervalHolder> f39498d = new HashMap();

    /* renamed from: e */
    private Map<String, IntervalHolder> f39499e = new HashMap();

    /* renamed from: f */
    private Map<String, String> f39500f = new HashMap();

    /* renamed from: g */
    private Map<String, String> f39501g = new HashMap();

    /* renamed from: h */
    private Map<String, String> f39502h = new HashMap();

    /* renamed from: i */
    private boolean f39503i = true;

    /* renamed from: k */
    private boolean f39504k;

    /* renamed from: l */
    private boolean f39505l;

    /* renamed from: m */
    private boolean f39506m;

    /* renamed from: n */
    private boolean f39507n;

    public static class ElapsedTime {
        public long fromLast;
        public long fromStart;
    }

    /* renamed from: a */
    private String m29728a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "Unknown" : "4G" : "Mobile" : "3G" : "2G" : "WIFI";
    }

    private DiDiLaunchingLogTimer() {
    }

    public void stampCreate() {
        this.f39504k = true;
    }

    public void stampStart() {
        this.f39505l = true;
    }

    public void stampResume() {
        this.f39506m = true;
    }

    public void setHotLaunch(boolean z) {
        this.f39507n = z;
    }

    public void cleanStamp() {
        this.f39504k = false;
        this.f39505l = false;
        this.f39506m = false;
    }

    public synchronized IntervalHolder getIntervalHolder(String str) {
        return this.f39496b.get(str);
    }

    public synchronized long getIntrvalTime(String str) {
        IntervalHolder intervalHolder = this.f39496b.get(str);
        if (intervalHolder == null) {
            return 0;
        }
        return intervalHolder.elapsedTime.fromLast - intervalHolder.elapsedTime.fromStart;
    }

    public static DiDiLaunchingLogTimer get() {
        if (f39495j == null) {
            f39495j = new DiDiLaunchingLogTimer();
        }
        return f39495j;
    }

    public synchronized void dump(boolean z) {
        dump(false, (Context) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0151, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void dump(boolean r10, android.content.Context r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = "launch_flag"
            com.didichuxing.apollo.sdk.IToggle r0 = com.didichuxing.apollo.sdk.Apollo.getToggle(r0)     // Catch:{ all -> 0x0152 }
            boolean r0 = r0.allow()     // Catch:{ all -> 0x0152 }
            com.didi.sdk.logging.Logger r1 = f39494a     // Catch:{ all -> 0x0152 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0152 }
            r2.<init>()     // Catch:{ all -> 0x0152 }
            java.lang.String r3 = "hotLaunch = "
            r2.append(r3)     // Catch:{ all -> 0x0152 }
            boolean r3 = r9.f39507n     // Catch:{ all -> 0x0152 }
            r2.append(r3)     // Catch:{ all -> 0x0152 }
            java.lang.String r3 = ",isFirstTrace = "
            r2.append(r3)     // Catch:{ all -> 0x0152 }
            boolean r3 = r9.f39503i     // Catch:{ all -> 0x0152 }
            r2.append(r3)     // Catch:{ all -> 0x0152 }
            java.lang.String r3 = ",create = "
            r2.append(r3)     // Catch:{ all -> 0x0152 }
            boolean r3 = r9.f39504k     // Catch:{ all -> 0x0152 }
            r2.append(r3)     // Catch:{ all -> 0x0152 }
            java.lang.String r3 = ",start = "
            r2.append(r3)     // Catch:{ all -> 0x0152 }
            boolean r3 = r9.f39505l     // Catch:{ all -> 0x0152 }
            r2.append(r3)     // Catch:{ all -> 0x0152 }
            java.lang.String r3 = ",resume = "
            r2.append(r3)     // Catch:{ all -> 0x0152 }
            boolean r3 = r9.f39506m     // Catch:{ all -> 0x0152 }
            r2.append(r3)     // Catch:{ all -> 0x0152 }
            java.lang.String r3 = ",sendHotLaunch = "
            r2.append(r3)     // Catch:{ all -> 0x0152 }
            r2.append(r0)     // Catch:{ all -> 0x0152 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0152 }
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0152 }
            r1.debug((java.lang.String) r2, (java.lang.Object[]) r4)     // Catch:{ all -> 0x0152 }
            boolean r1 = r9.f39503i     // Catch:{ all -> 0x0152 }
            if (r1 == 0) goto L_0x0150
            boolean r1 = r9.f39504k     // Catch:{ all -> 0x0152 }
            if (r1 == 0) goto L_0x0150
            boolean r1 = r9.f39505l     // Catch:{ all -> 0x0152 }
            if (r1 == 0) goto L_0x0150
            boolean r1 = r9.f39506m     // Catch:{ all -> 0x0152 }
            if (r1 == 0) goto L_0x0150
            boolean r1 = r9.f39507n     // Catch:{ all -> 0x0152 }
            if (r1 == 0) goto L_0x006e
            if (r0 != 0) goto L_0x006e
            goto L_0x0150
        L_0x006e:
            java.util.Map<java.lang.String, java.lang.String> r0 = r9.f39502h     // Catch:{ all -> 0x0152 }
            java.lang.String r1 = "has_res"
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0152 }
            r0.put(r1, r10)     // Catch:{ all -> 0x0152 }
            java.util.Map<java.lang.String, java.lang.String> r10 = r9.f39502h     // Catch:{ all -> 0x0152 }
            java.lang.String r0 = "hot_launch"
            boolean r1 = r9.f39507n     // Catch:{ all -> 0x0152 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0152 }
            r10.put(r0, r1)     // Catch:{ all -> 0x0152 }
            java.util.Map<java.lang.String, com.didi.sdk.logtime.DiDiLaunchingLogTimer$IntervalHolder> r10 = r9.f39499e     // Catch:{ all -> 0x0152 }
            java.util.Set r10 = r10.keySet()     // Catch:{ all -> 0x0152 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0152 }
            r0 = 0
        L_0x0092:
            boolean r2 = r10.hasNext()     // Catch:{ all -> 0x0152 }
            if (r2 == 0) goto L_0x00b7
            java.lang.Object r2 = r10.next()     // Catch:{ all -> 0x0152 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0152 }
            java.util.Map<java.lang.String, com.didi.sdk.logtime.DiDiLaunchingLogTimer$IntervalHolder> r4 = r9.f39499e     // Catch:{ all -> 0x0152 }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ all -> 0x0152 }
            com.didi.sdk.logtime.DiDiLaunchingLogTimer$IntervalHolder r4 = (com.didi.sdk.logtime.DiDiLaunchingLogTimer.IntervalHolder) r4     // Catch:{ all -> 0x0152 }
            com.didi.sdk.logtime.DiDiLaunchingLogTimer$ElapsedTime r5 = r4.elapsedTime     // Catch:{ all -> 0x0152 }
            long r5 = r5.fromStart     // Catch:{ all -> 0x0152 }
            com.didi.sdk.logtime.DiDiLaunchingLogTimer$ElapsedTime r4 = r4.elapsedTime     // Catch:{ all -> 0x0152 }
            long r7 = r4.fromLast     // Catch:{ all -> 0x0152 }
            long r7 = r7 - r5
            boolean r2 = com.didi.sdk.logtime.DiDiLogLaunchTimer.isStatisticsPoint(r2)     // Catch:{ all -> 0x0152 }
            if (r2 == 0) goto L_0x0092
            long r0 = r0 + r7
            goto L_0x0092
        L_0x00b7:
            com.google.gson.Gson r10 = new com.google.gson.Gson     // Catch:{ all -> 0x0152 }
            r10.<init>()     // Catch:{ all -> 0x0152 }
            java.util.Map<java.lang.String, java.lang.Object> r2 = r9.f39497c     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = "flags"
            java.util.Map<java.lang.String, java.lang.String> r5 = r9.f39502h     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = r10.toJson((java.lang.Object) r5)     // Catch:{ all -> 0x0152 }
            r2.put(r4, r5)     // Catch:{ all -> 0x0152 }
            java.util.Map<java.lang.String, java.lang.Object> r2 = r9.f39497c     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = "subevents"
            java.util.Map<java.lang.String, java.lang.String> r5 = r9.f39500f     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = r10.toJson((java.lang.Object) r5)     // Catch:{ all -> 0x0152 }
            r2.put(r4, r5)     // Catch:{ all -> 0x0152 }
            java.util.Map<java.lang.String, java.lang.Object> r2 = r9.f39497c     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = "mainevents"
            java.util.Map<java.lang.String, java.lang.String> r5 = r9.f39501g     // Catch:{ all -> 0x0152 }
            java.lang.String r10 = r10.toJson((java.lang.Object) r5)     // Catch:{ all -> 0x0152 }
            r2.put(r4, r10)     // Catch:{ all -> 0x0152 }
            java.util.Map<java.lang.String, java.lang.Object> r10 = r9.f39497c     // Catch:{ all -> 0x0152 }
            java.lang.String r2 = "g_Lang"
            com.didi.sdk.nation.NationComponentData r4 = com.didi.sdk.nation.NationTypeUtil.getNationComponentData()     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = r4.getGLang()     // Catch:{ all -> 0x0152 }
            r10.put(r2, r4)     // Catch:{ all -> 0x0152 }
            if (r11 == 0) goto L_0x0103
            java.util.Map<java.lang.String, java.lang.Object> r10 = r9.f39497c     // Catch:{ all -> 0x0152 }
            java.lang.String r2 = "nt"
            int r11 = com.didi.dynamic.manager.utils.NetworkUtil.getNetworkType(r11)     // Catch:{ all -> 0x0152 }
            java.lang.String r11 = r9.m29728a(r11)     // Catch:{ all -> 0x0152 }
            r10.put(r2, r11)     // Catch:{ all -> 0x0152 }
        L_0x0103:
            java.util.Map<java.lang.String, java.lang.Object> r10 = r9.f39497c     // Catch:{ all -> 0x0152 }
            java.lang.String r11 = "app_launch_total"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0152 }
            r10.put(r11, r0)     // Catch:{ all -> 0x0152 }
            java.lang.String r10 = "app_launch_time"
            java.util.Map<java.lang.String, java.lang.Object> r11 = r9.f39497c     // Catch:{ all -> 0x0152 }
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.Object>) r11)     // Catch:{ all -> 0x0152 }
            com.didi.sdk.logging.Logger r10 = f39494a     // Catch:{ all -> 0x0152 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0152 }
            r11.<init>()     // Catch:{ all -> 0x0152 }
            java.lang.String r0 = "DiDiLaunchingLogTimer:"
            r11.append(r0)     // Catch:{ all -> 0x0152 }
            java.util.Map<java.lang.String, java.lang.Object> r0 = r9.f39497c     // Catch:{ all -> 0x0152 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0152 }
            r11.append(r0)     // Catch:{ all -> 0x0152 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0152 }
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x0152 }
            r10.debug((java.lang.String) r11, (java.lang.Object[]) r0)     // Catch:{ all -> 0x0152 }
            java.util.HashMap<java.lang.String, com.didi.sdk.logtime.DiDiLaunchingLogTimer$IntervalHolder> r10 = r9.f39496b     // Catch:{ all -> 0x0152 }
            r10.clear()     // Catch:{ all -> 0x0152 }
            java.util.Map<java.lang.String, com.didi.sdk.logtime.DiDiLaunchingLogTimer$IntervalHolder> r10 = r9.f39499e     // Catch:{ all -> 0x0152 }
            r10.clear()     // Catch:{ all -> 0x0152 }
            java.util.Map<java.lang.String, com.didi.sdk.logtime.DiDiLaunchingLogTimer$IntervalHolder> r10 = r9.f39498d     // Catch:{ all -> 0x0152 }
            r10.clear()     // Catch:{ all -> 0x0152 }
            java.util.Map<java.lang.String, java.lang.String> r10 = r9.f39500f     // Catch:{ all -> 0x0152 }
            r10.clear()     // Catch:{ all -> 0x0152 }
            java.util.Map<java.lang.String, java.lang.String> r10 = r9.f39501g     // Catch:{ all -> 0x0152 }
            r10.clear()     // Catch:{ all -> 0x0152 }
            r9.f39503i = r3     // Catch:{ all -> 0x0152 }
            monitor-exit(r9)
            return
        L_0x0150:
            monitor-exit(r9)
            return
        L_0x0152:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.logtime.DiDiLaunchingLogTimer.dump(boolean, android.content.Context):void");
    }

    public synchronized String methodStart(String str) {
        Map<String, IntervalHolder> map;
        if (DiDiLogLaunchTimer.isMainPoint(str)) {
            map = this.f39499e;
        } else {
            map = this.f39498d;
        }
        IntervalHolder intervalHolder = map.get(str);
        if (intervalHolder == null) {
            intervalHolder = new IntervalHolder();
        }
        map.put(str, intervalHolder);
        intervalHolder.elapsedTime.fromStart = System.currentTimeMillis();
        return "";
    }

    public synchronized String methodEnd(String str) {
        Map<String, String> map;
        Map<String, IntervalHolder> map2;
        if (DiDiLogLaunchTimer.isMainPoint(str)) {
            map2 = this.f39499e;
            map = this.f39501g;
        } else {
            map2 = this.f39498d;
            map = this.f39500f;
        }
        IntervalHolder intervalHolder = map2.get(str);
        if (intervalHolder == null) {
            intervalHolder = new IntervalHolder();
            intervalHolder.elapsedTime.fromStart = System.currentTimeMillis();
        }
        intervalHolder.elapsedTime.fromLast = System.currentTimeMillis();
        map2.put(str, intervalHolder);
        map.put(str, intervalHolder.toString());
        return "";
    }

    public void clearData() {
        reset();
        this.f39504k = false;
        this.f39505l = false;
        this.f39506m = false;
        this.f39507n = false;
        this.f39503i = true;
    }

    public void reset() {
        this.f39496b.clear();
    }

    private static class IntervalHolder {
        public ElapsedTime elapsedTime;

        private IntervalHolder() {
            this.elapsedTime = new ElapsedTime();
        }

        public String toString() {
            return String.valueOf(this.elapsedTime.fromLast - this.elapsedTime.fromStart);
        }
    }
}
