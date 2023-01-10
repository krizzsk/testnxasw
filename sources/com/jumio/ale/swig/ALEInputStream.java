package com.jumio.ale.swig;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ALEInputStream extends FilterInputStream {

    /* renamed from: a */
    public ALERequest f57342a = null;

    /* renamed from: b */
    public InputStream f57343b;

    /* renamed from: c */
    public byte[] f57344c = new byte[512];

    /* renamed from: d */
    public boolean f57345d = false;

    /* renamed from: e */
    public byte[] f57346e;

    /* renamed from: f */
    public int f57347f = 0;

    /* renamed from: g */
    public int f57348g = 0;

    public ALEInputStream(InputStream inputStream, ALERequest aLERequest) {
        super(inputStream);
        this.f57343b = inputStream;
        this.f57342a = aLERequest;
        aLERequest.initResponse();
    }

    /* renamed from: a */
    public final int mo171665a() throws IOException {
        int i;
        if (this.f57345d) {
            return -1;
        }
        int read = this.f57343b.read(this.f57344c);
        if (read == -1) {
            this.f57345d = true;
            try {
                this.f57342a.finishResponse();
                return read;
            } catch (Exception e) {
                throw new IOException(e);
            }
        } else {
            try {
                byte[] bArr = this.f57344c;
                if (read != bArr.length) {
                    byte[] bArr2 = new byte[read];
                    System.arraycopy(bArr, 0, bArr2, 0, read);
                    byte[] bArr3 = new byte[(read + 32)];
                    this.f57346e = bArr3;
                    i = this.f57342a.updateResponse(bArr2, bArr3);
                } else {
                    byte[] bArr4 = new byte[(bArr.length + 32)];
                    this.f57346e = bArr4;
                    i = this.f57342a.updateResponse(bArr, bArr4);
                }
                this.f57347f = 0;
                if (this.f57346e == null) {
                    this.f57348g = 0;
                } else {
                    this.f57348g = i;
                }
                return this.f57348g;
            } catch (Exception e2) {
                this.f57346e = null;
                throw new IOException(e2);
            }
        }
    }

    public int available() throws IOException {
        return this.f57348g - this.f57347f;
    }

    public void close() throws IOException {
        this.f57343b.close();
        try {
            if (!this.f57345d) {
                this.f57342a.finishResponse();
            }
            this.f57347f = 0;
            this.f57348g = 0;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public boolean markSupported() {
        return false;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public long skip(long j) throws IOException {
        int i = this.f57348g;
        int i2 = this.f57347f;
        long j2 = (long) (i - i2);
        if (j > j2) {
            j = j2;
        }
        if (j < 0) {
            return 0;
        }
        this.f57347f = (int) (((long) i2) + j);
        return j;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f57347f >= this.f57348g) {
            int i3 = 0;
            while (i3 == 0) {
                i3 = mo171665a();
            }
            if (i3 == -1) {
                return -1;
            }
        }
        if (i2 <= 0) {
            return 0;
        }
        int i4 = this.f57348g;
        int i5 = this.f57347f;
        int i6 = i4 - i5;
        if (i2 >= i6) {
            i2 = i6;
        }
        if (bArr != null) {
            System.arraycopy(this.f57346e, i5, bArr, i, i2);
        }
        this.f57347f += i2;
        return i2;
    }
}
