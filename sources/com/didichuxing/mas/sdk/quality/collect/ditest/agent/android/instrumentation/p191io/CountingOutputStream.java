package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.p191io;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.io.CountingOutputStream */
public final class CountingOutputStream extends OutputStream implements StreamCompleteListenerSource {

    /* renamed from: a */
    private final OutputStream f50560a;

    /* renamed from: b */
    private long f50561b;

    /* renamed from: c */
    private final C16577a f50562c = new C16577a();

    public CountingOutputStream(OutputStream outputStream) {
        this.f50560a = outputStream;
    }

    public void addStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.f50562c.mo124755a(streamCompleteListener);
    }

    public void removeStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.f50562c.mo124758b(streamCompleteListener);
    }

    public long getCount() {
        return this.f50561b;
    }

    public void write(int i) throws IOException {
        try {
            this.f50560a.write(i);
            this.f50561b++;
        } catch (IOException e) {
            m37701a(e);
            throw e;
        }
    }

    public void write(byte[] bArr) throws IOException {
        try {
            this.f50560a.write(bArr);
            this.f50561b += (long) bArr.length;
        } catch (IOException e) {
            m37701a(e);
            throw e;
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.f50560a.write(bArr, i, i2);
            this.f50561b += (long) i2;
        } catch (IOException e) {
            m37701a(e);
            throw e;
        }
    }

    public void flush() throws IOException {
        try {
            this.f50560a.flush();
        } catch (IOException e) {
            m37701a(e);
            throw e;
        }
    }

    public void close() throws IOException {
        try {
            this.f50560a.close();
            m37700a();
        } catch (IOException e) {
            m37701a(e);
            throw e;
        }
    }

    /* renamed from: a */
    private void m37700a() {
        if (!this.f50562c.mo124756a()) {
            this.f50562c.mo124754a(new StreamCompleteEvent(this, this.f50561b));
        }
    }

    /* renamed from: a */
    private void m37701a(Exception exc) {
        if (!this.f50562c.mo124756a()) {
            this.f50562c.mo124757b(new StreamCompleteEvent(this, this.f50561b, exc));
        }
    }
}
