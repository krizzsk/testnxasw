package com.didi.dqr;

import java.util.EnumMap;
import java.util.Map;

public final class Result {

    /* renamed from: a */
    private final String f20378a;

    /* renamed from: b */
    private final byte[] f20379b;

    /* renamed from: c */
    private final int f20380c;
    public int contourDilateCount;

    /* renamed from: d */
    private ResultPoint[] f20381d;

    /* renamed from: e */
    private final BarcodeFormat f20382e;

    /* renamed from: f */
    private Map<ResultMetadataType, Object> f20383f;

    /* renamed from: g */
    private final long f20384g;

    /* renamed from: h */
    private boolean f20385h;
    public boolean isQRCode;
    public int realContourDilateCount;

    public Result(String str, byte[] bArr, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, resultPointArr, barcodeFormat, System.currentTimeMillis());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Result(String str, byte[] bArr, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat, long j) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, resultPointArr, barcodeFormat, j);
    }

    public Result(String str, byte[] bArr, int i, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat, long j) {
        this.f20385h = true;
        this.f20378a = str;
        this.f20379b = bArr;
        this.f20380c = i;
        this.f20381d = resultPointArr;
        this.f20382e = barcodeFormat;
        this.f20383f = null;
        this.f20384g = j;
    }

    public String getText() {
        return this.f20378a;
    }

    public byte[] getRawBytes() {
        return this.f20379b;
    }

    public int getNumBits() {
        return this.f20380c;
    }

    public ResultPoint[] getResultPoints() {
        return this.f20381d;
    }

    public BarcodeFormat getBarcodeFormat() {
        return this.f20382e;
    }

    public Map<ResultMetadataType, Object> getResultMetadata() {
        return this.f20383f;
    }

    public void putMetadata(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f20383f == null) {
            this.f20383f = new EnumMap(ResultMetadataType.class);
        }
        this.f20383f.put(resultMetadataType, obj);
    }

    public void putAllMetadata(Map<ResultMetadataType, Object> map) {
        if (map != null) {
            Map<ResultMetadataType, Object> map2 = this.f20383f;
            if (map2 == null) {
                this.f20383f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void addResultPoints(ResultPoint[] resultPointArr) {
        ResultPoint[] resultPointArr2 = this.f20381d;
        if (resultPointArr2 == null) {
            this.f20381d = resultPointArr;
        } else if (resultPointArr != null && resultPointArr.length > 0) {
            ResultPoint[] resultPointArr3 = new ResultPoint[(resultPointArr2.length + resultPointArr.length)];
            System.arraycopy(resultPointArr2, 0, resultPointArr3, 0, resultPointArr2.length);
            System.arraycopy(resultPointArr, 0, resultPointArr3, resultPointArr2.length, resultPointArr.length);
            this.f20381d = resultPointArr3;
        }
    }

    public boolean isFromZxing() {
        return this.f20385h;
    }

    public void setFromZxing(boolean z) {
        this.f20385h = z;
    }

    public long getTimestamp() {
        return this.f20384g;
    }

    public String toString() {
        return this.f20378a;
    }
}
