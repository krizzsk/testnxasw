package com.didi.soda.customer.coordshop;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, mo148868d2 = {"Lcom/didi/soda/customer/coordshop/CollectedShopInfo;", "", "shopId", "", "position", "", "pageNo", "indexInRv", "(Ljava/lang/String;III)V", "getIndexInRv", "()I", "getPageNo", "getPosition", "getShopId", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "toString", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ShopSaver.kt */
public final class CollectedShopInfo {

    /* renamed from: a */
    private final String f43413a;

    /* renamed from: b */
    private final int f43414b;

    /* renamed from: c */
    private final int f43415c;

    /* renamed from: d */
    private final int f43416d;

    public CollectedShopInfo() {
        this((String) null, 0, 0, 0, 15, (DefaultConstructorMarker) null);
    }

    public CollectedShopInfo(String str, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        this.f43413a = str;
        this.f43414b = i;
        this.f43415c = i2;
        this.f43416d = i3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CollectedShopInfo(String str, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? -1 : i, (i4 & 4) != 0 ? -1 : i2, (i4 & 8) != 0 ? -1 : i3);
    }

    public final String getShopId() {
        return this.f43413a;
    }

    public final int getPosition() {
        return this.f43414b;
    }

    public final int getPageNo() {
        return this.f43415c;
    }

    public final int getIndexInRv() {
        return this.f43416d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj != null) {
            CollectedShopInfo collectedShopInfo = (CollectedShopInfo) obj;
            return Intrinsics.areEqual((Object) this.f43413a, (Object) collectedShopInfo.f43413a) && this.f43414b == collectedShopInfo.f43414b && this.f43415c == collectedShopInfo.f43415c;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.coordshop.CollectedShopInfo");
    }

    public int hashCode() {
        return (((this.f43413a.hashCode() * 31) + this.f43414b) * 31) + this.f43415c;
    }

    public String toString() {
        return "CollectedShopInfo(shopId='" + this.f43413a + "', position=" + this.f43414b + ", pageNo=" + this.f43415c + ", indexInRv=" + this.f43416d + VersionRange.RIGHT_OPEN;
    }
}
