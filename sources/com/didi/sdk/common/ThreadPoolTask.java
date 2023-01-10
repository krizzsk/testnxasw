package com.didi.sdk.common;

import android.os.SystemClock;
import com.didi.sdk.apm.SystemUtils;

public class ThreadPoolTask implements Comparable<ThreadPoolTask>, Runnable {
    public static final int PRIORITY_HIGH = 4;
    public static final int PRIORITY_LOW = 6;
    public static final int PRIORITY_NORMAL = 5;

    /* renamed from: a */
    private static final String f38397a = "ThreadPoolTask";

    /* renamed from: b */
    private static final long f38398b = 5000;

    /* renamed from: c */
    private Runnable f38399c;

    /* renamed from: d */
    private int f38400d = 5;

    /* renamed from: e */
    private long f38401e;

    /* renamed from: f */
    private boolean f38402f;

    public ThreadPoolTask(Runnable runnable, boolean z) {
        this.f38399c = runnable;
        this.f38402f = z;
    }

    public ThreadPoolTask(Runnable runnable, boolean z, int i) {
        this.f38399c = runnable;
        this.f38400d = i;
        this.f38402f = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Runnable mo97729a() {
        return this.f38399c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo97731b() {
        return this.f38400d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo97730a(long j) {
        this.f38401e = j;
    }

    public void run() {
        SystemUtils.setProcessThreadPriority(10);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f38399c.run();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (this.f38402f && elapsedRealtime2 > 5000) {
            SystemUtils.log(6, f38397a, "heavy UI task found: " + elapsedRealtime2, (Throwable) null, "com.didi.sdk.common.ThreadPoolTask", 61);
            SystemUtils.log(5, f38397a, m28967c(), (Throwable) null, "com.didi.sdk.common.ThreadPoolTask", 62);
        }
        this.f38399c = null;
    }

    /* renamed from: c */
    private static String m28967c() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append("Thread name: ");
        sb.append(Thread.currentThread().getName());
        sb.append(10);
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("\tat ");
            sb.append(stackTraceElement.toString());
            sb.append(10);
        }
        return sb.toString();
    }

    public int compareTo(ThreadPoolTask threadPoolTask) {
        int i = this.f38400d;
        int i2 = threadPoolTask.f38400d;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        long j = this.f38401e;
        long j2 = threadPoolTask.f38401e;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        return 0;
    }
}
