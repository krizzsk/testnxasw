package com.google.android.play.core.assetpacks;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.assetpacks.bd */
final class C19919bd extends InputStream {

    /* renamed from: a */
    private final InputStream f55735a;

    /* renamed from: b */
    private long f55736b;

    C19919bd(InputStream inputStream, long j) {
        this.f55735a = inputStream;
        this.f55736b = j;
    }

    public final void close() throws IOException {
        super.close();
        this.f55735a.close();
        this.f55736b = 0;
    }

    public final int read() throws IOException {
        long j = this.f55736b;
        if (j <= 0) {
            return -1;
        }
        this.f55736b = j - 1;
        return this.f55735a.read();
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f55736b;
        if (j <= 0) {
            return -1;
        }
        int read = this.f55735a.read(bArr, i, (int) Math.min((long) i2, j));
        if (read != -1) {
            this.f55736b -= (long) read;
        }
        return read;
    }
}
