package com.didi.dimina.webview.webview.mina.disklrucache;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* renamed from: com.didi.dimina.webview.webview.mina.disklrucache.a */
/* compiled from: StrictLineReader */
class C8412a implements Closeable {

    /* renamed from: a */
    private static final byte f20337a = 13;

    /* renamed from: b */
    private static final byte f20338b = 10;

    /* renamed from: c */
    private final InputStream f20339c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Charset f20340d;

    /* renamed from: e */
    private byte[] f20341e;

    /* renamed from: f */
    private int f20342f;

    /* renamed from: g */
    private int f20343g;

    public C8412a(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public C8412a(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(C8413b.f20344a)) {
            this.f20339c = inputStream;
            this.f20340d = charset;
            this.f20341e = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f20339c) {
            if (this.f20341e != null) {
                this.f20341e = null;
                this.f20339c.close();
            }
        }
    }

    /* renamed from: a */
    public String mo63072a() throws IOException {
        int i;
        int i2;
        synchronized (this.f20339c) {
            if (this.f20341e != null) {
                if (this.f20342f >= this.f20343g) {
                    m17139c();
                }
                for (int i3 = this.f20342f; i3 != this.f20343g; i3++) {
                    if (this.f20341e[i3] == 10) {
                        if (i3 != this.f20342f) {
                            i2 = i3 - 1;
                            if (this.f20341e[i2] == 13) {
                                String str = new String(this.f20341e, this.f20342f, i2 - this.f20342f, this.f20340d.name());
                                this.f20342f = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f20341e, this.f20342f, i2 - this.f20342f, this.f20340d.name());
                        this.f20342f = i3 + 1;
                        return str2;
                    }
                }
                StrictLineReader$1 strictLineReader$1 = new StrictLineReader$1(this, (this.f20343g - this.f20342f) + 80);
                loop1:
                while (true) {
                    strictLineReader$1.write(this.f20341e, this.f20342f, this.f20343g - this.f20342f);
                    this.f20343g = -1;
                    m17139c();
                    i = this.f20342f;
                    while (true) {
                        if (i != this.f20343g) {
                            if (this.f20341e[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                if (i != this.f20342f) {
                    strictLineReader$1.write(this.f20341e, this.f20342f, i - this.f20342f);
                }
                this.f20342f = i + 1;
                String byteArrayOutputStream = strictLineReader$1.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    /* renamed from: b */
    public boolean mo63073b() {
        return this.f20343g == -1;
    }

    /* renamed from: c */
    private void m17139c() throws IOException {
        InputStream inputStream = this.f20339c;
        byte[] bArr = this.f20341e;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f20342f = 0;
            this.f20343g = read;
            return;
        }
        throw new EOFException();
    }
}
