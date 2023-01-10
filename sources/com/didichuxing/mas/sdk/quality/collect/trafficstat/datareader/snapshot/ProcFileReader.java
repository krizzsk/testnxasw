package com.didichuxing.mas.sdk.quality.collect.trafficstat.datareader.snapshot;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.nio.charset.Charset;

public class ProcFileReader implements Closeable {

    /* renamed from: a */
    private final InputStream f50806a;

    /* renamed from: b */
    private final byte[] f50807b;

    /* renamed from: c */
    private int f50808c;

    /* renamed from: d */
    private boolean f50809d;

    public ProcFileReader(InputStream inputStream) throws IOException {
        this(inputStream, 4096);
    }

    public ProcFileReader(InputStream inputStream, int i) throws IOException {
        this.f50806a = inputStream;
        this.f50807b = new byte[i];
        m37825a();
    }

    /* renamed from: a */
    private int m37825a() throws IOException {
        byte[] bArr = this.f50807b;
        int length = bArr.length;
        int i = this.f50808c;
        int i2 = length - i;
        if (i2 != 0) {
            int read = this.f50806a.read(bArr, i, i2);
            if (read != -1) {
                this.f50808c += read;
            }
            return read;
        }
        throw new IOException("attempting to fill already-full buffer");
    }

    /* renamed from: a */
    private void m37826a(int i) throws IOException {
        byte[] bArr = this.f50807b;
        System.arraycopy(bArr, i, bArr, 0, this.f50808c - i);
        int i2 = this.f50808c - i;
        this.f50808c = i2;
        if (i2 == 0) {
            m37825a();
        }
    }

    /* renamed from: b */
    private int m37827b() throws IOException {
        if (this.f50809d) {
            return -1;
        }
        int i = 0;
        while (true) {
            if (i < this.f50808c) {
                byte b = this.f50807b[i];
                if (b == 10) {
                    this.f50809d = true;
                    return i;
                } else if (b == 32) {
                    return i;
                } else {
                    i++;
                }
            } else if (m37825a() <= 0) {
                throw new ProtocolException("End of stream while looking for token boundary");
            }
        }
    }

    public boolean hasMoreData() {
        return this.f50808c > 0;
    }

    public void finishLine() throws IOException {
        int i = 0;
        if (this.f50809d) {
            this.f50809d = false;
            return;
        }
        while (true) {
            if (i < this.f50808c) {
                if (this.f50807b[i] == 10) {
                    m37826a(i + 1);
                    return;
                }
                i++;
            } else if (m37825a() <= 0) {
                throw new ProtocolException("End of stream while looking for line boundary");
            }
        }
    }

    public String nextString() throws IOException {
        int b = m37827b();
        if (b != -1) {
            return m37828b(b);
        }
        throw new ProtocolException("Missing required string");
    }

    public long nextLong() throws IOException {
        int b = m37827b();
        if (b != -1) {
            return m37829c(b);
        }
        throw new ProtocolException("Missing required long");
    }

    public long nextOptionalLong(long j) throws IOException {
        int b = m37827b();
        if (b == -1) {
            return j;
        }
        return m37829c(b);
    }

    /* renamed from: b */
    private String m37828b(int i) throws IOException {
        String str = new String(this.f50807b, 0, i, Charset.forName("US-ASCII"));
        m37826a(i + 1);
        return str;
    }

    /* renamed from: c */
    private long m37829c(int i) throws IOException {
        int i2 = 0;
        if (this.f50807b[0] == 45) {
            i2 = 1;
        }
        long j = 0;
        int i3 = i2;
        while (i3 < i) {
            int i4 = this.f50807b[i3] - 48;
            if (i4 < 0 || i4 > 9) {
                throw m37830d(i);
            }
            long j2 = (10 * j) - ((long) i4);
            if (j2 <= j) {
                i3++;
                j = j2;
            } else {
                throw m37830d(i);
            }
        }
        m37826a(i + 1);
        return i2 != 0 ? j : -j;
    }

    /* renamed from: d */
    private NumberFormatException m37830d(int i) {
        return new NumberFormatException("invalid long: " + new String(this.f50807b, 0, i, Charset.forName("US-ASCII")));
    }

    public int nextInt() throws IOException {
        long nextLong = nextLong();
        if (nextLong <= 2147483647L && nextLong >= -2147483648L) {
            return (int) nextLong;
        }
        throw new NumberFormatException("parsed value larger than integer");
    }

    public void close() throws IOException {
        this.f50806a.close();
    }
}
