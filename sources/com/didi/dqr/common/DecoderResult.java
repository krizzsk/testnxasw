package com.didi.dqr.common;

import java.util.List;

public final class DecoderResult {

    /* renamed from: a */
    private final byte[] f20398a;

    /* renamed from: b */
    private int f20399b;

    /* renamed from: c */
    private final String f20400c;

    /* renamed from: d */
    private final List<byte[]> f20401d;

    /* renamed from: e */
    private final String f20402e;

    /* renamed from: f */
    private Integer f20403f;

    /* renamed from: g */
    private Integer f20404g;

    /* renamed from: h */
    private Object f20405h;

    /* renamed from: i */
    private final int f20406i;

    /* renamed from: j */
    private final int f20407j;

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2) {
        int i3;
        this.f20398a = bArr;
        if (bArr == null) {
            i3 = 0;
        } else {
            i3 = bArr.length * 8;
        }
        this.f20399b = i3;
        this.f20400c = str;
        this.f20401d = list;
        this.f20402e = str2;
        this.f20406i = i2;
        this.f20407j = i;
    }

    public byte[] getRawBytes() {
        return this.f20398a;
    }

    public int getNumBits() {
        return this.f20399b;
    }

    public void setNumBits(int i) {
        this.f20399b = i;
    }

    public String getText() {
        return this.f20400c;
    }

    public List<byte[]> getByteSegments() {
        return this.f20401d;
    }

    public String getECLevel() {
        return this.f20402e;
    }

    public Integer getErrorsCorrected() {
        return this.f20403f;
    }

    public void setErrorsCorrected(Integer num) {
        this.f20403f = num;
    }

    public Integer getErasures() {
        return this.f20404g;
    }

    public void setErasures(Integer num) {
        this.f20404g = num;
    }

    public Object getOther() {
        return this.f20405h;
    }

    public void setOther(Object obj) {
        this.f20405h = obj;
    }

    public boolean hasStructuredAppend() {
        return this.f20406i >= 0 && this.f20407j >= 0;
    }

    public int getStructuredAppendParity() {
        return this.f20406i;
    }

    public int getStructuredAppendSequenceNumber() {
        return this.f20407j;
    }
}
