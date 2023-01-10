package com.google.android.play.core.internal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.google.android.play.core.internal.b */
final class C20050b implements C20077c {

    /* renamed from: a */
    private final ByteBuffer f56095a;

    public C20050b(ByteBuffer byteBuffer) {
        this.f56095a = byteBuffer.slice();
    }

    /* renamed from: a */
    public final long mo164290a() {
        return (long) this.f56095a.capacity();
    }

    /* renamed from: a */
    public final void mo164291a(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        ByteBuffer slice;
        synchronized (this.f56095a) {
            int i2 = (int) j;
            this.f56095a.position(i2);
            this.f56095a.limit(i2 + i);
            slice = this.f56095a.slice();
        }
        for (MessageDigest update : messageDigestArr) {
            slice.position(0);
            update.update(slice);
        }
    }
}
