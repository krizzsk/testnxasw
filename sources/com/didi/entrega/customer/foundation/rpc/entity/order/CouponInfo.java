package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J[\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, mo148868d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/CouponInfo;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "name", "", "couponId", "expireTime", "couponAmountDisplay", "img", "couponType", "", "minCostDisplay", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getCouponAmountDisplay", "()Ljava/lang/String;", "getCouponId", "getCouponType", "()I", "getExpireTime", "getImg", "getMinCostDisplay", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OrderInfoEntity.kt */
public final class CouponInfo implements IEntity {
    private final String couponAmountDisplay;
    private final String couponId;
    private final int couponType;
    private final String expireTime;
    private final String img;
    private final String minCostDisplay;
    private final String name;

    public static /* synthetic */ CouponInfo copy$default(CouponInfo couponInfo, String str, String str2, String str3, String str4, String str5, int i, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = couponInfo.name;
        }
        if ((i2 & 2) != 0) {
            str2 = couponInfo.couponId;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = couponInfo.expireTime;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = couponInfo.couponAmountDisplay;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = couponInfo.img;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            i = couponInfo.couponType;
        }
        int i3 = i;
        if ((i2 & 64) != 0) {
            str6 = couponInfo.minCostDisplay;
        }
        return couponInfo.copy(str, str7, str8, str9, str10, i3, str6);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.couponId;
    }

    public final String component3() {
        return this.expireTime;
    }

    public final String component4() {
        return this.couponAmountDisplay;
    }

    public final String component5() {
        return this.img;
    }

    public final int component6() {
        return this.couponType;
    }

    public final String component7() {
        return this.minCostDisplay;
    }

    public final CouponInfo copy(String str, String str2, String str3, String str4, String str5, int i, String str6) {
        return new CouponInfo(str, str2, str3, str4, str5, i, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CouponInfo)) {
            return false;
        }
        CouponInfo couponInfo = (CouponInfo) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) couponInfo.name) && Intrinsics.areEqual((Object) this.couponId, (Object) couponInfo.couponId) && Intrinsics.areEqual((Object) this.expireTime, (Object) couponInfo.expireTime) && Intrinsics.areEqual((Object) this.couponAmountDisplay, (Object) couponInfo.couponAmountDisplay) && Intrinsics.areEqual((Object) this.img, (Object) couponInfo.img) && this.couponType == couponInfo.couponType && Intrinsics.areEqual((Object) this.minCostDisplay, (Object) couponInfo.minCostDisplay);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.couponId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.expireTime;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.couponAmountDisplay;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.img;
        int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.couponType) * 31;
        String str6 = this.minCostDisplay;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "CouponInfo(name=" + this.name + ", couponId=" + this.couponId + ", expireTime=" + this.expireTime + ", couponAmountDisplay=" + this.couponAmountDisplay + ", img=" + this.img + ", couponType=" + this.couponType + ", minCostDisplay=" + this.minCostDisplay + VersionRange.RIGHT_OPEN;
    }

    public CouponInfo(String str, String str2, String str3, String str4, String str5, int i, String str6) {
        this.name = str;
        this.couponId = str2;
        this.expireTime = str3;
        this.couponAmountDisplay = str4;
        this.img = str5;
        this.couponType = i;
        this.minCostDisplay = str6;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CouponInfo(String str, String str2, String str3, String str4, String str5, int i, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? 0 : i, str6);
    }

    public final String getName() {
        return this.name;
    }

    public final String getCouponId() {
        return this.couponId;
    }

    public final String getExpireTime() {
        return this.expireTime;
    }

    public final String getCouponAmountDisplay() {
        return this.couponAmountDisplay;
    }

    public final String getImg() {
        return this.img;
    }

    public final int getCouponType() {
        return this.couponType;
    }

    public final String getMinCostDisplay() {
        return this.minCostDisplay;
    }
}
