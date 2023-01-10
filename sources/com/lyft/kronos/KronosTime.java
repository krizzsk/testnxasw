package com.lyft.kronos;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, mo148868d2 = {"Lcom/lyft/kronos/KronosTime;", "", "posixTimeMs", "", "timeSinceLastNtpSyncMs", "(JLjava/lang/Long;)V", "getPosixTimeMs", "()J", "getTimeSinceLastNtpSyncMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(JLjava/lang/Long;)Lcom/lyft/kronos/KronosTime;", "equals", "", "other", "hashCode", "", "toString", "", "kronos-java"}, mo148869k = 1, mo148870mv = {1, 4, 0})
/* compiled from: Clock.kt */
public final class KronosTime {

    /* renamed from: a */
    private final long f58500a;

    /* renamed from: b */
    private final Long f58501b;

    public static /* synthetic */ KronosTime copy$default(KronosTime kronosTime, long j, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            j = kronosTime.f58500a;
        }
        if ((i & 2) != 0) {
            l = kronosTime.f58501b;
        }
        return kronosTime.copy(j, l);
    }

    public final long component1() {
        return this.f58500a;
    }

    public final Long component2() {
        return this.f58501b;
    }

    public final KronosTime copy(long j, Long l) {
        return new KronosTime(j, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KronosTime)) {
            return false;
        }
        KronosTime kronosTime = (KronosTime) obj;
        return this.f58500a == kronosTime.f58500a && Intrinsics.areEqual((Object) this.f58501b, (Object) kronosTime.f58501b);
    }

    public int hashCode() {
        long j = this.f58500a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Long l = this.f58501b;
        return i + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "KronosTime(posixTimeMs=" + this.f58500a + ", timeSinceLastNtpSyncMs=" + this.f58501b + ")";
    }

    public KronosTime(long j, Long l) {
        this.f58500a = j;
        this.f58501b = l;
    }

    public final long getPosixTimeMs() {
        return this.f58500a;
    }

    public final Long getTimeSinceLastNtpSyncMs() {
        return this.f58501b;
    }
}
