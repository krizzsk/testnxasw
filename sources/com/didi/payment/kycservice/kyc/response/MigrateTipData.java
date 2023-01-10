package com.didi.payment.kycservice.kyc.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/response/MigrateTipData;", "", "migrateTitle", "", "migrateSubTitle", "migrateButton", "cancelButton", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCancelButton", "()Ljava/lang/String;", "getMigrateButton", "getMigrateSubTitle", "getMigrateTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CPFCheckResp.kt */
public final class MigrateTipData {

    /* renamed from: a */
    private final String f33374a;

    /* renamed from: b */
    private final String f33375b;

    /* renamed from: c */
    private final String f33376c;

    /* renamed from: d */
    private final String f33377d;

    public static /* synthetic */ MigrateTipData copy$default(MigrateTipData migrateTipData, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = migrateTipData.f33374a;
        }
        if ((i & 2) != 0) {
            str2 = migrateTipData.f33375b;
        }
        if ((i & 4) != 0) {
            str3 = migrateTipData.f33376c;
        }
        if ((i & 8) != 0) {
            str4 = migrateTipData.f33377d;
        }
        return migrateTipData.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.f33374a;
    }

    public final String component2() {
        return this.f33375b;
    }

    public final String component3() {
        return this.f33376c;
    }

    public final String component4() {
        return this.f33377d;
    }

    public final MigrateTipData copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "migrateTitle");
        Intrinsics.checkNotNullParameter(str2, "migrateSubTitle");
        Intrinsics.checkNotNullParameter(str3, "migrateButton");
        Intrinsics.checkNotNullParameter(str4, "cancelButton");
        return new MigrateTipData(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MigrateTipData)) {
            return false;
        }
        MigrateTipData migrateTipData = (MigrateTipData) obj;
        return Intrinsics.areEqual((Object) this.f33374a, (Object) migrateTipData.f33374a) && Intrinsics.areEqual((Object) this.f33375b, (Object) migrateTipData.f33375b) && Intrinsics.areEqual((Object) this.f33376c, (Object) migrateTipData.f33376c) && Intrinsics.areEqual((Object) this.f33377d, (Object) migrateTipData.f33377d);
    }

    public int hashCode() {
        return (((((this.f33374a.hashCode() * 31) + this.f33375b.hashCode()) * 31) + this.f33376c.hashCode()) * 31) + this.f33377d.hashCode();
    }

    public String toString() {
        return "MigrateTipData(migrateTitle=" + this.f33374a + ", migrateSubTitle=" + this.f33375b + ", migrateButton=" + this.f33376c + ", cancelButton=" + this.f33377d + VersionRange.RIGHT_OPEN;
    }

    public MigrateTipData(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "migrateTitle");
        Intrinsics.checkNotNullParameter(str2, "migrateSubTitle");
        Intrinsics.checkNotNullParameter(str3, "migrateButton");
        Intrinsics.checkNotNullParameter(str4, "cancelButton");
        this.f33374a = str;
        this.f33375b = str2;
        this.f33376c = str3;
        this.f33377d = str4;
    }

    public final String getMigrateTitle() {
        return this.f33374a;
    }

    public final String getMigrateSubTitle() {
        return this.f33375b;
    }

    public final String getMigrateButton() {
        return this.f33376c;
    }

    public final String getCancelButton() {
        return this.f33377d;
    }
}
