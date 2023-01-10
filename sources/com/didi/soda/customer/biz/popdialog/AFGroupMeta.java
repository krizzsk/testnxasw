package com.didi.soda.customer.biz.popdialog;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, mo148868d2 = {"Lcom/didi/soda/customer/biz/popdialog/AFGroupMeta;", "", "groupId", "", "source", "(Ljava/lang/String;Ljava/lang/String;)V", "getGroupId", "()Ljava/lang/String;", "getSource", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AFGroupIdManager.kt */
public final class AFGroupMeta {

    /* renamed from: a */
    private final String f43047a;

    /* renamed from: b */
    private final String f43048b;

    public AFGroupMeta(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "groupId");
        Intrinsics.checkNotNullParameter(str2, "source");
        this.f43047a = str;
        this.f43048b = str2;
    }

    public final String getGroupId() {
        return this.f43047a;
    }

    public final String getSource() {
        return this.f43048b;
    }
}
