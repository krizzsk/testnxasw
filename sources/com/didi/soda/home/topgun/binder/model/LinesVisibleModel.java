package com.didi.soda.home.topgun.binder.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0007\"\u0004\b\n\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/binder/model/LinesVisibleModel;", "", "isHasRatingLine", "", "isHasFulfillmentLine", "isHasRecLine", "(ZZZ)V", "()Z", "setHasFulfillmentLine", "(Z)V", "setHasRatingLine", "setHasRecLine", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: LinesVisibleModel.kt */
public final class LinesVisibleModel {

    /* renamed from: a */
    private boolean f45293a;

    /* renamed from: b */
    private boolean f45294b;

    /* renamed from: c */
    private boolean f45295c;

    public LinesVisibleModel() {
        this(false, false, false, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LinesVisibleModel copy$default(LinesVisibleModel linesVisibleModel, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = linesVisibleModel.f45293a;
        }
        if ((i & 2) != 0) {
            z2 = linesVisibleModel.f45294b;
        }
        if ((i & 4) != 0) {
            z3 = linesVisibleModel.f45295c;
        }
        return linesVisibleModel.copy(z, z2, z3);
    }

    public final boolean component1() {
        return this.f45293a;
    }

    public final boolean component2() {
        return this.f45294b;
    }

    public final boolean component3() {
        return this.f45295c;
    }

    public final LinesVisibleModel copy(boolean z, boolean z2, boolean z3) {
        return new LinesVisibleModel(z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinesVisibleModel)) {
            return false;
        }
        LinesVisibleModel linesVisibleModel = (LinesVisibleModel) obj;
        return this.f45293a == linesVisibleModel.f45293a && this.f45294b == linesVisibleModel.f45294b && this.f45295c == linesVisibleModel.f45295c;
    }

    public int hashCode() {
        boolean z = this.f45293a;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.f45294b;
        if (z3) {
            z3 = true;
        }
        int i2 = (i + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.f45295c;
        if (!z4) {
            z2 = z4;
        }
        return i2 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "LinesVisibleModel(isHasRatingLine=" + this.f45293a + ", isHasFulfillmentLine=" + this.f45294b + ", isHasRecLine=" + this.f45295c + VersionRange.RIGHT_OPEN;
    }

    public LinesVisibleModel(boolean z, boolean z2, boolean z3) {
        this.f45293a = z;
        this.f45294b = z2;
        this.f45295c = z3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LinesVisibleModel(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
    }

    public final boolean isHasRatingLine() {
        return this.f45293a;
    }

    public final void setHasRatingLine(boolean z) {
        this.f45293a = z;
    }

    public final boolean isHasFulfillmentLine() {
        return this.f45294b;
    }

    public final void setHasFulfillmentLine(boolean z) {
        this.f45294b = z;
    }

    public final boolean isHasRecLine() {
        return this.f45295c;
    }

    public final void setHasRecLine(boolean z) {
        this.f45295c = z;
    }
}
