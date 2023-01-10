package net.lingala.zip4j.p070io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import net.lingala.zip4j.crypto.AESDecrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.util.Zip4jUtil;

/* renamed from: net.lingala.zip4j.io.inputstream.a */
/* compiled from: AesCipherInputStream */
class C2951a extends C2952b<AESDecrypter> {

    /* renamed from: a */
    private byte[] f6713a = new byte[1];

    /* renamed from: b */
    private byte[] f6714b = new byte[16];

    /* renamed from: c */
    private int f6715c = 0;

    /* renamed from: d */
    private int f6716d = 0;

    /* renamed from: e */
    private int f6717e = 0;

    /* renamed from: f */
    private int f6718f = 0;

    /* renamed from: g */
    private int f6719g = 0;

    /* renamed from: h */
    private int f6720h = 0;

    /* renamed from: i */
    private int f6721i = 0;

    public C2951a(C2955e eVar, LocalFileHeader localFileHeader, char[] cArr, int i) throws IOException {
        super(eVar, localFileHeader, cArr, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public AESDecrypter mo29372b(LocalFileHeader localFileHeader, char[] cArr) throws IOException {
        return new AESDecrypter(localFileHeader.getAesExtraDataRecord(), cArr, m6530a(localFileHeader), m6533e());
    }

    public int read() throws IOException {
        if (read(this.f6713a) == -1) {
            return -1;
        }
        return this.f6713a[0];
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        this.f6717e = i2;
        this.f6718f = i;
        this.f6719g = 0;
        if (this.f6716d != 0) {
            m6529a(bArr, i);
            int i3 = this.f6719g;
            if (i3 == i2) {
                return i3;
            }
        }
        if (this.f6717e < 16) {
            byte[] bArr2 = this.f6714b;
            int read = super.read(bArr2, 0, bArr2.length);
            this.f6721i = read;
            this.f6715c = 0;
            if (read == -1) {
                this.f6716d = 0;
                int i4 = this.f6719g;
                if (i4 > 0) {
                    return i4;
                }
                return -1;
            }
            this.f6716d = read;
            m6529a(bArr, this.f6718f);
            int i5 = this.f6719g;
            if (i5 == i2) {
                return i5;
            }
        }
        int i6 = this.f6718f;
        int i7 = this.f6717e;
        int read2 = super.read(bArr, i6, i7 - (i7 % 16));
        if (read2 != -1) {
            return read2 + this.f6719g;
        }
        int i8 = this.f6719g;
        if (i8 > 0) {
            return i8;
        }
        return -1;
    }

    /* renamed from: a */
    private void m6529a(byte[] bArr, int i) {
        int i2 = this.f6717e;
        int i3 = this.f6716d;
        if (i2 >= i3) {
            i2 = i3;
        }
        this.f6720h = i2;
        System.arraycopy(this.f6714b, this.f6715c, bArr, i, i2);
        m6528a(this.f6720h);
        m6531b(this.f6720h);
        int i4 = this.f6719g;
        int i5 = this.f6720h;
        this.f6719g = i4 + i5;
        this.f6717e -= i5;
        this.f6718f += i5;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29398a(InputStream inputStream) throws IOException {
        m6532b(mo29399b(inputStream));
    }

    /* renamed from: b */
    private void m6532b(byte[] bArr) throws IOException {
        if (!mo29408d().isDataDescriptorExists() || !CompressionMethod.DEFLATE.equals(Zip4jUtil.getCompressionMethod(mo29408d()))) {
            byte[] bArr2 = new byte[10];
            System.arraycopy(((AESDecrypter) mo29405b()).getCalculatedAuthenticationBytes(), 0, bArr2, 0, 10);
            if (!Arrays.equals(bArr, bArr2)) {
                throw new IOException("Reached end of data for this entry, but aes verification failed");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public byte[] mo29399b(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[10];
        if (Zip4jUtil.readFully(inputStream, bArr) == 10) {
            return bArr;
        }
        throw new ZipException("Invalid AES Mac bytes. Could not read sufficient data");
    }

    /* renamed from: a */
    private byte[] m6530a(LocalFileHeader localFileHeader) throws IOException {
        if (localFileHeader.getAesExtraDataRecord() != null) {
            byte[] bArr = new byte[localFileHeader.getAesExtraDataRecord().getAesKeyStrength().getSaltLength()];
            mo29403a(bArr);
            return bArr;
        }
        throw new IOException("invalid aes extra data record");
    }

    /* renamed from: e */
    private byte[] m6533e() throws IOException {
        byte[] bArr = new byte[2];
        mo29403a(bArr);
        return bArr;
    }

    /* renamed from: a */
    private void m6528a(int i) {
        int i2 = this.f6715c + i;
        this.f6715c = i2;
        if (i2 >= 15) {
            this.f6715c = 15;
        }
    }

    /* renamed from: b */
    private void m6531b(int i) {
        int i2 = this.f6716d - i;
        this.f6716d = i2;
        if (i2 <= 0) {
            this.f6716d = 0;
        }
    }
}
