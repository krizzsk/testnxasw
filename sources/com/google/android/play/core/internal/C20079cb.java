package com.google.android.play.core.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.internal.cb */
public abstract class C20079cb implements Closeable {
    /* renamed from: a */
    public abstract long mo164124a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract InputStream mo164125a(long j, long j2) throws IOException;

    /* renamed from: b */
    public synchronized InputStream mo164319b() throws IOException {
        return mo164125a(0, mo164124a());
    }
}
