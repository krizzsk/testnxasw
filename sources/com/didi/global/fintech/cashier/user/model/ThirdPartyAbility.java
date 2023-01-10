package com.didi.global.fintech.cashier.user.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/user/model/ThirdPartyAbility;", "Ljava/io/Serializable;", "virtual_3ds_sdk_version", "", "(Ljava/lang/String;)V", "getVirtual_3ds_sdk_version", "()Ljava/lang/String;", "setVirtual_3ds_sdk_version", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_user_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FastPayCashierEnv.kt */
public final class ThirdPartyAbility implements Serializable {
    private String virtual_3ds_sdk_version;

    public ThirdPartyAbility() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ThirdPartyAbility copy$default(ThirdPartyAbility thirdPartyAbility, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = thirdPartyAbility.virtual_3ds_sdk_version;
        }
        return thirdPartyAbility.copy(str);
    }

    public final String component1() {
        return this.virtual_3ds_sdk_version;
    }

    public final ThirdPartyAbility copy(String str) {
        return new ThirdPartyAbility(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ThirdPartyAbility) && Intrinsics.areEqual((Object) this.virtual_3ds_sdk_version, (Object) ((ThirdPartyAbility) obj).virtual_3ds_sdk_version);
    }

    public int hashCode() {
        String str = this.virtual_3ds_sdk_version;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "ThirdPartyAbility(virtual_3ds_sdk_version=" + this.virtual_3ds_sdk_version + VersionRange.RIGHT_OPEN;
    }

    public ThirdPartyAbility(String str) {
        this.virtual_3ds_sdk_version = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ThirdPartyAbility(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "1.1" : str);
    }

    public final String getVirtual_3ds_sdk_version() {
        return this.virtual_3ds_sdk_version;
    }

    public final void setVirtual_3ds_sdk_version(String str) {
        this.virtual_3ds_sdk_version = str;
    }
}
