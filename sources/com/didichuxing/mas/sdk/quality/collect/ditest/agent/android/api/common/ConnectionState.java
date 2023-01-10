package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.common;

import java.util.concurrent.TimeUnit;

public final class ConnectionState {
    public static final ConnectionState NULL = new ConnectionState();

    /* renamed from: a */
    private final Object f50472a;

    /* renamed from: b */
    private final String f50473b;

    /* renamed from: c */
    private final long f50474c;

    /* renamed from: d */
    private final long f50475d;

    /* renamed from: e */
    private final TimeUnit f50476e;

    /* renamed from: f */
    private final long f50477f;

    /* renamed from: g */
    private final TimeUnit f50478g;

    /* renamed from: h */
    private final long f50479h;

    /* renamed from: i */
    private final int f50480i;

    /* renamed from: j */
    private final int f50481j;

    /* renamed from: k */
    private final boolean f50482k;

    /* renamed from: l */
    private final int f50483l;

    private ConnectionState() {
        this.f50472a = null;
        this.f50473b = null;
        this.f50474c = 0;
        this.f50475d = 60;
        this.f50476e = TimeUnit.SECONDS;
        this.f50477f = 600;
        this.f50478g = TimeUnit.SECONDS;
        this.f50479h = 1000;
        this.f50480i = 50;
        this.f50481j = 1024;
        this.f50482k = true;
        this.f50483l = 10;
    }

    public ConnectionState(Object obj, String str, long j, long j2, TimeUnit timeUnit, long j3, TimeUnit timeUnit2, long j4, int i, int i2, boolean z, int i3) {
        this.f50472a = obj;
        this.f50473b = str;
        this.f50474c = j;
        this.f50475d = j2;
        this.f50476e = timeUnit;
        this.f50477f = j3;
        this.f50478g = timeUnit2;
        this.f50479h = j4;
        this.f50480i = i;
        this.f50481j = i2;
        this.f50482k = z;
        this.f50483l = i3;
    }

    public Object getDataToken() {
        return this.f50472a;
    }

    public String getCrossProcessId() {
        return this.f50473b;
    }

    public long getServerTimestamp() {
        return this.f50474c;
    }

    public long getHarvestIntervalInSeconds() {
        return TimeUnit.SECONDS.convert(this.f50475d, this.f50476e);
    }

    public long getHarvestIntervalInMilliseconds() {
        return TimeUnit.MILLISECONDS.convert(this.f50475d, this.f50476e);
    }

    public long getMaxTransactionAgeInSeconds() {
        return TimeUnit.SECONDS.convert(this.f50477f, this.f50478g);
    }

    public long getMaxTransactionAgeInMilliseconds() {
        return TimeUnit.MILLISECONDS.convert(this.f50477f, this.f50478g);
    }

    public long getMaxTransactionCount() {
        return this.f50479h;
    }

    public int getStackTraceLimit() {
        return this.f50480i;
    }

    public int getResponseBodyLimit() {
        return this.f50481j;
    }

    public boolean isCollectingNetworkErrors() {
        return this.f50482k;
    }

    public int getErrorLimit() {
        return this.f50483l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f50472a);
        return sb.toString();
    }
}
