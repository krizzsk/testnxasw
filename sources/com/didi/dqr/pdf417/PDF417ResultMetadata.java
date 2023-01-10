package com.didi.dqr.pdf417;

public final class PDF417ResultMetadata {

    /* renamed from: a */
    private int f20738a;

    /* renamed from: b */
    private String f20739b;

    /* renamed from: c */
    private boolean f20740c;

    /* renamed from: d */
    private int f20741d = -1;

    /* renamed from: e */
    private String f20742e;

    /* renamed from: f */
    private String f20743f;

    /* renamed from: g */
    private String f20744g;

    /* renamed from: h */
    private long f20745h = -1;

    /* renamed from: i */
    private long f20746i = -1;

    /* renamed from: j */
    private int f20747j = -1;

    /* renamed from: k */
    private int[] f20748k;

    public int getSegmentIndex() {
        return this.f20738a;
    }

    public void setSegmentIndex(int i) {
        this.f20738a = i;
    }

    public String getFileId() {
        return this.f20739b;
    }

    public void setFileId(String str) {
        this.f20739b = str;
    }

    @Deprecated
    public int[] getOptionalData() {
        return this.f20748k;
    }

    @Deprecated
    public void setOptionalData(int[] iArr) {
        this.f20748k = iArr;
    }

    public boolean isLastSegment() {
        return this.f20740c;
    }

    public void setLastSegment(boolean z) {
        this.f20740c = z;
    }

    public int getSegmentCount() {
        return this.f20741d;
    }

    public void setSegmentCount(int i) {
        this.f20741d = i;
    }

    public String getSender() {
        return this.f20742e;
    }

    public void setSender(String str) {
        this.f20742e = str;
    }

    public String getAddressee() {
        return this.f20743f;
    }

    public void setAddressee(String str) {
        this.f20743f = str;
    }

    public String getFileName() {
        return this.f20744g;
    }

    public void setFileName(String str) {
        this.f20744g = str;
    }

    public long getFileSize() {
        return this.f20745h;
    }

    public void setFileSize(long j) {
        this.f20745h = j;
    }

    public int getChecksum() {
        return this.f20747j;
    }

    public void setChecksum(int i) {
        this.f20747j = i;
    }

    public long getTimestamp() {
        return this.f20746i;
    }

    public void setTimestamp(long j) {
        this.f20746i = j;
    }
}
