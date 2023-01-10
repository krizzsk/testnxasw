package net.lingala.zip4j.p070io.outputstream;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: net.lingala.zip4j.io.outputstream.f */
/* compiled from: ZipEntryOutputStream */
class C2962f extends OutputStream {

    /* renamed from: a */
    private long f6761a = 0;

    /* renamed from: b */
    private OutputStream f6762b;

    /* renamed from: c */
    private boolean f6763c;

    public void close() throws IOException {
    }

    public C2962f(OutputStream outputStream) {
        this.f6762b = outputStream;
        this.f6763c = false;
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f6763c) {
            this.f6762b.write(bArr, i, i2);
            this.f6761a += (long) i2;
            return;
        }
        throw new IllegalStateException("ZipEntryOutputStream is closed");
    }

    /* renamed from: a */
    public void mo29461a() throws IOException {
        this.f6763c = true;
    }

    /* renamed from: b */
    public long mo29462b() {
        return this.f6761a;
    }
}
