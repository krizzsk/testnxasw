package com.didi.foundation.sdk.utils;

import java.util.ArrayList;
import java.util.List;

public class PerformanceTracker {

    /* renamed from: a */
    private static boolean f23257a = false;

    /* renamed from: b */
    private static List<TraceInfo> f23258b = new ArrayList();

    /* renamed from: c */
    private static TraceInfo f23259c;

    public static void openTrack() {
        f23257a = true;
    }

    public static List<TraceInfo> getTraceInfo() {
        return new ArrayList(f23258b);
    }

    public static void start(String str) {
        try {
            if (f23257a) {
                long currentTimeMillis = System.currentTimeMillis();
                if (f23259c != null) {
                    f23259c.end = currentTimeMillis;
                    f23258b.add(f23259c);
                }
                f23259c = new TraceInfo(str, currentTimeMillis);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void end() {
        try {
            if (f23257a && f23259c != null) {
                f23259c.end = System.currentTimeMillis();
                f23258b.add(f23259c);
                f23259c = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class TraceInfo {
        public long begin;
        public long end;
        public String tag;

        public TraceInfo(String str, long j) {
            this.tag = str;
            this.begin = j;
        }
    }
}
