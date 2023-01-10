package com.didi.global.fintech.cashier.user.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0016R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0017"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/user/model/FastPayParam;", "Ljava/io/Serializable;", "()V", "omegaAttrs", "", "", "", "getOmegaAttrs", "()Ljava/util/Map;", "setOmegaAttrs", "(Ljava/util/Map;)V", "orderPageTitle", "getOrderPageTitle", "()Ljava/lang/String;", "setOrderPageTitle", "(Ljava/lang/String;)V", "outTradeId", "getOutTradeId", "setOutTradeId", "productId", "getProductId", "setProductId", "toString", "cashier_user_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FastPayParam.kt */
public final class FastPayParam implements Serializable {
    private Map<String, Object> omegaAttrs = new LinkedHashMap();
    private String orderPageTitle;
    private String outTradeId;
    private String productId;

    public final String getOrderPageTitle() {
        return this.orderPageTitle;
    }

    public final void setOrderPageTitle(String str) {
        this.orderPageTitle = str;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final void setProductId(String str) {
        this.productId = str;
    }

    public final String getOutTradeId() {
        return this.outTradeId;
    }

    public final void setOutTradeId(String str) {
        this.outTradeId = str;
    }

    public final Map<String, Object> getOmegaAttrs() {
        return this.omegaAttrs;
    }

    public final void setOmegaAttrs(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.omegaAttrs = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringsKt.appendln(sb);
        sb.append(Intrinsics.stringPlus("productId:", this.productId));
        Intrinsics.checkNotNullExpressionValue(sb, "sb.append(\"productId:$productId\")");
        StringsKt.appendln(sb);
        sb.append(Intrinsics.stringPlus("outTradeId:", this.outTradeId));
        Intrinsics.checkNotNullExpressionValue(sb, "sb.append(\"outTradeId:$outTradeId\")");
        StringsKt.appendln(sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
