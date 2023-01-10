package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bHÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006!"}, mo148868d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/RewardDialogInfo;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "title", "", "subTitle", "compensationStage", "", "btns", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/Btns;", "couponList", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/CouponInfo;", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "getBtns", "()Ljava/util/List;", "getCompensationStage", "()I", "getCouponList", "getSubTitle", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OrderInfoEntity.kt */
public final class RewardDialogInfo implements IEntity {
    private final List<Btns> btns;
    private final int compensationStage;
    private final List<CouponInfo> couponList;
    private final String subTitle;
    private final String title;

    public RewardDialogInfo() {
        this((String) null, (String) null, 0, (List) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RewardDialogInfo copy$default(RewardDialogInfo rewardDialogInfo, String str, String str2, int i, List<Btns> list, List<CouponInfo> list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rewardDialogInfo.title;
        }
        if ((i2 & 2) != 0) {
            str2 = rewardDialogInfo.subTitle;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            i = rewardDialogInfo.compensationStage;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            list = rewardDialogInfo.btns;
        }
        List<Btns> list3 = list;
        if ((i2 & 16) != 0) {
            list2 = rewardDialogInfo.couponList;
        }
        return rewardDialogInfo.copy(str, str3, i3, list3, list2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subTitle;
    }

    public final int component3() {
        return this.compensationStage;
    }

    public final List<Btns> component4() {
        return this.btns;
    }

    public final List<CouponInfo> component5() {
        return this.couponList;
    }

    public final RewardDialogInfo copy(String str, String str2, int i, List<Btns> list, List<CouponInfo> list2) {
        return new RewardDialogInfo(str, str2, i, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RewardDialogInfo)) {
            return false;
        }
        RewardDialogInfo rewardDialogInfo = (RewardDialogInfo) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) rewardDialogInfo.title) && Intrinsics.areEqual((Object) this.subTitle, (Object) rewardDialogInfo.subTitle) && this.compensationStage == rewardDialogInfo.compensationStage && Intrinsics.areEqual((Object) this.btns, (Object) rewardDialogInfo.btns) && Intrinsics.areEqual((Object) this.couponList, (Object) rewardDialogInfo.couponList);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subTitle;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.compensationStage) * 31;
        List<Btns> list = this.btns;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<CouponInfo> list2 = this.couponList;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "RewardDialogInfo(title=" + this.title + ", subTitle=" + this.subTitle + ", compensationStage=" + this.compensationStage + ", btns=" + this.btns + ", couponList=" + this.couponList + VersionRange.RIGHT_OPEN;
    }

    public RewardDialogInfo(String str, String str2, int i, List<Btns> list, List<CouponInfo> list2) {
        this.title = str;
        this.subTitle = str2;
        this.compensationStage = i;
        this.btns = list;
        this.couponList = list2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RewardDialogInfo(java.lang.String r5, java.lang.String r6, int r7, java.util.List r8, java.util.List r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0016
            r7 = 0
            r2 = 0
            goto L_0x0017
        L_0x0016:
            r2 = r7
        L_0x0017:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r8
        L_0x001e:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0024
            r10 = r0
            goto L_0x0025
        L_0x0024:
            r10 = r9
        L_0x0025:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.foundation.rpc.entity.order.RewardDialogInfo.<init>(java.lang.String, java.lang.String, int, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final int getCompensationStage() {
        return this.compensationStage;
    }

    public final List<Btns> getBtns() {
        return this.btns;
    }

    public final List<CouponInfo> getCouponList() {
        return this.couponList;
    }
}
