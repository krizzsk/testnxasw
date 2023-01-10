package com.didi.map.global.sctx.event_reveal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/map/global/sctx/event_reveal/TrafficEventsDuplicateVerifyException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TrafficEventsDuplicateVerifyException.kt */
public final class TrafficEventsDuplicateVerifyException extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrafficEventsDuplicateVerifyException(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "message");
    }
}
