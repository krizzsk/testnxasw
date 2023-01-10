package com.didi.global.fintech.cashier.model.net.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006&"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/OrderInfo;", "Ljava/io/Serializable;", "appId", "", "orderId", "productId", "sequenceId", "outTradeId", "returnUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getOrderId", "setOrderId", "getOutTradeId", "setOutTradeId", "getProductId", "setProductId", "getReturnUrl", "setReturnUrl", "getSequenceId", "setSequenceId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PayInfoResponse.kt */
public final class OrderInfo implements Serializable {
    @SerializedName("app_id")
    private String appId;
    @SerializedName("order_id")
    private String orderId;
    @SerializedName("out_trade_id")
    private String outTradeId;
    @SerializedName("product_id")
    private String productId;
    @SerializedName("return_url")
    private String returnUrl;
    @SerializedName("biz_cashier_unique_id")
    private String sequenceId;

    public OrderInfo() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderInfo copy$default(OrderInfo orderInfo, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderInfo.appId;
        }
        if ((i & 2) != 0) {
            str2 = orderInfo.orderId;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = orderInfo.productId;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = orderInfo.sequenceId;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = orderInfo.outTradeId;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = orderInfo.returnUrl;
        }
        return orderInfo.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.orderId;
    }

    public final String component3() {
        return this.productId;
    }

    public final String component4() {
        return this.sequenceId;
    }

    public final String component5() {
        return this.outTradeId;
    }

    public final String component6() {
        return this.returnUrl;
    }

    public final OrderInfo copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new OrderInfo(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderInfo)) {
            return false;
        }
        OrderInfo orderInfo = (OrderInfo) obj;
        return Intrinsics.areEqual((Object) this.appId, (Object) orderInfo.appId) && Intrinsics.areEqual((Object) this.orderId, (Object) orderInfo.orderId) && Intrinsics.areEqual((Object) this.productId, (Object) orderInfo.productId) && Intrinsics.areEqual((Object) this.sequenceId, (Object) orderInfo.sequenceId) && Intrinsics.areEqual((Object) this.outTradeId, (Object) orderInfo.outTradeId) && Intrinsics.areEqual((Object) this.returnUrl, (Object) orderInfo.returnUrl);
    }

    public int hashCode() {
        String str = this.appId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.orderId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.productId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sequenceId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.outTradeId;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.returnUrl;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "OrderInfo(appId=" + this.appId + ", orderId=" + this.orderId + ", productId=" + this.productId + ", sequenceId=" + this.sequenceId + ", outTradeId=" + this.outTradeId + ", returnUrl=" + this.returnUrl + VersionRange.RIGHT_OPEN;
    }

    public OrderInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this.appId = str;
        this.orderId = str2;
        this.productId = str3;
        this.sequenceId = str4;
        this.outTradeId = str5;
        this.returnUrl = str6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderInfo(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.response.OrderInfo.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getAppId() {
        return this.appId;
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final void setProductId(String str) {
        this.productId = str;
    }

    public final String getSequenceId() {
        return this.sequenceId;
    }

    public final void setSequenceId(String str) {
        this.sequenceId = str;
    }

    public final String getOutTradeId() {
        return this.outTradeId;
    }

    public final void setOutTradeId(String str) {
        this.outTradeId = str;
    }

    public final String getReturnUrl() {
        return this.returnUrl;
    }

    public final void setReturnUrl(String str) {
        this.returnUrl = str;
    }
}
