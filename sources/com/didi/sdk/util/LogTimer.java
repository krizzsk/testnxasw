package com.didi.sdk.util;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.Iterator;
import java.util.LinkedList;

public class LogTimer {

    /* renamed from: a */
    private static Logger f40348a = LoggerFactory.getLogger("LogTimer");

    /* renamed from: b */
    private long f40349b;

    /* renamed from: c */
    private long f40350c;

    /* renamed from: d */
    private LinkedList<String> f40351d;

    /* renamed from: e */
    private long f40352e;

    public static class ElapsedTime {
        public long fromLast;
        public long fromStart;
    }

    public static LogTimer get() {
        return InstanceHolder.LOG_TIMER;
    }

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static final LogTimer LOG_TIMER = new LogTimer();

        private InstanceHolder() {
        }
    }

    private LogTimer() {
        this.f40351d = new LinkedList<>();
    }

    public synchronized long elapsedTime() {
        return elapsedTime((ElapsedTime) null);
    }

    public synchronized long elapsedTime(ElapsedTime elapsedTime) {
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        j = currentTimeMillis - this.f40349b;
        if (elapsedTime != null) {
            elapsedTime.fromLast = currentTimeMillis - this.f40350c;
            elapsedTime.fromStart = j;
        }
        this.f40350c = currentTimeMillis;
        return j;
    }

    public synchronized long reset() {
        return set(System.currentTimeMillis());
    }

    public synchronized long set(long j) {
        this.f40351d.clear();
        this.f40349b = j;
        this.f40350c = j;
        return j;
    }

    public long getMainActivityStartTime() {
        return this.f40352e;
    }

    public void setMainActivityStartTime(long j) {
        this.f40352e = j;
    }

    public synchronized void dump() {
        Iterator it = this.f40351d.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null) {
                f40348a.debug(str, new Object[0]);
            }
        }
        this.f40351d.clear();
    }

    public synchronized long startTime() {
        return this.f40349b;
    }

    public synchronized String methodStart(ElapsedTime elapsedTime, String str) {
        String format;
        if (elapsedTime == null) {
            elapsedTime = new ElapsedTime();
        }
        elapsedTime(elapsedTime);
        format = String.format("[%4dms | +%3dms] %s START...", new Object[]{Long.valueOf(elapsedTime.fromStart), Long.valueOf(elapsedTime.fromLast), str});
        this.f40351d.add(format);
        return format;
    }

    public synchronized String methodEnd(ElapsedTime elapsedTime, String str) {
        String format;
        if (elapsedTime == null) {
            elapsedTime = new ElapsedTime();
        }
        elapsedTime(elapsedTime);
        format = String.format("[%4dms | +%3dms] %s END...", new Object[]{Long.valueOf(elapsedTime.fromStart), Long.valueOf(elapsedTime.fromLast), str});
        this.f40351d.add(format);
        return format;
    }
}
