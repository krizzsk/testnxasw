package com.jumio.sdk.retry;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, mo148868d2 = {"Lcom/jumio/sdk/retry/JumioRetryReason;", "Ljava/io/Serializable;", "", "a", "I", "getCode", "()I", "code", "", "b", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(ILjava/lang/String;)V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: JumioRetryReason.kt */
public final class JumioRetryReason implements Serializable {

    /* renamed from: a */
    public final int f57969a;

    /* renamed from: b */
    public final String f57970b;

    public JumioRetryReason(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.f57969a = i;
        this.f57970b = str;
    }

    public final int getCode() {
        return this.f57969a;
    }

    public final String getMessage() {
        return this.f57970b;
    }
}
