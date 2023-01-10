package com.didi.global.fintech.cashier.core.ktx;

import kotlin.Metadata;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/ktx/Range;", "", "start", "", "end", "(II)V", "getEnd", "()I", "getStart", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: StringKtx.kt */
public final class Range {

    /* renamed from: a */
    private final int f23299a;

    /* renamed from: b */
    private final int f23300b;

    public static /* synthetic */ Range copy$default(Range range, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = range.f23299a;
        }
        if ((i3 & 2) != 0) {
            i2 = range.f23300b;
        }
        return range.copy(i, i2);
    }

    public final int component1() {
        return this.f23299a;
    }

    public final int component2() {
        return this.f23300b;
    }

    public final Range copy(int i, int i2) {
        return new Range(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.f23299a == range.f23299a && this.f23300b == range.f23300b;
    }

    public int hashCode() {
        return (this.f23299a * 31) + this.f23300b;
    }

    public String toString() {
        return "Range(start=" + this.f23299a + ", end=" + this.f23300b + VersionRange.RIGHT_OPEN;
    }

    public Range(int i, int i2) {
        this.f23299a = i;
        this.f23300b = i2;
    }

    public final int getEnd() {
        return this.f23300b;
    }

    public final int getStart() {
        return this.f23299a;
    }
}
