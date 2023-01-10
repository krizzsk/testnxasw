package net.lingala.zip4j.p070io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.crypto.Decrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.util.Zip4jUtil;

/* renamed from: net.lingala.zip4j.io.inputstream.b */
/* compiled from: CipherInputStream */
abstract class C2952b<T extends Decrypter> extends InputStream {

    /* renamed from: a */
    private C2955e f6722a;

    /* renamed from: b */
    private T f6723b;

    /* renamed from: c */
    private byte[] f6724c;

    /* renamed from: d */
    private byte[] f6725d = new byte[1];

    /* renamed from: e */
    private LocalFileHeader f6726e;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29398a(InputStream inputStream) throws IOException {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract T mo29372b(LocalFileHeader localFileHeader, char[] cArr) throws IOException, ZipException;

    public C2952b(C2955e eVar, LocalFileHeader localFileHeader, char[] cArr, int i) throws IOException {
        this.f6722a = eVar;
        this.f6723b = mo29372b(localFileHeader, cArr);
        this.f6726e = localFileHeader;
        if (Zip4jUtil.getCompressionMethod(localFileHeader).equals(CompressionMethod.DEFLATE)) {
            this.f6724c = new byte[i];
        }
    }

    public int read() throws IOException {
        if (read(this.f6725d) == -1) {
            return -1;
        }
        return this.f6725d[0] & 255;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int readFully = Zip4jUtil.readFully(this.f6722a, bArr, i, i2);
        if (readFully > 0) {
            m6538a(bArr, readFully);
            this.f6723b.decryptData(bArr, i, readFully);
        }
        return readFully;
    }

    public void close() throws IOException {
        this.f6722a.close();
    }

    /* renamed from: a */
    public byte[] mo29404a() {
        return this.f6724c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo29403a(byte[] bArr) throws IOException {
        return this.f6722a.mo29410a(bArr);
    }

    /* renamed from: a */
    private void m6538a(byte[] bArr, int i) {
        byte[] bArr2 = this.f6724c;
        if (bArr2 != null) {
            System.arraycopy(bArr, 0, bArr2, 0, i);
        }
    }

    /* renamed from: b */
    public T mo29405b() {
        return this.f6723b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public long mo29406c() {
        return this.f6722a.mo29411a();
    }

    /* renamed from: d */
    public LocalFileHeader mo29408d() {
        return this.f6726e;
    }
}
