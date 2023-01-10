package net.lingala.zip4j.p070io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import net.lingala.zip4j.crypto.Encrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;

/* renamed from: net.lingala.zip4j.io.outputstream.b */
/* compiled from: CipherOutputStream */
abstract class C2958b<T extends Encrypter> extends OutputStream {

    /* renamed from: a */
    private C2962f f6756a;

    /* renamed from: b */
    private T f6757b;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract T mo29429b(OutputStream outputStream, ZipParameters zipParameters, char[] cArr) throws IOException, ZipException;

    public C2958b(C2962f fVar, ZipParameters zipParameters, char[] cArr) throws IOException, ZipException {
        this.f6756a = fVar;
        this.f6757b = mo29429b(fVar, zipParameters, cArr);
    }

    public void write(int i) throws IOException {
        this.f6756a.write(i);
    }

    public void write(byte[] bArr) throws IOException {
        this.f6756a.write(bArr);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f6757b.encryptData(bArr, i, i2);
        this.f6756a.write(bArr, i, i2);
    }

    /* renamed from: a */
    public void mo29451a(byte[] bArr) throws IOException {
        this.f6756a.write(bArr);
    }

    /* renamed from: a */
    public void mo29447a() throws IOException {
        this.f6756a.mo29461a();
    }

    public void close() throws IOException {
        this.f6756a.close();
    }

    /* renamed from: b */
    public long mo29452b() {
        return this.f6756a.mo29462b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public T mo29453c() {
        return this.f6757b;
    }
}
