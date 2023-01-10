package com.pay99.diff_base.model;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, mo148868d2 = {"Lcom/pay99/diff_base/model/ReceiveCodeMsg;", "", "pushMsg", "", "(Ljava/lang/String;)V", "type", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getPushMsg", "()Ljava/lang/String;", "setPushMsg", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "diff-base_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ReceiveCodeMsg.kt */
public final class ReceiveCodeMsg {

    /* renamed from: a */
    private String f58573a;

    /* renamed from: b */
    private Integer f58574b;

    public final String getPushMsg() {
        return this.f58573a;
    }

    public final void setPushMsg(String str) {
        this.f58573a = str;
    }

    public final Integer getType() {
        return this.f58574b;
    }

    public final void setType(Integer num) {
        this.f58574b = num;
    }

    public ReceiveCodeMsg(String str) {
        this.f58573a = str;
    }

    public ReceiveCodeMsg(String str, Integer num) {
        this.f58573a = str;
        this.f58574b = num;
    }
}
