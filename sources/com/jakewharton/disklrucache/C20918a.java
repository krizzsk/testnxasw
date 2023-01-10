package com.jakewharton.disklrucache;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* renamed from: com.jakewharton.disklrucache.a */
/* compiled from: StrictLineReader */
class C20918a implements Closeable {

    /* renamed from: a */
    private static final byte f57331a = 13;

    /* renamed from: b */
    private static final byte f57332b = 10;

    /* renamed from: c */
    private final InputStream f57333c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Charset f57334d;

    /* renamed from: e */
    private byte[] f57335e;

    /* renamed from: f */
    private int f57336f;

    /* renamed from: g */
    private int f57337g;

    public C20918a(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public C20918a(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(C20919b.f57338a)) {
            this.f57333c = inputStream;
            this.f57334d = charset;
            this.f57335e = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f57333c) {
            if (this.f57335e != null) {
                this.f57335e = null;
                this.f57333c.close();
            }
        }
    }

    /* renamed from: a */
    public String mo171657a() throws IOException {
        int i;
        int i2;
        synchronized (this.f57333c) {
            if (this.f57335e != null) {
                if (this.f57336f >= this.f57337g) {
                    m43602c();
                }
                for (int i3 = this.f57336f; i3 != this.f57337g; i3++) {
                    if (this.f57335e[i3] == 10) {
                        if (i3 != this.f57336f) {
                            i2 = i3 - 1;
                            if (this.f57335e[i2] == 13) {
                                String str = new String(this.f57335e, this.f57336f, i2 - this.f57336f, this.f57334d.name());
                                this.f57336f = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f57335e, this.f57336f, i2 - this.f57336f, this.f57334d.name());
                        this.f57336f = i3 + 1;
                        return str2;
                    }
                }
                StrictLineReader$1 strictLineReader$1 = new StrictLineReader$1(this, (this.f57337g - this.f57336f) + 80);
                loop1:
                while (true) {
                    strictLineReader$1.write(this.f57335e, this.f57336f, this.f57337g - this.f57336f);
                    this.f57337g = -1;
                    m43602c();
                    i = this.f57336f;
                    while (true) {
                        if (i != this.f57337g) {
                            if (this.f57335e[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                if (i != this.f57336f) {
                    strictLineReader$1.write(this.f57335e, this.f57336f, i - this.f57336f);
                }
                this.f57336f = i + 1;
                String byteArrayOutputStream = strictLineReader$1.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    /* renamed from: b */
    public boolean mo171658b() {
        return this.f57337g == -1;
    }

    /* renamed from: c */
    private void m43602c() throws IOException {
        InputStream inputStream = this.f57333c;
        byte[] bArr = this.f57335e;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f57336f = 0;
            this.f57337g = read;
            return;
        }
        throw new EOFException();
    }
}
