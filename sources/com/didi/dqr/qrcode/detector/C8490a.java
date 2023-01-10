package com.didi.dqr.qrcode.detector;

import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitMatrix;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.dqr.qrcode.detector.a */
/* compiled from: AlignmentPatternFinder */
final class C8490a {

    /* renamed from: a */
    private final BitMatrix f20943a;

    /* renamed from: b */
    private final List<AlignmentPattern> f20944b = new ArrayList(5);

    /* renamed from: c */
    private final int f20945c;

    /* renamed from: d */
    private final int f20946d;

    /* renamed from: e */
    private final int f20947e;

    /* renamed from: f */
    private final int f20948f;

    /* renamed from: g */
    private final float f20949g;

    /* renamed from: h */
    private final int[] f20950h;

    C8490a(BitMatrix bitMatrix, int i, int i2, int i3, int i4, float f) {
        this.f20943a = bitMatrix;
        this.f20945c = i;
        this.f20946d = i2;
        this.f20947e = i3;
        this.f20948f = i4;
        this.f20949g = f;
        this.f20950h = new int[3];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AlignmentPattern mo63595a() throws NotFoundException {
        AlignmentPattern a;
        AlignmentPattern a2;
        int i = this.f20945c;
        int i2 = this.f20948f;
        int i3 = this.f20947e + i;
        int i4 = this.f20946d + (i2 / 2);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = ((i5 & 1) == 0 ? (i5 + 1) / 2 : -((i5 + 1) / 2)) + i4;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i7 = i;
            while (i7 < i3 && !this.f20943a.get(i7, i6)) {
                i7++;
            }
            int i8 = 0;
            while (i7 < i3) {
                if (!this.f20943a.get(i7, i6)) {
                    if (i8 == 1) {
                        i8++;
                    }
                    iArr[i8] = iArr[i8] + 1;
                } else if (i8 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i8 != 2) {
                    i8++;
                    iArr[i8] = iArr[i8] + 1;
                } else if (m17697a(iArr) && (a2 = m17696a(iArr, i6, i7)) != null) {
                    return a2;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i8 = 1;
                }
                i7++;
            }
            if (m17697a(iArr) && (a = m17696a(iArr, i6, i3)) != null) {
                return a;
            }
        }
        if (!this.f20944b.isEmpty()) {
            return this.f20944b.get(0);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* renamed from: a */
    private static float m17695a(int[] iArr, int i) {
        return ((float) (i - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    /* renamed from: a */
    private boolean m17697a(int[] iArr) {
        float f = this.f20949g;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - ((float) iArr[i])) >= f2) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private float m17694a(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.f20943a;
        int height = bitMatrix.getHeight();
        int[] iArr = this.f20950h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i2, i5) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i5--;
        }
        if (i5 < 0 || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i2, i5) && iArr[0] <= i3) {
            iArr[0] = iArr[0] + 1;
            i5--;
        }
        if (iArr[0] > i3) {
            return Float.NaN;
        }
        int i6 = i + 1;
        while (i6 < height && bitMatrix.get(i2, i6) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i6++;
        }
        if (i6 == height || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i6 < height && !bitMatrix.get(i2, i6) && iArr[2] <= i3) {
            iArr[2] = iArr[2] + 1;
            i6++;
        }
        if (iArr[2] <= i3 && Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i4) * 5 < i4 * 2 && m17697a(iArr)) {
            return m17695a(iArr, i6);
        }
        return Float.NaN;
    }

    /* renamed from: a */
    private AlignmentPattern m17696a(int[] iArr, int i, int i2) {
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float a = m17695a(iArr, i2);
        float a2 = m17694a(i, (int) a, iArr[1] * 2, i3);
        if (Float.isNaN(a2)) {
            return null;
        }
        float f = ((float) ((iArr[0] + iArr[1]) + iArr[2])) / 3.0f;
        for (AlignmentPattern next : this.f20944b) {
            if (next.mo63557a(f, a2, a)) {
                return next.mo63558b(a2, a, f);
            }
        }
        this.f20944b.add(new AlignmentPattern(a, a2, f));
        return null;
    }
}
