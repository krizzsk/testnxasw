package com.didi.dqr.common.reedsolomon;

public final class ReedSolomonDecoder {

    /* renamed from: a */
    private final GenericGF f20453a;

    public ReedSolomonDecoder(GenericGF genericGF) {
        this.f20453a = genericGF;
    }

    public void decode(int[] iArr, int i) throws ReedSolomonException {
        C8422a aVar = new C8422a(this.f20453a, iArr);
        int[] iArr2 = new int[i];
        int i2 = 0;
        boolean z = true;
        for (int i3 = 0; i3 < i; i3++) {
            GenericGF genericGF = this.f20453a;
            int b = aVar.mo63246b(genericGF.mo63229a(genericGF.getGeneratorBase() + i3));
            iArr2[(i - 1) - i3] = b;
            if (b != 0) {
                z = false;
            }
        }
        if (!z) {
            C8422a[] a = m17177a(this.f20453a.mo63231a(i, 1), new C8422a(this.f20453a, iArr2), i);
            C8422a aVar2 = a[0];
            C8422a aVar3 = a[1];
            int[] a2 = m17175a(aVar2);
            int[] a3 = m17176a(aVar3, a2);
            while (i2 < a2.length) {
                int length = (iArr.length - 1) - this.f20453a.mo63232b(a2[i2]);
                if (length >= 0) {
                    iArr[length] = GenericGF.m17167b(iArr[length], a3[i2]);
                    i2++;
                } else {
                    throw new ReedSolomonException("Bad error location");
                }
            }
        }
    }

    /* renamed from: a */
    private C8422a[] m17177a(C8422a aVar, C8422a aVar2, int i) throws ReedSolomonException {
        if (aVar.mo63245b() < aVar2.mo63245b()) {
            C8422a aVar3 = aVar2;
            aVar2 = aVar;
            aVar = aVar3;
        }
        C8422a a = this.f20453a.mo63230a();
        C8422a b = this.f20453a.mo63233b();
        do {
            C8422a aVar4 = r11;
            r11 = aVar;
            aVar = aVar4;
            C8422a aVar5 = b;
            C8422a aVar6 = a;
            a = aVar5;
            if (aVar.mo63245b() < i / 2) {
                int a2 = a.mo63241a(0);
                if (a2 != 0) {
                    int c = this.f20453a.mo63234c(a2);
                    return new C8422a[]{a.mo63248c(c), aVar.mo63248c(c)};
                }
                throw new ReedSolomonException("sigmaTilde(0) was zero");
            } else if (!aVar.mo63249c()) {
                C8422a a3 = this.f20453a.mo63230a();
                int c2 = this.f20453a.mo63234c(aVar.mo63241a(aVar.mo63245b()));
                while (r11.mo63245b() >= aVar.mo63245b() && !r11.mo63249c()) {
                    int b2 = r11.mo63245b() - aVar.mo63245b();
                    int c3 = this.f20453a.mo63235c(r11.mo63241a(r11.mo63245b()), c2);
                    a3 = a3.mo63243a(this.f20453a.mo63231a(b2, c3));
                    r11 = r11.mo63243a(aVar.mo63242a(b2, c3));
                }
                b = a3.mo63247b(a).mo63243a(aVar6);
            } else {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
        } while (r11.mo63245b() < aVar.mo63245b());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    /* renamed from: a */
    private int[] m17175a(C8422a aVar) throws ReedSolomonException {
        int b = aVar.mo63245b();
        int i = 0;
        if (b == 1) {
            return new int[]{aVar.mo63241a(1)};
        }
        int[] iArr = new int[b];
        for (int i2 = 1; i2 < this.f20453a.getSize() && i < b; i2++) {
            if (aVar.mo63246b(i2) == 0) {
                iArr[i] = this.f20453a.mo63234c(i2);
                i++;
            }
        }
        if (i == b) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    /* renamed from: a */
    private int[] m17176a(C8422a aVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int c = this.f20453a.mo63234c(iArr[i]);
            int i2 = 1;
            for (int i3 = 0; i3 < length; i3++) {
                if (i != i3) {
                    int c2 = this.f20453a.mo63235c(iArr[i3], c);
                    i2 = this.f20453a.mo63235c(i2, (c2 & 1) == 0 ? c2 | 1 : c2 & -2);
                }
            }
            iArr2[i] = this.f20453a.mo63235c(aVar.mo63246b(c), this.f20453a.mo63234c(i2));
            if (this.f20453a.getGeneratorBase() != 0) {
                iArr2[i] = this.f20453a.mo63235c(iArr2[i], c);
            }
        }
        return iArr2;
    }
}
