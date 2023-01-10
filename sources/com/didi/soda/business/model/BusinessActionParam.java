package com.didi.soda.business.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ.\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\n\u0010\tR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0005\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001a"}, mo148868d2 = {"Lcom/didi/soda/business/model/BusinessActionParam;", "", "isNeedRefreshBusiness", "", "isNeedRefreshCart", "isWithActInfo", "(ZZLjava/lang/Boolean;)V", "()Z", "setNeedRefreshBusiness", "(Z)V", "setNeedRefreshCart", "()Ljava/lang/Boolean;", "setWithActInfo", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(ZZLjava/lang/Boolean;)Lcom/didi/soda/business/model/BusinessActionParam;", "equals", "other", "hashCode", "", "toString", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BusinessActionParam.kt */
public final class BusinessActionParam {

    /* renamed from: a */
    private boolean f42316a;

    /* renamed from: b */
    private boolean f42317b;

    /* renamed from: c */
    private Boolean f42318c;

    public BusinessActionParam() {
        this(false, false, (Boolean) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BusinessActionParam copy$default(BusinessActionParam businessActionParam, boolean z, boolean z2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            z = businessActionParam.f42316a;
        }
        if ((i & 2) != 0) {
            z2 = businessActionParam.f42317b;
        }
        if ((i & 4) != 0) {
            bool = businessActionParam.f42318c;
        }
        return businessActionParam.copy(z, z2, bool);
    }

    public final boolean component1() {
        return this.f42316a;
    }

    public final boolean component2() {
        return this.f42317b;
    }

    public final Boolean component3() {
        return this.f42318c;
    }

    public final BusinessActionParam copy(boolean z, boolean z2, Boolean bool) {
        return new BusinessActionParam(z, z2, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BusinessActionParam)) {
            return false;
        }
        BusinessActionParam businessActionParam = (BusinessActionParam) obj;
        return this.f42316a == businessActionParam.f42316a && this.f42317b == businessActionParam.f42317b && Intrinsics.areEqual((Object) this.f42318c, (Object) businessActionParam.f42318c);
    }

    public int hashCode() {
        boolean z = this.f42316a;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.f42317b;
        if (!z3) {
            z2 = z3;
        }
        int i2 = (i + (z2 ? 1 : 0)) * 31;
        Boolean bool = this.f42318c;
        return i2 + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "BusinessActionParam(isNeedRefreshBusiness=" + this.f42316a + ", isNeedRefreshCart=" + this.f42317b + ", isWithActInfo=" + this.f42318c + VersionRange.RIGHT_OPEN;
    }

    public BusinessActionParam(boolean z, boolean z2, Boolean bool) {
        this.f42316a = z;
        this.f42317b = z2;
        this.f42318c = bool;
    }

    public final boolean isNeedRefreshBusiness() {
        return this.f42316a;
    }

    public final void setNeedRefreshBusiness(boolean z) {
        this.f42316a = z;
    }

    public final boolean isNeedRefreshCart() {
        return this.f42317b;
    }

    public final void setNeedRefreshCart(boolean z) {
        this.f42317b = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BusinessActionParam(boolean z, boolean z2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : bool);
    }

    public final Boolean isWithActInfo() {
        return this.f42318c;
    }

    public final void setWithActInfo(Boolean bool) {
        this.f42318c = bool;
    }
}
