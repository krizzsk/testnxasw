package com.didi.payment.base.view.webview.util;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/payment/base/view/webview/util/Result;", "", "errno", "", "base64", "", "(ILjava/lang/String;)V", "getBase64", "()Ljava/lang/String;", "getErrno", "()I", "base_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ChooseFileHelper.kt */
public final class Result {

    /* renamed from: a */
    private final int f32525a;

    /* renamed from: b */
    private final String f32526b;

    public Result(int i, String str) {
        this.f32525a = i;
        this.f32526b = str;
    }

    public final String getBase64() {
        return this.f32526b;
    }

    public final int getErrno() {
        return this.f32525a;
    }
}
