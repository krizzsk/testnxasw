package org.apache.commons.p074io.input;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.apache.commons.io.input.BoundedInputStream */
public class BoundedInputStream extends InputStream {

    /* renamed from: in */
    private final InputStream f7471in;
    private long mark;
    private final long max;
    private long pos;
    private boolean propagateClose;

    public BoundedInputStream(InputStream inputStream, long j) {
        this.pos = 0;
        this.mark = -1;
        this.propagateClose = true;
        this.max = j;
        this.f7471in = inputStream;
    }

    public BoundedInputStream(InputStream inputStream) {
        this(inputStream, -1);
    }

    public int read() throws IOException {
        long j = this.max;
        if (j >= 0 && this.pos >= j) {
            return -1;
        }
        int read = this.f7471in.read();
        this.pos++;
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.max;
        if (j >= 0 && this.pos >= j) {
            return -1;
        }
        long j2 = this.max;
        int read = this.f7471in.read(bArr, i, (int) (j2 >= 0 ? Math.min((long) i2, j2 - this.pos) : (long) i2));
        if (read == -1) {
            return -1;
        }
        this.pos += (long) read;
        return read;
    }

    public long skip(long j) throws IOException {
        long j2 = this.max;
        if (j2 >= 0) {
            j = Math.min(j, j2 - this.pos);
        }
        long skip = this.f7471in.skip(j);
        this.pos += skip;
        return skip;
    }

    public int available() throws IOException {
        long j = this.max;
        if (j < 0 || this.pos < j) {
            return this.f7471in.available();
        }
        return 0;
    }

    public String toString() {
        return this.f7471in.toString();
    }

    public void close() throws IOException {
        if (this.propagateClose) {
            this.f7471in.close();
        }
    }

    public synchronized void reset() throws IOException {
        this.f7471in.reset();
        this.pos = this.mark;
    }

    public synchronized void mark(int i) {
        this.f7471in.mark(i);
        this.mark = this.pos;
    }

    public boolean markSupported() {
        return this.f7471in.markSupported();
    }

    public boolean isPropagateClose() {
        return this.propagateClose;
    }

    public void setPropagateClose(boolean z) {
        this.propagateClose = z;
    }
}
