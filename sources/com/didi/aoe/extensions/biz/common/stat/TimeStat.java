package com.didi.aoe.extensions.biz.common.stat;

import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0011R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/aoe/extensions/biz/common/stat/TimeStat;", "", "tag", "", "(Ljava/lang/String;)V", "<set-?>", "", "avgTimeInMills", "getAvgTimeInMills", "()J", "count", "mLogger", "Lcom/didi/aoe/library/logging/Logger;", "timeTotal", "timestamp", "markEnd", "markStart", "", "features-biz-common_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: TimeStat.kt */
public final class TimeStat {

    /* renamed from: a */
    private final Logger f9970a;

    /* renamed from: b */
    private long f9971b;

    /* renamed from: c */
    private long f9972c;

    /* renamed from: d */
    private long f9973d;

    /* renamed from: e */
    private long f9974e;

    /* renamed from: f */
    private final String f9975f;

    public TimeStat(String str) {
        Intrinsics.checkParameterIsNotNull(str, "tag");
        this.f9975f = str;
        Logger logger = LoggerFactory.getLogger("TimeStat");
        Intrinsics.checkExpressionValueIsNotNull(logger, "LoggerFactory.getLogger(\"TimeStat\")");
        this.f9970a = logger;
    }

    public final long getAvgTimeInMills() {
        return this.f9974e;
    }

    public final void markStart() {
        this.f9973d = System.currentTimeMillis();
    }

    public final long markEnd() {
        long currentTimeMillis = System.currentTimeMillis() - this.f9973d;
        long j = this.f9972c + currentTimeMillis;
        this.f9972c = j;
        long j2 = this.f9971b + 1;
        this.f9971b = j2;
        this.f9974e = j / j2;
        return currentTimeMillis;
    }
}
