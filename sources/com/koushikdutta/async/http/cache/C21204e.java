package com.koushikdutta.async.http.cache;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.koushikdutta.async.util.Charsets;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* renamed from: com.koushikdutta.async.http.cache.e */
/* compiled from: StrictLineReader */
class C21204e implements Closeable {

    /* renamed from: a */
    private static final byte f58241a = 13;

    /* renamed from: b */
    private static final byte f58242b = 10;

    /* renamed from: c */
    private final InputStream f58243c;

    /* renamed from: d */
    private byte[] f58244d;

    /* renamed from: e */
    private int f58245e;

    /* renamed from: f */
    private int f58246f;

    public C21204e(InputStream inputStream) {
        this(inputStream, 8192);
    }

    public C21204e(InputStream inputStream, int i) {
        this(inputStream, i, Charsets.US_ASCII);
    }

    public C21204e(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public C21204e(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null) {
            throw new NullPointerException("in == null");
        } else if (charset == null) {
            throw new NullPointerException("charset == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(Charsets.US_ASCII) || charset.equals(Charsets.UTF_8)) {
            this.f58243c = inputStream;
            this.f58244d = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f58243c) {
            if (this.f58244d != null) {
                this.f58244d = null;
                this.f58243c.close();
            }
        }
    }

    /* renamed from: a */
    public String mo173689a() throws IOException {
        int i;
        int i2;
        synchronized (this.f58243c) {
            if (this.f58244d != null) {
                if (this.f58245e >= this.f58246f) {
                    m44173d();
                }
                for (int i3 = this.f58245e; i3 != this.f58246f; i3++) {
                    if (this.f58244d[i3] == 10) {
                        if (i3 != this.f58245e) {
                            i2 = i3 - 1;
                            if (this.f58244d[i2] == 13) {
                                String str = new String(this.f58244d, this.f58245e, i2 - this.f58245e);
                                this.f58245e = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f58244d, this.f58245e, i2 - this.f58245e);
                        this.f58245e = i3 + 1;
                        return str2;
                    }
                }
                StrictLineReader$1 strictLineReader$1 = new StrictLineReader$1(this, (this.f58246f - this.f58245e) + 80);
                loop1:
                while (true) {
                    strictLineReader$1.write(this.f58244d, this.f58245e, this.f58246f - this.f58245e);
                    this.f58246f = -1;
                    m44173d();
                    i = this.f58245e;
                    while (true) {
                        if (i != this.f58246f) {
                            if (this.f58244d[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                if (i != this.f58245e) {
                    strictLineReader$1.write(this.f58244d, this.f58245e, i - this.f58245e);
                }
                this.f58245e = i + 1;
                String byteArrayOutputStream = strictLineReader$1.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    /* renamed from: b */
    public int mo173690b() throws IOException {
        String a = mo173689a();
        try {
            return Integer.parseInt(a);
        } catch (NumberFormatException unused) {
            throw new IOException("expected an int but was \"" + a + Const.jsQuote);
        }
    }

    /* renamed from: c */
    public boolean mo173691c() {
        return this.f58246f == -1;
    }

    /* renamed from: d */
    private void m44173d() throws IOException {
        InputStream inputStream = this.f58243c;
        byte[] bArr = this.f58244d;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f58245e = 0;
            this.f58246f = read;
            return;
        }
        throw new EOFException();
    }
}
