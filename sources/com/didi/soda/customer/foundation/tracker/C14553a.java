package com.didi.soda.customer.foundation.tracker;

import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/soda/customer/foundation/tracker/TraceInfo;", "", "tag", "", "begin", "", "duration", "", "stage", "(Ljava/lang/String;JII)V", "getBegin", "()J", "getDuration", "()I", "setDuration", "(I)V", "end", "getEnd", "setEnd", "(J)V", "getStage", "setStage", "getTag", "()Ljava/lang/String;", "toString", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.soda.customer.foundation.tracker.a */
/* compiled from: LaunchAppTracker.kt */
final class C14553a {

    /* renamed from: a */
    private final String f43688a;

    /* renamed from: b */
    private final long f43689b;

    /* renamed from: c */
    private int f43690c;

    /* renamed from: d */
    private int f43691d;

    /* renamed from: e */
    private long f43692e;

    public C14553a(String str, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        this.f43688a = str;
        this.f43689b = j;
        this.f43690c = i;
        this.f43691d = i2;
    }

    /* renamed from: a */
    public final String mo111325a() {
        return this.f43688a;
    }

    /* renamed from: b */
    public final long mo111328b() {
        return this.f43689b;
    }

    /* renamed from: a */
    public final void mo111326a(int i) {
        this.f43690c = i;
    }

    /* renamed from: c */
    public final int mo111330c() {
        return this.f43690c;
    }

    /* renamed from: b */
    public final void mo111329b(int i) {
        this.f43691d = i;
    }

    /* renamed from: d */
    public final int mo111331d() {
        return this.f43691d;
    }

    /* renamed from: a */
    public final void mo111327a(long j) {
        this.f43692e = j;
    }

    /* renamed from: e */
    public final long mo111332e() {
        return this.f43692e;
    }

    public String toString() {
        if (!LaunchAppTrackerKt.f43676a) {
            return super.toString();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss SSS");
        return "tag = " + this.f43688a + " beginTime = " + simpleDateFormat.format(new Date(this.f43689b)) + " duration = " + this.f43690c + " stage=" + this.f43691d;
    }
}
