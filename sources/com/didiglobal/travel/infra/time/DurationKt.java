package com.didiglobal.travel.infra.time;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u0010\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, mo148868d2 = {"MAX_MILLIS", "", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "", "durationOf", "Lcom/didiglobal/travel/infra/time/Duration;", "normalValue", "unitDiscriminator", "(JI)J", "durationOfMillis", "normalMillis", "(J)J", "durationOfMillisNormalized", "millis", "durationOfNanos", "normalNanos", "durationOfNanosNormalized", "nanos", "millisToNanos", "nanosToMillis", "lib-common_release"}, mo148869k = 2, mo148870mv = {1, 1, 16})
/* compiled from: Duration.kt */
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    public static final int NANOS_IN_MILLIS = 1000000;

    /* renamed from: a */
    private static final long f53990a = 4611686018426L;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final long m40251b(long j) {
        return j * ((long) 1000000);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final long m40249a(long j) {
        return j / ((long) 1000000);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final long m40252c(long j) {
        return Duration.m47652constructorimpl(j << 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final long m40253d(long j) {
        return Duration.m47652constructorimpl((j << 1) + 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final long m40250a(long j, int i) {
        return Duration.m47652constructorimpl((j << 1) + ((long) i));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static final long m40254e(long j) {
        if (-4611686018426999999L <= j && 4611686018426999999L >= j) {
            return m40252c(j);
        }
        return m40253d(m40249a(j));
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static final long m40255f(long j) {
        if (-4611686018426L <= j && f53990a >= j) {
            return m40252c(m40251b(j));
        }
        return m40253d(RangesKt.coerceIn(j, -4611686018427387903L, 4611686018427387903L));
    }
}
