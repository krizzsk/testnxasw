package net.lingala.zip4j.model;

public class DataDescriptor extends ZipHeader {

    /* renamed from: a */
    private long f6791a;

    /* renamed from: b */
    private long f6792b;

    /* renamed from: c */
    private long f6793c;

    public long getCrc() {
        return this.f6791a;
    }

    public void setCrc(long j) {
        this.f6791a = j;
    }

    public long getCompressedSize() {
        return this.f6792b;
    }

    public void setCompressedSize(long j) {
        this.f6792b = j;
    }

    public long getUncompressedSize() {
        return this.f6793c;
    }

    public void setUncompressedSize(long j) {
        this.f6793c = j;
    }
}
