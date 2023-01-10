package com.didi.sdk.logtime;

import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class DDMethodIntervalTrack {

    /* renamed from: a */
    private static DDMethodIntervalTrack f39492a = null;
    public static final String application_create_time = "application_create_time";

    /* renamed from: b */
    private Map<String, IntervalHolder> f39493b = new HashMap();

    private static class ElapsedTime {
        public long fromLast;
        public long fromStart;
    }

    public static DDMethodIntervalTrack get() {
        if (f39492a == null) {
            f39492a = new DDMethodIntervalTrack();
        }
        return f39492a;
    }

    public void dump() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("applicationdelegate", this.f39493b.toString());
            SystemUtils.log(4, "DDMethodIntervalTrack", hashMap.toString(), (Throwable) null, "com.didi.sdk.logtime.DDMethodIntervalTrack", 35);
            OmegaSDKAdapter.trackEvent("tech_launch_time", (Map<String, Object>) hashMap);
            this.f39493b.clear();
        } catch (Exception unused) {
        }
    }

    public void methodStart(String str) {
        try {
            Map<String, IntervalHolder> map = this.f39493b;
            IntervalHolder intervalHolder = map.get(str);
            if (intervalHolder == null) {
                intervalHolder = new IntervalHolder();
            }
            map.put(str, intervalHolder);
            intervalHolder.elapsedTime.fromStart = System.currentTimeMillis();
        } catch (Exception unused) {
        }
    }

    public void methodEnd(String str) {
        try {
            IntervalHolder intervalHolder = this.f39493b.get(str);
            if (intervalHolder == null) {
                intervalHolder = new IntervalHolder();
                intervalHolder.elapsedTime.fromStart = System.currentTimeMillis();
            }
            intervalHolder.elapsedTime.fromLast = System.currentTimeMillis();
        } catch (Exception unused) {
        }
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
