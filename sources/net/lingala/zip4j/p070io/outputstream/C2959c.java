package net.lingala.zip4j.p070io.outputstream;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: net.lingala.zip4j.io.outputstream.c */
/* compiled from: CompressedOutputStream */
abstract class C2959c extends OutputStream {

    /* renamed from: a */
    private C2958b f6758a;

    public C2959c(C2958b bVar) {
        this.f6758a = bVar;
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f6758a.write(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29455a() throws IOException {
        this.f6758a.mo29447a();
    }

    public void close() throws IOException {
        this.f6758a.close();
    }

    /* renamed from: b */
    public long mo29456b() {
        return this.f6758a.mo29452b();
    }
}
