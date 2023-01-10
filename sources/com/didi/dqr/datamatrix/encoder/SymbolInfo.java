package com.didi.dqr.datamatrix.encoder;

import com.didi.dqr.Dimension;

public class SymbolInfo {

    /* renamed from: a */
    static final SymbolInfo[] f20511a;

    /* renamed from: b */
    private static SymbolInfo[] f20512b;

    /* renamed from: c */
    private final boolean f20513c;

    /* renamed from: d */
    private final int f20514d;

    /* renamed from: e */
    private final int f20515e;

    /* renamed from: f */
    private final int f20516f;

    /* renamed from: g */
    private final int f20517g;

    /* renamed from: h */
    private final int f20518h;
    public final int matrixHeight;
    public final int matrixWidth;

    static {
        SymbolInfo[] symbolInfoArr = {new SymbolInfo(false, 3, 5, 8, 8, 1), new SymbolInfo(false, 5, 7, 10, 10, 1), new SymbolInfo(true, 5, 7, 16, 6, 1), new SymbolInfo(false, 8, 10, 12, 12, 1), new SymbolInfo(true, 10, 11, 14, 6, 2), new SymbolInfo(false, 12, 12, 14, 14, 1), new SymbolInfo(true, 16, 14, 24, 10, 1), new SymbolInfo(false, 18, 14, 16, 16, 1), new SymbolInfo(false, 22, 18, 18, 18, 1), new SymbolInfo(true, 22, 18, 16, 10, 2), new SymbolInfo(false, 30, 20, 20, 20, 1), new SymbolInfo(true, 32, 24, 16, 14, 2), new SymbolInfo(false, 36, 24, 22, 22, 1), new SymbolInfo(false, 44, 28, 24, 24, 1), new SymbolInfo(true, 49, 28, 22, 14, 2), new SymbolInfo(false, 62, 36, 14, 14, 4), new SymbolInfo(false, 86, 42, 16, 16, 4), new SymbolInfo(false, 114, 48, 18, 18, 4), new SymbolInfo(false, 144, 56, 20, 20, 4), new SymbolInfo(false, 174, 68, 22, 22, 4), new SymbolInfo(false, 204, 84, 24, 24, 4, 102, 42), new SymbolInfo(false, 280, 112, 14, 14, 16, 140, 56), new SymbolInfo(false, 368, 144, 16, 16, 16, 92, 36), new SymbolInfo(false, 456, 192, 18, 18, 16, 114, 48), new SymbolInfo(false, 576, 224, 20, 20, 16, 144, 56), new SymbolInfo(false, 696, 272, 22, 22, 16, 174, 68), new SymbolInfo(false, 816, 336, 24, 24, 16, 136, 56), new SymbolInfo(false, 1050, 408, 18, 18, 36, 175, 68), new SymbolInfo(false, 1304, 496, 20, 20, 36, 163, 62), new C8430d()};
        f20511a = symbolInfoArr;
        f20512b = symbolInfoArr;
    }

    public static void overrideSymbolSet(SymbolInfo[] symbolInfoArr) {
        f20512b = symbolInfoArr;
    }

    public SymbolInfo(boolean z, int i, int i2, int i3, int i4, int i5) {
        this(z, i, i2, i3, i4, i5, i, i2);
    }

    SymbolInfo(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f20513c = z;
        this.f20514d = i;
        this.f20515e = i2;
        this.matrixWidth = i3;
        this.matrixHeight = i4;
        this.f20516f = i5;
        this.f20517g = i6;
        this.f20518h = i7;
    }

    public static SymbolInfo lookup(int i) {
        return m17253a(i, SymbolShapeHint.FORCE_NONE, true);
    }

    public static SymbolInfo lookup(int i, SymbolShapeHint symbolShapeHint) {
        return m17253a(i, symbolShapeHint, true);
    }

    public static SymbolInfo lookup(int i, boolean z, boolean z2) {
        return m17253a(i, z ? SymbolShapeHint.FORCE_NONE : SymbolShapeHint.FORCE_SQUARE, z2);
    }

    /* renamed from: a */
    private static SymbolInfo m17253a(int i, SymbolShapeHint symbolShapeHint, boolean z) {
        return lookup(i, symbolShapeHint, (Dimension) null, (Dimension) null, z);
    }

    public static SymbolInfo lookup(int i, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2, boolean z) {
        for (SymbolInfo symbolInfo : f20512b) {
            if ((symbolShapeHint != SymbolShapeHint.FORCE_SQUARE || !symbolInfo.f20513c) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || symbolInfo.f20513c) && ((dimension == null || (symbolInfo.getSymbolWidth() >= dimension.getWidth() && symbolInfo.getSymbolHeight() >= dimension.getHeight())) && ((dimension2 == null || (symbolInfo.getSymbolWidth() <= dimension2.getWidth() && symbolInfo.getSymbolHeight() <= dimension2.getHeight())) && i <= symbolInfo.f20514d)))) {
                return symbolInfo;
            }
        }
        if (!z) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i);
    }

    /* renamed from: a */
    private int m17252a() {
        int i = this.f20516f;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (!(i == 2 || i == 4)) {
                if (i == 16) {
                    return 4;
                }
                if (i == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i2;
    }

    /* renamed from: b */
    private int m17254b() {
        int i = this.f20516f;
        if (i == 1 || i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final int getSymbolDataWidth() {
        return m17252a() * this.matrixWidth;
    }

    public final int getSymbolDataHeight() {
        return m17254b() * this.matrixHeight;
    }

    public final int getSymbolWidth() {
        return getSymbolDataWidth() + (m17252a() * 2);
    }

    public final int getSymbolHeight() {
        return getSymbolDataHeight() + (m17254b() * 2);
    }

    public int getCodewordCount() {
        return this.f20514d + this.f20515e;
    }

    public int getInterleavedBlockCount() {
        return this.f20514d / this.f20517g;
    }

    public final int getDataCapacity() {
        return this.f20514d;
    }

    public final int getErrorCodewords() {
        return this.f20515e;
    }

    public int getDataLengthForInterleavedBlock(int i) {
        return this.f20517g;
    }

    public final int getErrorLengthForInterleavedBlock(int i) {
        return this.f20518h;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f20513c ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.matrixWidth);
        sb.append('x');
        sb.append(this.matrixHeight);
        sb.append(", symbol size ");
        sb.append(getSymbolWidth());
        sb.append('x');
        sb.append(getSymbolHeight());
        sb.append(", symbol data size ");
        sb.append(getSymbolDataWidth());
        sb.append('x');
        sb.append(getSymbolDataHeight());
        sb.append(", codewords ");
        sb.append(this.f20514d);
        sb.append('+');
        sb.append(this.f20515e);
        return sb.toString();
    }
}
