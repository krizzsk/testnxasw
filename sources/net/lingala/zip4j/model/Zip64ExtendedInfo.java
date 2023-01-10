package net.lingala.zip4j.model;

public class Zip64ExtendedInfo extends ZipHeader {

    /* renamed from: a */
    private int f6833a;

    /* renamed from: b */
    private long f6834b = -1;

    /* renamed from: c */
    private long f6835c = -1;

    /* renamed from: d */
    private long f6836d = -1;

    /* renamed from: e */
    private int f6837e = -1;

    public int getSize() {
        return this.f6833a;
    }

    public void setSize(int i) {
        this.f6833a = i;
    }

    public long getCompressedSize() {
        return this.f6834b;
    }

    public void setCompressedSize(long j) {
        this.f6834b = j;
    }

    public long getUncompressedSize() {
        return this.f6835c;
    }

    public void setUncompressedSize(long j) {
        this.f6835c = j;
    }

    public long getOffsetLocalHeader() {
        return this.f6836d;
    }

    public void setOffsetLocalHeader(long j) {
        this.f6836d = j;
    }

    public int getDiskNumberStart() {
        return this.f6837e;
    }

    public void setDiskNumberStart(int i) {
        this.f6837e = i;
    }
}
