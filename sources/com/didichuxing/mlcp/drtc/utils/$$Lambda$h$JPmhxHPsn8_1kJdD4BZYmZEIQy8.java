package com.didichuxing.mlcp.drtc.utils;

import com.didi.sdk.apm.SystemUtils;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.DataCallback;

/* renamed from: com.didichuxing.mlcp.drtc.utils.-$$Lambda$h$JPmhxHPsn8_1kJdD4BZYmZEIQy8  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$h$JPmhxHPsn8_1kJdD4BZYmZEIQy8 implements DataCallback {
    public static final /* synthetic */ $$Lambda$h$JPmhxHPsn8_1kJdD4BZYmZEIQy8 INSTANCE = new $$Lambda$h$JPmhxHPsn8_1kJdD4BZYmZEIQy8();

    private /* synthetic */ $$Lambda$h$JPmhxHPsn8_1kJdD4BZYmZEIQy8() {
    }

    public final void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        SystemUtils.log(3, C16725h.f51032a, "New Data", (Throwable) null, C16725h.f51032a, 44);
    }
}
