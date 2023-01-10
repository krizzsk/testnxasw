package net.lingala.zip4j.model;

public class ExtraDataRecord extends ZipHeader {

    /* renamed from: a */
    private long f6804a;

    /* renamed from: b */
    private int f6805b;

    /* renamed from: c */
    private byte[] f6806c;

    public long getHeader() {
        return this.f6804a;
    }

    public void setHeader(long j) {
        this.f6804a = j;
    }

    public int getSizeOfData() {
        return this.f6805b;
    }

    public void setSizeOfData(int i) {
        this.f6805b = i;
    }

    public byte[] getData() {
        return this.f6806c;
    }

    public void setData(byte[] bArr) {
        this.f6806c = bArr;
    }
}
