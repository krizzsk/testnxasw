package com.lyft.kronos.internal;

import com.lyft.kronos.Clock;
import com.lyft.kronos.KronosClock;
import com.lyft.kronos.KronosTime;
import com.lyft.kronos.internal.ntp.SntpService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo148868d2 = {"Lcom/lyft/kronos/internal/KronosClockImpl;", "Lcom/lyft/kronos/KronosClock;", "ntpService", "Lcom/lyft/kronos/internal/ntp/SntpService;", "fallbackClock", "Lcom/lyft/kronos/Clock;", "(Lcom/lyft/kronos/internal/ntp/SntpService;Lcom/lyft/kronos/Clock;)V", "getCurrentNtpTimeMs", "", "()Ljava/lang/Long;", "getCurrentTime", "Lcom/lyft/kronos/KronosTime;", "getElapsedTimeMs", "shutdown", "", "sync", "", "syncInBackground", "kronos-java"}, mo148869k = 1, mo148870mv = {1, 4, 0})
/* compiled from: KronosClockImpl.kt */
public final class KronosClockImpl implements KronosClock {

    /* renamed from: a */
    private final SntpService f58502a;

    /* renamed from: b */
    private final Clock f58503b;

    public KronosClockImpl(SntpService sntpService, Clock clock) {
        Intrinsics.checkNotNullParameter(sntpService, "ntpService");
        Intrinsics.checkNotNullParameter(clock, "fallbackClock");
        this.f58502a = sntpService;
        this.f58503b = clock;
    }

    public long getCurrentTimeMs() {
        return KronosClock.DefaultImpls.getCurrentTimeMs(this);
    }

    public boolean sync() {
        return this.f58502a.sync();
    }

    public void syncInBackground() {
        this.f58502a.syncInBackground();
    }

    public void shutdown() {
        this.f58502a.shutdown();
    }

    public long getElapsedTimeMs() {
        return this.f58503b.getElapsedTimeMs();
    }

    public KronosTime getCurrentTime() {
        KronosTime currentTime = this.f58502a.currentTime();
        return currentTime != null ? currentTime : new KronosTime(this.f58503b.getCurrentTimeMs(), (Long) null);
    }

    public Long getCurrentNtpTimeMs() {
        KronosTime currentTime = this.f58502a.currentTime();
        if (currentTime != null) {
            return Long.valueOf(currentTime.getPosixTimeMs());
        }
        return null;
    }
}
