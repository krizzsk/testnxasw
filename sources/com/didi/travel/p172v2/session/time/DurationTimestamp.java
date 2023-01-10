package com.didi.travel.p172v2.session.time;

import android.os.SystemClock;

/* renamed from: com.didi.travel.v2.session.time.DurationTimestamp */
public final class DurationTimestamp extends AbsTimestamp {

    /* renamed from: a */
    private long f47002a;

    /* renamed from: b */
    private volatile boolean f47003b = false;

    public DurationTimestamp(long j) {
        super(0, j);
    }

    public void startup() {
        this.f47003b = true;
        this.f47002a = SystemClock.elapsedRealtime();
    }

    public boolean isRunning() {
        return this.f47003b;
    }

    public long getBaseTimestamp() {
        if (!this.f47003b) {
            return -1;
        }
        return super.getBaseTimestamp();
    }

    public long getCurrentTimestamp() {
        if (!this.f47003b) {
            return -1;
        }
        return super.getCurrentTimestamp();
    }

    /* access modifiers changed from: protected */
    public long getCurrentTimestampInner() {
        if (!this.f47003b) {
            return -1;
        }
        return SystemClock.elapsedRealtime() - this.f47002a;
    }

    public long getMaxTimestamp() {
        if (!this.f47003b) {
            return -1;
        }
        return super.getMaxTimestamp();
    }

    public long getCurrentDuration() {
        if (!this.f47003b) {
            return -1;
        }
        return super.getCurrentDuration();
    }
}
