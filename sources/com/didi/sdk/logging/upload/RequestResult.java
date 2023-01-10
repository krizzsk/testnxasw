package com.didi.sdk.logging.upload;

import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0019\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0005R\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\n\u001a\u0004\u0018\u00018\u00002\b\u0010\f\u001a\u0004\u0018\u00018\u0000@BX\u000e¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, mo148868d2 = {"Lcom/didi/sdk/logging/upload/RequestResult;", "T", "", "()V", "success", "", "code", "", "msg", "", "result", "(ZILjava/lang/String;Ljava/lang/Object;)V", "<set-?>", "getCode", "()I", "isSuccess", "()Z", "getMsg", "()Ljava/lang/String;", "getResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "setCode", "setMsg", "setResult", "(Ljava/lang/Object;)Lcom/didi/sdk/logging/upload/RequestResult;", "setSuccess", "api_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: RequestResult.kt */
public final class RequestResult<T> {

    /* renamed from: a */
    private boolean f39356a;

    /* renamed from: b */
    private int f39357b;

    /* renamed from: c */
    private String f39358c;

    /* renamed from: d */
    private T f39359d;

    public final boolean isSuccess() {
        return this.f39356a;
    }

    public final int getCode() {
        return this.f39357b;
    }

    public final String getMsg() {
        return this.f39358c;
    }

    public final T getResult() {
        return this.f39359d;
    }

    public RequestResult() {
    }

    public RequestResult(boolean z, int i, String str, T t) {
        this.f39356a = z;
        this.f39357b = i;
        this.f39358c = str;
        this.f39359d = t;
    }

    public final RequestResult<T> setSuccess(boolean z) {
        this.f39356a = z;
        return this;
    }

    public final RequestResult<T> setCode(int i) {
        this.f39357b = i;
        return this;
    }

    public final RequestResult<T> setMsg(String str) {
        this.f39358c = str;
        return this;
    }

    public final RequestResult<T> setResult(T t) {
        this.f39359d = t;
        return this;
    }
}
