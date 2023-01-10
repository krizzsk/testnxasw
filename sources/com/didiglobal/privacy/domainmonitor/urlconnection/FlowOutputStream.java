package com.didiglobal.privacy.domainmonitor.urlconnection;

import java.io.IOException;
import java.io.OutputStream;

public class FlowOutputStream extends OutputStream {

    /* renamed from: a */
    private final OutputStream f53073a;

    /* renamed from: b */
    private final OutputStreamStatusListener f53074b;

    /* renamed from: c */
    private long f53075c;

    interface OutputStreamStatusListener {
        void onWriteFinished(long j);
    }

    public FlowOutputStream(OutputStream outputStream, OutputStreamStatusListener outputStreamStatusListener) {
        this.f53073a = outputStream;
        this.f53074b = outputStreamStatusListener;
    }

    public long getUploadByteCountAndClear() {
        long j = this.f53075c;
        this.f53075c = 0;
        return j;
    }

    public void write(byte[] bArr) throws IOException {
        this.f53073a.write(bArr);
        if (bArr != null) {
            m39744a(bArr.length);
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f53073a.write(bArr, i, i2);
        m39744a(i2);
    }

    public void flush() throws IOException {
        this.f53073a.flush();
    }

    public void close() throws IOException {
        this.f53073a.close();
        OutputStreamStatusListener outputStreamStatusListener = this.f53074b;
        if (outputStreamStatusListener != null) {
            outputStreamStatusListener.onWriteFinished(this.f53075c);
        }
    }

    public int hashCode() {
        return this.f53073a.hashCode();
    }

    public boolean equals(Object obj) {
        return this.f53073a.equals(obj);
    }

    public String toString() {
        return this.f53073a.toString();
    }

    public void write(int i) throws IOException {
        this.f53073a.write(i);
        m39744a(1);
    }

    /* renamed from: a */
    private void m39744a(int i) {
        if (i > 0) {
            this.f53075c += (long) i;
        }
    }
}
