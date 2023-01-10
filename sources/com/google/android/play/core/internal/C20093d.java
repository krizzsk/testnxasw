package com.google.android.play.core.internal;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* renamed from: com.google.android.play.core.internal.d */
final class C20093d implements C20077c {

    /* renamed from: a */
    private final FileChannel f56113a;

    /* renamed from: b */
    private final long f56114b;

    /* renamed from: c */
    private final long f56115c;

    public C20093d(FileChannel fileChannel, long j, long j2) {
        this.f56113a = fileChannel;
        this.f56114b = j;
        this.f56115c = j2;
    }

    /* renamed from: a */
    public final long mo164290a() {
        return this.f56115c;
    }

    /* renamed from: a */
    public final void mo164291a(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        MappedByteBuffer map = this.f56113a.map(FileChannel.MapMode.READ_ONLY, this.f56114b + j, (long) i);
        map.load();
        for (MessageDigest update : messageDigestArr) {
            map.position(0);
            update.update(map);
        }
    }
}
