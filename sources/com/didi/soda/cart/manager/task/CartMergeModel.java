package com.didi.soda.cart.manager.task;

import com.didi.soda.cart.omega.FloatingCartOmegaHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u001d\u001a\u00020\u0015J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0016\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, mo148868d2 = {"Lcom/didi/soda/cart/manager/task/CartMergeModel;", "", "runMergeTimes", "", "mergeWaitTime", "", "(IJ)V", "getMergeWaitTime", "()J", "setMergeWaitTime", "(J)V", "getRunMergeTimes", "()I", "setRunMergeTimes", "(I)V", "<set-?>", "", "timeList", "getTimeList", "()Ljava/util/List;", "clearMergeRecord", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "recordMerge", "toString", "", "track", "api", "session", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CartMergeModel.kt */
public final class CartMergeModel {

    /* renamed from: a */
    private int f42570a;

    /* renamed from: b */
    private long f42571b;

    /* renamed from: c */
    private List<Long> f42572c;

    public CartMergeModel() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CartMergeModel copy$default(CartMergeModel cartMergeModel, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cartMergeModel.f42570a;
        }
        if ((i2 & 2) != 0) {
            j = cartMergeModel.f42571b;
        }
        return cartMergeModel.copy(i, j);
    }

    public final int component1() {
        return this.f42570a;
    }

    public final long component2() {
        return this.f42571b;
    }

    public final CartMergeModel copy(int i, long j) {
        return new CartMergeModel(i, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartMergeModel)) {
            return false;
        }
        CartMergeModel cartMergeModel = (CartMergeModel) obj;
        return this.f42570a == cartMergeModel.f42570a && this.f42571b == cartMergeModel.f42571b;
    }

    public int hashCode() {
        return (this.f42570a * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f42571b);
    }

    public String toString() {
        return "CartMergeModel(runMergeTimes=" + this.f42570a + ", mergeWaitTime=" + this.f42571b + VersionRange.RIGHT_OPEN;
    }

    public CartMergeModel(int i, long j) {
        this.f42570a = i;
        this.f42571b = j;
        this.f42572c = new ArrayList();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CartMergeModel(int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? -1 : j);
    }

    public final int getRunMergeTimes() {
        return this.f42570a;
    }

    public final void setRunMergeTimes(int i) {
        this.f42570a = i;
    }

    public final long getMergeWaitTime() {
        return this.f42571b;
    }

    public final void setMergeWaitTime(long j) {
        this.f42571b = j;
    }

    public final List<Long> getTimeList() {
        return this.f42572c;
    }

    public final void track(String str, String str2) {
        List list;
        Intrinsics.checkNotNullParameter(str, "api");
        Intrinsics.checkNotNullParameter(str2, "session");
        if (this.f42571b > 0) {
            this.f42571b = System.currentTimeMillis() - this.f42571b;
        }
        if (this.f42572c.size() > 0) {
            long longValue = ((Number) CollectionsKt.first(this.f42572c)).longValue();
            Iterable<Number> iterable = this.f42572c;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Number longValue2 : iterable) {
                long longValue3 = longValue2.longValue();
                arrayList.add(Long.valueOf(longValue3 - longValue));
                longValue = longValue3;
            }
            list = (List) arrayList;
        } else {
            list = CollectionsKt.emptyList();
        }
        FloatingCartOmegaHelper.Companion.trackAddTaskBegin(str, str2, this, list);
        clearMergeRecord();
    }

    public final void recordMerge() {
        this.f42570a++;
        if (this.f42571b == -1) {
            this.f42571b = System.currentTimeMillis();
            this.f42572c.clear();
        }
    }

    public final void clearMergeRecord() {
        this.f42570a = 0;
        this.f42571b = -1;
        this.f42572c.clear();
    }
}
