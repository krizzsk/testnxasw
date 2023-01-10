package com.didi.dqr.common.reedsolomon;

/* renamed from: com.didi.dqr.common.reedsolomon.a */
/* compiled from: GenericGFPoly */
final class C8422a {

    /* renamed from: a */
    private final GenericGF f20456a;

    /* renamed from: b */
    private final int[] f20457b;

    C8422a(GenericGF genericGF, int[] iArr) {
        if (iArr.length != 0) {
            this.f20456a = genericGF;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f20457b = iArr;
                return;
            }
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.f20457b = new int[]{0};
                return;
            }
            int[] iArr2 = new int[(length - i)];
            this.f20457b = iArr2;
            System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int[] mo63244a() {
        return this.f20457b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo63245b() {
        return this.f20457b.length - 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo63249c() {
        return this.f20457b[0] == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo63241a(int i) {
        int[] iArr = this.f20457b;
        return iArr[(iArr.length - 1) - i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo63246b(int i) {
        if (i == 0) {
            return mo63241a(0);
        }
        if (i == 1) {
            int i2 = 0;
            for (int b : this.f20457b) {
                i2 = GenericGF.m17167b(i2, b);
            }
            return i2;
        }
        int[] iArr = this.f20457b;
        int i3 = iArr[0];
        int length = iArr.length;
        for (int i4 = 1; i4 < length; i4++) {
            i3 = GenericGF.m17167b(this.f20456a.mo63235c(i, i3), this.f20457b[i4]);
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C8422a mo63243a(C8422a aVar) {
        if (!this.f20456a.equals(aVar.f20456a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (mo63249c()) {
            return aVar;
        } else {
            if (aVar.mo63249c()) {
                return this;
            }
            int[] iArr = this.f20457b;
            int[] iArr2 = aVar.f20457b;
            if (iArr.length <= iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr4, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr4[i] = GenericGF.m17167b(iArr2[i - length], iArr[i]);
            }
            return new C8422a(this.f20456a, iArr4);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C8422a mo63247b(C8422a aVar) {
        if (!this.f20456a.equals(aVar.f20456a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (mo63249c() || aVar.mo63249c()) {
            return this.f20456a.mo63230a();
        } else {
            int[] iArr = this.f20457b;
            int length = iArr.length;
            int[] iArr2 = aVar.f20457b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    iArr3[i4] = GenericGF.m17167b(iArr3[i4], this.f20456a.mo63235c(i2, iArr2[i3]));
                }
            }
            return new C8422a(this.f20456a, iArr3);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C8422a mo63248c(int i) {
        if (i == 0) {
            return this.f20456a.mo63230a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f20457b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f20456a.mo63235c(this.f20457b[i2], i);
        }
        return new C8422a(this.f20456a, iArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C8422a mo63242a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f20456a.mo63230a();
        } else {
            int length = this.f20457b.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f20456a.mo63235c(this.f20457b[i3], i2);
            }
            return new C8422a(this.f20456a, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C8422a[] mo63250c(C8422a aVar) {
        if (!this.f20456a.equals(aVar.f20456a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (!aVar.mo63249c()) {
            C8422a a = this.f20456a.mo63230a();
            int c = this.f20456a.mo63234c(aVar.mo63241a(aVar.mo63245b()));
            C8422a aVar2 = this;
            while (aVar2.mo63245b() >= aVar.mo63245b() && !aVar2.mo63249c()) {
                int b = aVar2.mo63245b() - aVar.mo63245b();
                int c2 = this.f20456a.mo63235c(aVar2.mo63241a(aVar2.mo63245b()), c);
                C8422a a2 = aVar.mo63242a(b, c2);
                a = a.mo63243a(this.f20456a.mo63231a(b, c2));
                aVar2 = aVar2.mo63243a(a2);
            }
            return new C8422a[]{a, aVar2};
        } else {
            throw new IllegalArgumentException("Divide by 0");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(mo63245b() * 8);
        for (int b = mo63245b(); b >= 0; b--) {
            int a = mo63241a(b);
            if (a != 0) {
                if (a < 0) {
                    sb.append(" - ");
                    a = -a;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (b == 0 || a != 1) {
                    int b2 = this.f20456a.mo63232b(a);
                    if (b2 == 0) {
                        sb.append('1');
                    } else if (b2 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(b2);
                    }
                }
                if (b != 0) {
                    if (b == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(b);
                    }
                }
            }
        }
        return sb.toString();
    }
}
