package com.didi.payment.kycservice.kyc.p134vm;

import kotlin.Metadata;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/vm/PermissionData;", "", "hasLocEnable", "", "hasGranted", "hasGetCityId", "(ZZZ)V", "getHasGetCityId", "()Z", "getHasGranted", "getHasLocEnable", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.kycservice.kyc.vm.PermissionData */
/* compiled from: SignUp99PayVM.kt */
public final class PermissionData {

    /* renamed from: a */
    private final boolean f33419a;

    /* renamed from: b */
    private final boolean f33420b;

    /* renamed from: c */
    private final boolean f33421c;

    public static /* synthetic */ PermissionData copy$default(PermissionData permissionData, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = permissionData.f33419a;
        }
        if ((i & 2) != 0) {
            z2 = permissionData.f33420b;
        }
        if ((i & 4) != 0) {
            z3 = permissionData.f33421c;
        }
        return permissionData.copy(z, z2, z3);
    }

    public final boolean component1() {
        return this.f33419a;
    }

    public final boolean component2() {
        return this.f33420b;
    }

    public final boolean component3() {
        return this.f33421c;
    }

    public final PermissionData copy(boolean z, boolean z2, boolean z3) {
        return new PermissionData(z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermissionData)) {
            return false;
        }
        PermissionData permissionData = (PermissionData) obj;
        return this.f33419a == permissionData.f33419a && this.f33420b == permissionData.f33420b && this.f33421c == permissionData.f33421c;
    }

    public int hashCode() {
        boolean z = this.f33419a;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.f33420b;
        if (z3) {
            z3 = true;
        }
        int i2 = (i + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.f33421c;
        if (!z4) {
            z2 = z4;
        }
        return i2 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "PermissionData(hasLocEnable=" + this.f33419a + ", hasGranted=" + this.f33420b + ", hasGetCityId=" + this.f33421c + VersionRange.RIGHT_OPEN;
    }

    public PermissionData(boolean z, boolean z2, boolean z3) {
        this.f33419a = z;
        this.f33420b = z2;
        this.f33421c = z3;
    }

    public final boolean getHasLocEnable() {
        return this.f33419a;
    }

    public final boolean getHasGranted() {
        return this.f33420b;
    }

    public final boolean getHasGetCityId() {
        return this.f33421c;
    }
}
