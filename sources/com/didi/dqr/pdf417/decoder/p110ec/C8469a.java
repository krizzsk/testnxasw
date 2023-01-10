package com.didi.dqr.pdf417.decoder.p110ec;

/* renamed from: com.didi.dqr.pdf417.decoder.ec.a */
/* compiled from: ModulusPoly */
final class C8469a {

    /* renamed from: a */
    private final ModulusGF f20818a;

    /* renamed from: b */
    private final int[] f20819b;

    C8469a(ModulusGF modulusGF, int[] iArr) {
        if (iArr.length != 0) {
            this.f20818a = modulusGF;
            int length = iArr.length;
            if (length <= 1 || iArr[0] != 0) {
                this.f20819b = iArr;
                return;
            }
            int i = 1;
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.f20819b = new int[]{0};
                return;
            }
            int[] iArr2 = new int[(length - i)];
            this.f20819b = iArr2;
            System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int[] mo63478a() {
        return this.f20819b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo63479b() {
        return this.f20819b.length - 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo63484c() {
        return this.f20819b[0] == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo63475a(int i) {
        int[] iArr = this.f20819b;
        return iArr[(iArr.length - 1) - i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo63480b(int i) {
        if (i == 0) {
            return mo63475a(0);
        }
        if (i == 1) {
            int i2 = 0;
            for (int b : this.f20819b) {
                i2 = this.f20818a.mo63469b(i2, b);
            }
            return i2;
        }
        int[] iArr = this.f20819b;
        int i3 = iArr[0];
        int length = iArr.length;
        for (int i4 = 1; i4 < length; i4++) {
            ModulusGF modulusGF = this.f20818a;
            i3 = modulusGF.mo63469b(modulusGF.mo63474d(i, i3), this.f20819b[i4]);
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C8469a mo63477a(C8469a aVar) {
        if (!this.f20818a.equals(aVar.f20818a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (mo63484c()) {
            return aVar;
        } else {
            if (aVar.mo63484c()) {
                return this;
            }
            int[] iArr = this.f20819b;
            int[] iArr2 = aVar.f20819b;
            if (iArr.length <= iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr4, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr4[i] = this.f20818a.mo63469b(iArr2[i - length], iArr[i]);
            }
            return new C8469a(this.f20818a, iArr4);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C8469a mo63481b(C8469a aVar) {
        if (!this.f20818a.equals(aVar.f20818a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (aVar.mo63484c()) {
            return this;
        } else {
            return mo63477a(aVar.mo63485d());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C8469a mo63483c(C8469a aVar) {
        if (!this.f20818a.equals(aVar.f20818a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (mo63484c() || aVar.mo63484c()) {
            return this.f20818a.mo63466a();
        } else {
            int[] iArr = this.f20819b;
            int length = iArr.length;
            int[] iArr2 = aVar.f20819b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    ModulusGF modulusGF = this.f20818a;
                    iArr3[i4] = modulusGF.mo63469b(iArr3[i4], modulusGF.mo63474d(i2, iArr2[i3]));
                }
            }
            return new C8469a(this.f20818a, iArr3);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C8469a mo63485d() {
        int length = this.f20819b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.f20818a.mo63473c(0, this.f20819b[i]);
        }
        return new C8469a(this.f20818a, iArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C8469a mo63482c(int i) {
        if (i == 0) {
            return this.f20818a.mo63466a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.f20819b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f20818a.mo63474d(this.f20819b[i2], i);
        }
        return new C8469a(this.f20818a, iArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C8469a mo63476a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f20818a.mo63466a();
        } else {
            int length = this.f20819b.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f20818a.mo63474d(this.f20819b[i3], i2);
            }
            return new C8469a(this.f20818a, iArr);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(mo63479b() * 8);
        for (int b = mo63479b(); b >= 0; b--) {
            int a = mo63475a(b);
            if (a != 0) {
                if (a < 0) {
                    sb.append(" - ");
                    a = -a;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (b == 0 || a != 1) {
                    sb.append(a);
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
