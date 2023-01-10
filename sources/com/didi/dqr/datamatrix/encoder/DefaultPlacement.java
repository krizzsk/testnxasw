package com.didi.dqr.datamatrix.encoder;

import java.util.Arrays;

public class DefaultPlacement {

    /* renamed from: a */
    private final CharSequence f20482a;

    /* renamed from: b */
    private final int f20483b;

    /* renamed from: c */
    private final int f20484c;

    /* renamed from: d */
    private final byte[] f20485d;

    public DefaultPlacement(CharSequence charSequence, int i, int i2) {
        this.f20482a = charSequence;
        this.f20484c = i;
        this.f20483b = i2;
        byte[] bArr = new byte[(i * i2)];
        this.f20485d = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo63272a() {
        return this.f20483b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final int mo63273b() {
        return this.f20484c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final byte[] mo63274c() {
        return this.f20485d;
    }

    public final boolean getBit(int i, int i2) {
        return this.f20485d[(i2 * this.f20484c) + i] == 1;
    }

    /* renamed from: a */
    private void m17230a(int i, int i2, boolean z) {
        this.f20485d[(i2 * this.f20484c) + i] = z ? (byte) 1 : 0;
    }

    /* renamed from: a */
    private boolean m17231a(int i, int i2) {
        return this.f20485d[(i2 * this.f20484c) + i] < 0;
    }

    public final void place() {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 4;
        while (true) {
            if (i5 == this.f20483b && i3 == 0) {
                m17227a(i4);
                i4++;
            }
            if (i5 == this.f20483b - 2 && i3 == 0 && this.f20484c % 4 != 0) {
                m17232b(i4);
                i4++;
            }
            if (i5 == this.f20483b - 2 && i3 == 0 && this.f20484c % 8 == 4) {
                m17233c(i4);
                i4++;
            }
            if (i5 == this.f20483b + 4 && i3 == 2 && this.f20484c % 8 == 0) {
                m17234d(i4);
                i4++;
            }
            do {
                if (i5 < this.f20483b && i3 >= 0 && m17231a(i3, i5)) {
                    m17228a(i5, i3, i4);
                    i4++;
                }
                i5 -= 2;
                i3 += 2;
                if (i5 < 0 || i3 >= this.f20484c) {
                    int i6 = i5 + 1;
                    int i7 = i3 + 3;
                }
                m17228a(i5, i3, i4);
                i4++;
                i5 -= 2;
                i3 += 2;
                break;
            } while (i3 >= this.f20484c);
            int i62 = i5 + 1;
            int i72 = i3 + 3;
            do {
                if (i62 >= 0 && i72 < this.f20484c && m17231a(i72, i62)) {
                    m17228a(i62, i72, i4);
                    i4++;
                }
                i62 += 2;
                i72 -= 2;
                if (i62 >= this.f20483b) {
                    break;
                }
            } while (i72 >= 0);
            i5 = i62 + 3;
            i3 = i72 + 1;
            i = this.f20483b;
            if (i5 >= i && i3 >= (i2 = this.f20484c)) {
                break;
            }
        }
        if (m17231a(i2 - 1, i - 1)) {
            m17230a(this.f20484c - 1, this.f20483b - 1, true);
            m17230a(this.f20484c - 2, this.f20483b - 2, true);
        }
    }

    /* renamed from: a */
    private void m17229a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            int i5 = this.f20483b;
            i += i5;
            i2 += 4 - ((i5 + 4) % 8);
        }
        if (i2 < 0) {
            int i6 = this.f20484c;
            i2 += i6;
            i += 4 - ((i6 + 4) % 8);
        }
        boolean z = true;
        if ((this.f20482a.charAt(i3) & (1 << (8 - i4))) == 0) {
            z = false;
        }
        m17230a(i2, i, z);
    }

    /* renamed from: a */
    private void m17228a(int i, int i2, int i3) {
        int i4 = i - 2;
        int i5 = i2 - 2;
        m17229a(i4, i5, i3, 1);
        int i6 = i2 - 1;
        m17229a(i4, i6, i3, 2);
        int i7 = i - 1;
        m17229a(i7, i5, i3, 3);
        m17229a(i7, i6, i3, 4);
        m17229a(i7, i2, i3, 5);
        m17229a(i, i5, i3, 6);
        m17229a(i, i6, i3, 7);
        m17229a(i, i2, i3, 8);
    }

    /* renamed from: a */
    private void m17227a(int i) {
        m17229a(this.f20483b - 1, 0, i, 1);
        m17229a(this.f20483b - 1, 1, i, 2);
        m17229a(this.f20483b - 1, 2, i, 3);
        m17229a(0, this.f20484c - 2, i, 4);
        m17229a(0, this.f20484c - 1, i, 5);
        m17229a(1, this.f20484c - 1, i, 6);
        m17229a(2, this.f20484c - 1, i, 7);
        m17229a(3, this.f20484c - 1, i, 8);
    }

    /* renamed from: b */
    private void m17232b(int i) {
        m17229a(this.f20483b - 3, 0, i, 1);
        m17229a(this.f20483b - 2, 0, i, 2);
        m17229a(this.f20483b - 1, 0, i, 3);
        m17229a(0, this.f20484c - 4, i, 4);
        m17229a(0, this.f20484c - 3, i, 5);
        m17229a(0, this.f20484c - 2, i, 6);
        m17229a(0, this.f20484c - 1, i, 7);
        m17229a(1, this.f20484c - 1, i, 8);
    }

    /* renamed from: c */
    private void m17233c(int i) {
        m17229a(this.f20483b - 3, 0, i, 1);
        m17229a(this.f20483b - 2, 0, i, 2);
        m17229a(this.f20483b - 1, 0, i, 3);
        m17229a(0, this.f20484c - 2, i, 4);
        m17229a(0, this.f20484c - 1, i, 5);
        m17229a(1, this.f20484c - 1, i, 6);
        m17229a(2, this.f20484c - 1, i, 7);
        m17229a(3, this.f20484c - 1, i, 8);
    }

    /* renamed from: d */
    private void m17234d(int i) {
        m17229a(this.f20483b - 1, 0, i, 1);
        m17229a(this.f20483b - 1, this.f20484c - 1, i, 2);
        m17229a(0, this.f20484c - 3, i, 3);
        m17229a(0, this.f20484c - 2, i, 4);
        m17229a(0, this.f20484c - 1, i, 5);
        m17229a(1, this.f20484c - 3, i, 6);
        m17229a(1, this.f20484c - 2, i, 7);
        m17229a(1, this.f20484c - 1, i, 8);
    }
}
