package com.pay99.diff_base.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, mo148868d2 = {"Lcom/pay99/diff_base/model/WalletPushInfo;", "", "content", "", "source", "", "(Ljava/lang/String;I)V", "()V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getSource", "()I", "setSource", "(I)V", "diff-base_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletPushInfo.kt */
public final class WalletPushInfo {

    /* renamed from: a */
    private String f58575a;

    /* renamed from: b */
    private int f58576b;

    public WalletPushInfo() {
        this.f58575a = "";
        this.f58576b = 1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletPushInfo(String str, int i) {
        this();
        Intrinsics.checkNotNullParameter(str, "content");
        this.f58575a = str;
        this.f58576b = i;
    }

    public final String getContent() {
        return this.f58575a;
    }

    public final void setContent(String str) {
        this.f58575a = str;
    }

    public final int getSource() {
        return this.f58576b;
    }

    public final void setSource(int i) {
        this.f58576b = i;
    }
}
