package com.didi.dqr.qrcode.decoder;

/* renamed from: com.didi.dqr.qrcode.decoder.c */
/* compiled from: FormatInformation */
final class C8487c {

    /* renamed from: a */
    private static final int f20907a = 21522;

    /* renamed from: b */
    private static final int[][] f20908b = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: c */
    private final ErrorCorrectionLevel f20909c;

    /* renamed from: d */
    private final byte f20910d;

    private C8487c(int i) {
        this.f20909c = ErrorCorrectionLevel.forBits((i >> 3) & 3);
        this.f20910d = (byte) (i & 7);
    }

    /* renamed from: a */
    static int m17656a(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    /* renamed from: b */
    static C8487c m17657b(int i, int i2) {
        C8487c c = m17658c(i, i2);
        if (c != null) {
            return c;
        }
        return m17658c(i ^ 21522, i2 ^ 21522);
    }

    /* renamed from: c */
    private static C8487c m17658c(int i, int i2) {
        int a;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        for (int[] iArr : f20908b) {
            int i5 = iArr[0];
            if (i5 == i || i5 == i2) {
                return new C8487c(iArr[1]);
            }
            int a2 = m17656a(i, i5);
            if (a2 < i3) {
                i4 = iArr[1];
                i3 = a2;
            }
            if (i != i2 && (a = m17656a(i2, i5)) < i3) {
                i4 = iArr[1];
                i3 = a;
            }
        }
        if (i3 <= 3) {
            return new C8487c(i4);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ErrorCorrectionLevel mo63553a() {
        return this.f20909c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public byte mo63554b() {
        return this.f20910d;
    }

    public int hashCode() {
        return (this.f20909c.ordinal() << 3) | this.f20910d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C8487c)) {
            return false;
        }
        C8487c cVar = (C8487c) obj;
        if (this.f20909c == cVar.f20909c && this.f20910d == cVar.f20910d) {
            return true;
        }
        return false;
    }
}
