package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 +2\u00020\u0001:\u0001+Bk\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\rHÆ\u0003Jo\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006,"}, mo148868d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderBtns;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "name", "", "content", "disable", "", "action", "phone", "alert", "url", "type", "data", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/RewardDialogInfo;", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/didi/entrega/customer/foundation/rpc/entity/order/RewardDialogInfo;)V", "getAction", "()I", "getAlert", "()Ljava/lang/String;", "getContent", "getData", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/RewardDialogInfo;", "getDisable", "getName", "getPhone", "getType", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OrderInfoEntity.kt */
public final class OrderBtns implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -4048978961923802903L;
    private final int action;
    private final String alert;
    private final String content;
    private final RewardDialogInfo data;
    private final int disable;
    private final String name;
    private final String phone;
    private final int type;
    private final String url;

    public OrderBtns() {
        this((String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, 0, (RewardDialogInfo) null, 511, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderBtns copy$default(OrderBtns orderBtns, String str, String str2, int i, int i2, String str3, String str4, String str5, int i3, RewardDialogInfo rewardDialogInfo, int i4, Object obj) {
        OrderBtns orderBtns2 = orderBtns;
        int i5 = i4;
        return orderBtns.copy((i5 & 1) != 0 ? orderBtns2.name : str, (i5 & 2) != 0 ? orderBtns2.content : str2, (i5 & 4) != 0 ? orderBtns2.disable : i, (i5 & 8) != 0 ? orderBtns2.action : i2, (i5 & 16) != 0 ? orderBtns2.phone : str3, (i5 & 32) != 0 ? orderBtns2.alert : str4, (i5 & 64) != 0 ? orderBtns2.url : str5, (i5 & 128) != 0 ? orderBtns2.type : i3, (i5 & 256) != 0 ? orderBtns2.data : rewardDialogInfo);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.content;
    }

    public final int component3() {
        return this.disable;
    }

    public final int component4() {
        return this.action;
    }

    public final String component5() {
        return this.phone;
    }

    public final String component6() {
        return this.alert;
    }

    public final String component7() {
        return this.url;
    }

    public final int component8() {
        return this.type;
    }

    public final RewardDialogInfo component9() {
        return this.data;
    }

    public final OrderBtns copy(String str, String str2, int i, int i2, String str3, String str4, String str5, int i3, RewardDialogInfo rewardDialogInfo) {
        return new OrderBtns(str, str2, i, i2, str3, str4, str5, i3, rewardDialogInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderBtns)) {
            return false;
        }
        OrderBtns orderBtns = (OrderBtns) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) orderBtns.name) && Intrinsics.areEqual((Object) this.content, (Object) orderBtns.content) && this.disable == orderBtns.disable && this.action == orderBtns.action && Intrinsics.areEqual((Object) this.phone, (Object) orderBtns.phone) && Intrinsics.areEqual((Object) this.alert, (Object) orderBtns.alert) && Intrinsics.areEqual((Object) this.url, (Object) orderBtns.url) && this.type == orderBtns.type && Intrinsics.areEqual((Object) this.data, (Object) orderBtns.data);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.content;
        int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.disable) * 31) + this.action) * 31;
        String str3 = this.phone;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.alert;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.url;
        int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.type) * 31;
        RewardDialogInfo rewardDialogInfo = this.data;
        if (rewardDialogInfo != null) {
            i = rewardDialogInfo.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "OrderBtns(name=" + this.name + ", content=" + this.content + ", disable=" + this.disable + ", action=" + this.action + ", phone=" + this.phone + ", alert=" + this.alert + ", url=" + this.url + ", type=" + this.type + ", data=" + this.data + VersionRange.RIGHT_OPEN;
    }

    public OrderBtns(String str, String str2, int i, int i2, String str3, String str4, String str5, int i3, RewardDialogInfo rewardDialogInfo) {
        this.name = str;
        this.content = str2;
        this.disable = i;
        this.action = i2;
        this.phone = str3;
        this.alert = str4;
        this.url = str5;
        this.type = i3;
        this.data = rewardDialogInfo;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderBtns(java.lang.String r12, java.lang.String r13, int r14, int r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, int r19, com.didi.entrega.customer.foundation.rpc.entity.order.RewardDialogInfo r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r11 = this;
            r0 = r21
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r13
        L_0x0011:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x0019
        L_0x0018:
            r4 = r14
        L_0x0019:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x001f
            r6 = 0
            goto L_0x0020
        L_0x001f:
            r6 = r15
        L_0x0020:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0026
            r7 = r2
            goto L_0x0028
        L_0x0026:
            r7 = r16
        L_0x0028:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x002e
            r8 = r2
            goto L_0x0030
        L_0x002e:
            r8 = r17
        L_0x0030:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0036
            r9 = r2
            goto L_0x0038
        L_0x0036:
            r9 = r18
        L_0x0038:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r5 = r19
        L_0x003f:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r2 = r20
        L_0x0046:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r5
            r21 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.foundation.rpc.entity.order.OrderBtns.<init>(java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.String, int, com.didi.entrega.customer.foundation.rpc.entity.order.RewardDialogInfo, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getName() {
        return this.name;
    }

    public final String getContent() {
        return this.content;
    }

    public final int getDisable() {
        return this.disable;
    }

    public final int getAction() {
        return this.action;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getAlert() {
        return this.alert;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getType() {
        return this.type;
    }

    public final RewardDialogInfo getData() {
        return this.data;
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderBtns$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: OrderInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
