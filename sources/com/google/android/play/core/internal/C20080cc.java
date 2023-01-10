package com.google.android.play.core.internal;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.internal.cc */
public final class C20080cc extends C20079cb {

    /* renamed from: a */
    private final C20079cb f56101a;

    /* renamed from: b */
    private final long f56102b;

    /* renamed from: c */
    private final long f56103c;

    public C20080cc(C20079cb cbVar, long j, long j2) {
        this.f56101a = cbVar;
        long a = m42273a(j);
        this.f56102b = a;
        this.f56103c = m42273a(a + j2);
    }

    /* renamed from: a */
    private final long m42273a(long j) {
        if (j < 0) {
            return 0;
        }
        return j > this.f56101a.mo164124a() ? this.f56101a.mo164124a() : j;
    }

    /* renamed from: a */
    public final long mo164124a() {
        return this.f56103c - this.f56102b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final InputStream mo164125a(long j, long j2) throws IOException {
        long a = m42273a(this.f56102b);
        return this.f56101a.mo164125a(a, m42273a(j2 + a) - a);
    }

    public final void close() throws IOException {
    }
}
