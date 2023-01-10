package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;

public class FileHeader extends AbstractFileHeader {

    /* renamed from: a */
    private int f6807a;

    /* renamed from: b */
    private int f6808b = 0;

    /* renamed from: c */
    private int f6809c;

    /* renamed from: d */
    private byte[] f6810d;

    /* renamed from: e */
    private byte[] f6811e;

    /* renamed from: f */
    private long f6812f;

    /* renamed from: g */
    private String f6813g;

    public FileHeader() {
        setSignature(HeaderSignature.CENTRAL_DIRECTORY);
    }

    public int getVersionMadeBy() {
        return this.f6807a;
    }

    public void setVersionMadeBy(int i) {
        this.f6807a = i;
    }

    public int getFileCommentLength() {
        return this.f6808b;
    }

    public void setFileCommentLength(int i) {
        this.f6808b = i;
    }

    public int getDiskNumberStart() {
        return this.f6809c;
    }

    public void setDiskNumberStart(int i) {
        this.f6809c = i;
    }

    public byte[] getInternalFileAttributes() {
        return this.f6810d;
    }

    public void setInternalFileAttributes(byte[] bArr) {
        this.f6810d = bArr;
    }

    public byte[] getExternalFileAttributes() {
        return this.f6811e;
    }

    public void setExternalFileAttributes(byte[] bArr) {
        this.f6811e = bArr;
    }

    public long getOffsetLocalHeader() {
        return this.f6812f;
    }

    public void setOffsetLocalHeader(long j) {
        this.f6812f = j;
    }

    public String getFileComment() {
        return this.f6813g;
    }

    public void setFileComment(String str) {
        this.f6813g = str;
    }

    public String toString() {
        return getFileName();
    }
}
