package com.lyft.kronos.internal.ntp;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo148868d2 = {"Lcom/lyft/kronos/internal/ntp/NTPSyncException;", "Ljava/lang/RuntimeException;", "message", "", "(Ljava/lang/String;)V", "kronos-java"}, mo148869k = 1, mo148870mv = {1, 4, 0})
/* compiled from: NTPSyncException.kt */
public final class NTPSyncException extends RuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NTPSyncException(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "message");
    }
}
