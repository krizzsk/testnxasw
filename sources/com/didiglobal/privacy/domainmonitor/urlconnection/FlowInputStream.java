package com.didiglobal.privacy.domainmonitor.urlconnection;

import java.io.IOException;
import java.io.InputStream;

public class FlowInputStream extends InputStream {

    /* renamed from: a */
    private final InputStream f53070a;

    /* renamed from: b */
    private final InputStreamStatusListener f53071b;

    /* renamed from: c */
    private long f53072c;

    interface InputStreamStatusListener {
        void onReadFinished(long j);
    }

    public FlowInputStream(InputStream inputStream, InputStreamStatusListener inputStreamStatusListener) {
        this.f53070a = inputStream;
        this.f53071b = inputStreamStatusListener;
    }

    public int read() throws IOException {
        int read = this.f53070a.read();
        m39743a(1);
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        int read = this.f53070a.read(bArr);
        m39743a(read);
        return read;
    }

    /* renamed from: a */
    private void m39743a(int i) {
        if (i > 0) {
            this.f53072c += (long) i;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.f53070a.read(bArr, i, i2);
        m39743a(read);
        return read;
    }

    public long skip(long j) throws IOException {
        long skip = this.f53070a.skip(j);
        m39743a((int) skip);
        return skip;
    }

    public int available() throws IOException {
        return this.f53070a.available();
    }

    public void close() throws IOException {
        this.f53070a.close();
        this.f53071b.onReadFinished(this.f53072c);
        this.f53072c = 0;
    }

    public synchronized void mark(int i) {
        this.f53070a.mark(i);
    }

    public synchronized void reset() throws IOException {
        this.f53070a.reset();
    }

    public boolean markSupported() {
        return this.f53070a.markSupported();
    }

    public int hashCode() {
        return this.f53070a.hashCode();
    }

    public boolean equals(Object obj) {
        return this.f53070a.equals(obj);
    }

    public String toString() {
        return this.f53070a.toString();
    }
}
