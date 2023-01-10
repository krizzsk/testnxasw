package com.google.android.play.core.assetpacks;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.google.android.play.core.assetpacks.bm */
final class C19928bm extends FilterInputStream {

    /* renamed from: a */
    private final C19973dd f55759a = new C19973dd();

    /* renamed from: b */
    private byte[] f55760b = new byte[4096];

    /* renamed from: c */
    private long f55761c;

    /* renamed from: d */
    private boolean f55762d = false;

    /* renamed from: e */
    private boolean f55763e = false;

    C19928bm(InputStream inputStream) {
        super(inputStream);
    }

    /* renamed from: a */
    private final int m41926a(byte[] bArr, int i, int i2) throws IOException {
        return Math.max(0, super.read(bArr, i, i2));
    }

    /* renamed from: a */
    private final boolean m41927a(int i) throws IOException {
        int a = m41926a(this.f55760b, 0, i);
        if (a != i) {
            int i2 = i - a;
            if (m41926a(this.f55760b, a, i2) != i2) {
                this.f55759a.mo164192a(this.f55760b, 0, a);
                return false;
            }
        }
        this.f55759a.mo164192a(this.f55760b, 0, i);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C19993dx mo164140a() throws IOException {
        byte[] bArr;
        if (this.f55761c > 0) {
            do {
                bArr = this.f55760b;
            } while (read(bArr, 0, bArr.length) != -1);
        }
        if (this.f55762d || this.f55763e) {
            return new C19993dx((String) null, -1, -1, false, false, (byte[]) null);
        }
        if (!m41927a(30)) {
            this.f55762d = true;
            return this.f55759a.mo164193a();
        }
        C19993dx a = this.f55759a.mo164193a();
        if (a.mo164231g()) {
            this.f55763e = true;
            return a;
        } else if (a.mo164227d() != InternalZipConstants.ZIP_64_SIZE_LIMIT) {
            int b = this.f55759a.mo164194b() - 30;
            long j = (long) b;
            int length = this.f55760b.length;
            if (j > ((long) length)) {
                do {
                    length += length;
                } while (((long) length) < j);
                this.f55760b = Arrays.copyOf(this.f55760b, length);
            }
            if (!m41927a(b)) {
                this.f55762d = true;
                return this.f55759a.mo164193a();
            }
            C19993dx a2 = this.f55759a.mo164193a();
            this.f55761c = a2.mo164227d();
            return a2;
        } else {
            throw new C19937bv("Files bigger than 4GiB are not supported.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo164141b() {
        return this.f55762d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final boolean mo164142c() {
        return this.f55763e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final long mo164143d() {
        return this.f55761c;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f55761c;
        if (j <= 0 || this.f55762d) {
            return -1;
        }
        int a = m41926a(bArr, i, (int) Math.min(j, (long) i2));
        this.f55761c -= (long) a;
        if (a != 0) {
            return a;
        }
        this.f55762d = true;
        return 0;
    }
}
