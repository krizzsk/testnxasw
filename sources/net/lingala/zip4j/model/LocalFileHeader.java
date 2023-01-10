package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;

public class LocalFileHeader extends AbstractFileHeader {

    /* renamed from: a */
    private byte[] f6814a;

    /* renamed from: b */
    private long f6815b;

    /* renamed from: c */
    private boolean f6816c;

    public LocalFileHeader() {
        setSignature(HeaderSignature.LOCAL_FILE_HEADER);
    }

    public byte[] getExtraField() {
        return this.f6814a;
    }

    public void setExtraField(byte[] bArr) {
        this.f6814a = bArr;
    }

    public long getOffsetStartOfData() {
        return this.f6815b;
    }

    public void setOffsetStartOfData(long j) {
        this.f6815b = j;
    }

    public boolean isWriteCompressedSizeInZip64ExtraRecord() {
        return this.f6816c;
    }

    public void setWriteCompressedSizeInZip64ExtraRecord(boolean z) {
        this.f6816c = z;
    }
}
