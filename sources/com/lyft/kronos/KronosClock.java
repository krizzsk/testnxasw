package com.lyft.kronos;

import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\tH&¨\u0006\r"}, mo148868d2 = {"Lcom/lyft/kronos/KronosClock;", "Lcom/lyft/kronos/Clock;", "getCurrentNtpTimeMs", "", "()Ljava/lang/Long;", "getCurrentTime", "Lcom/lyft/kronos/KronosTime;", "getCurrentTimeMs", "shutdown", "", "sync", "", "syncInBackground", "kronos-java"}, mo148869k = 1, mo148870mv = {1, 4, 0})
/* compiled from: Clock.kt */
public interface KronosClock extends Clock {
    Long getCurrentNtpTimeMs();

    KronosTime getCurrentTime();

    long getCurrentTimeMs();

    void shutdown();

    boolean sync();

    void syncInBackground();

    @Metadata(mo148866bv = {1, 0, 3}, mo148869k = 3, mo148870mv = {1, 4, 0})
    /* compiled from: Clock.kt */
    public static final class DefaultImpls {
        public static long getCurrentTimeMs(KronosClock kronosClock) {
            return kronosClock.getCurrentTime().getPosixTimeMs();
        }
    }
}
