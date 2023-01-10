package com.didi.soda.cart.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/soda/cart/model/CartGuideModel;", "", "()V", "guideParams", "", "", "getGuideParams", "()Ljava/util/Map;", "setGuideParams", "(Ljava/util/Map;)V", "itemId", "getItemId", "()Ljava/lang/String;", "setItemId", "(Ljava/lang/String;)V", "shopId", "getShopId", "setShopId", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CartGuideModel.kt */
public final class CartGuideModel {

    /* renamed from: a */
    private String f42611a = "";

    /* renamed from: b */
    private String f42612b = "";

    /* renamed from: c */
    private Map<String, Object> f42613c;

    public final String getShopId() {
        return this.f42611a;
    }

    public final void setShopId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f42611a = str;
    }

    public final String getItemId() {
        return this.f42612b;
    }

    public final void setItemId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f42612b = str;
    }

    public final Map<String, Object> getGuideParams() {
        return this.f42613c;
    }

    public final void setGuideParams(Map<String, Object> map) {
        this.f42613c = map;
    }
}
