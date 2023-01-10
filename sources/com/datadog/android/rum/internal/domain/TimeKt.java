package com.datadog.android.rum.internal.domain;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, mo148868d2 = {"asTime", "Lcom/datadog/android/rum/internal/domain/Time;", "", "dd-sdk-android_release"}, mo148869k = 2, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: Time.kt */
public final class TimeKt {
    public static final Time asTime(long j) {
        Time time = new Time(0, 0, 3, (DefaultConstructorMarker) null);
        return new Time(j, TimeUnit.MILLISECONDS.toNanos(j - time.getTimestamp()) + time.getNanoTime());
    }
}
