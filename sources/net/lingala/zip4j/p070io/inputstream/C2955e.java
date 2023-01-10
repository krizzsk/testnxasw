package net.lingala.zip4j.p070io.inputstream;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: net.lingala.zip4j.io.inputstream.e */
/* compiled from: ZipEntryInputStream */
class C2955e extends InputStream {

    /* renamed from: a */
    private static final int f6728a = 15;

    /* renamed from: b */
    private InputStream f6729b;

    /* renamed from: c */
    private long f6730c = 0;

    /* renamed from: d */
    private byte[] f6731d = new byte[1];

    /* renamed from: e */
    private long f6732e;

    public C2955e(InputStream inputStream, long j) {
        this.f6729b = inputStream;
        this.f6732e = j;
    }

    public int read() throws IOException {
        if (read(this.f6731d) == -1) {
            return -1;
        }
        return this.f6731d[0];
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f6732e;
        if (j != -1) {
            long j2 = this.f6730c;
            if (j2 >= j) {
                return -1;
            }
            if (((long) i2) > j - j2) {
                i2 = (int) (j - j2);
            }
        }
        int read = this.f6729b.read(bArr, i, i2);
        if (read > 0) {
            this.f6730c += (long) read;
        }
        return read;
    }

    /* renamed from: a */
    public int mo29410a(byte[] bArr) throws IOException {
        int read = this.f6729b.read(bArr);
        if (read == bArr.length || (read = m6546a(bArr, read)) == bArr.length) {
            return read;
        }
        throw new IOException("Cannot read fully into byte buffer");
    }

    /* renamed from: a */
    private int m6546a(byte[] bArr, int i) throws IOException {
        int length = bArr.length - i;
        int i2 = 0;
        int i3 = 0;
        while (i < bArr.length && i2 != -1 && i3 < 15) {
            i2 += this.f6729b.read(bArr, i, length);
            if (i2 > 0) {
                i += i2;
                length -= i2;
            }
            i3++;
        }
        return i;
    }

    public void close() throws IOException {
        this.f6729b.close();
    }

    /* renamed from: a */
    public long mo29411a() {
        return this.f6730c;
    }
}
