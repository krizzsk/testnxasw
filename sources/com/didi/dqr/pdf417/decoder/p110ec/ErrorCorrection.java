package com.didi.dqr.pdf417.decoder.p110ec;

import com.didi.dqr.ChecksumException;

/* renamed from: com.didi.dqr.pdf417.decoder.ec.ErrorCorrection */
public final class ErrorCorrection {

    /* renamed from: a */
    private final ModulusGF f20812a = ModulusGF.PDF417_GF;

    public int decode(int[] iArr, int i, int[] iArr2) throws ChecksumException {
        C8469a aVar = new C8469a(this.f20812a, iArr);
        int[] iArr3 = new int[i];
        int i2 = 0;
        boolean z = false;
        for (int i3 = i; i3 > 0; i3--) {
            int b = aVar.mo63480b(this.f20812a.mo63465a(i3));
            iArr3[i - i3] = b;
            if (b != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        C8469a b2 = this.f20812a.mo63470b();
        if (iArr2 != null) {
            for (int length : iArr2) {
                int a = this.f20812a.mo63465a((iArr.length - 1) - length);
                ModulusGF modulusGF = this.f20812a;
                b2 = b2.mo63483c(new C8469a(modulusGF, new int[]{modulusGF.mo63473c(0, a), 1}));
            }
        }
        C8469a[] a2 = m17551a(this.f20812a.mo63467a(i, 1), new C8469a(this.f20812a, iArr3), i);
        C8469a aVar2 = a2[0];
        C8469a aVar3 = a2[1];
        int[] a3 = m17549a(aVar2);
        int[] a4 = m17550a(aVar3, aVar2, a3);
        while (i2 < a3.length) {
            int length2 = (iArr.length - 1) - this.f20812a.mo63468b(a3[i2]);
            if (length2 >= 0) {
                iArr[length2] = this.f20812a.mo63473c(iArr[length2], a4[i2]);
                i2++;
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
        return a3.length;
    }

    /* renamed from: a */
    private C8469a[] m17551a(C8469a aVar, C8469a aVar2, int i) throws ChecksumException {
        if (aVar.mo63479b() < aVar2.mo63479b()) {
            C8469a aVar3 = aVar2;
            aVar2 = aVar;
            aVar = aVar3;
        }
        C8469a a = this.f20812a.mo63466a();
        C8469a b = this.f20812a.mo63470b();
        while (true) {
            C8469a aVar4 = r11;
            r11 = aVar;
            aVar = aVar4;
            C8469a aVar5 = b;
            C8469a aVar6 = a;
            a = aVar5;
            if (aVar.mo63479b() < i / 2) {
                int a2 = a.mo63475a(0);
                if (a2 != 0) {
                    int c = this.f20812a.mo63472c(a2);
                    return new C8469a[]{a.mo63482c(c), aVar.mo63482c(c)};
                }
                throw ChecksumException.getChecksumInstance();
            } else if (!aVar.mo63484c()) {
                C8469a a3 = this.f20812a.mo63466a();
                int c2 = this.f20812a.mo63472c(aVar.mo63475a(aVar.mo63479b()));
                while (r11.mo63479b() >= aVar.mo63479b() && !r11.mo63484c()) {
                    int b2 = r11.mo63479b() - aVar.mo63479b();
                    int d = this.f20812a.mo63474d(r11.mo63475a(r11.mo63479b()), c2);
                    a3 = a3.mo63477a(this.f20812a.mo63467a(b2, d));
                    r11 = r11.mo63481b(aVar.mo63476a(b2, d));
                }
                b = a3.mo63483c(a).mo63481b(aVar6).mo63485d();
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    /* renamed from: a */
    private int[] m17549a(C8469a aVar) throws ChecksumException {
        int b = aVar.mo63479b();
        int[] iArr = new int[b];
        int i = 0;
        for (int i2 = 1; i2 < this.f20812a.mo63471c() && i < b; i2++) {
            if (aVar.mo63480b(i2) == 0) {
                iArr[i] = this.f20812a.mo63472c(i2);
                i++;
            }
        }
        if (i == b) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    /* renamed from: a */
    private int[] m17550a(C8469a aVar, C8469a aVar2, int[] iArr) {
        int b = aVar2.mo63479b();
        int[] iArr2 = new int[b];
        for (int i = 1; i <= b; i++) {
            iArr2[b - i] = this.f20812a.mo63474d(i, aVar2.mo63475a(i));
        }
        C8469a aVar3 = new C8469a(this.f20812a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int c = this.f20812a.mo63472c(iArr[i2]);
            iArr3[i2] = this.f20812a.mo63474d(this.f20812a.mo63473c(0, aVar.mo63480b(c)), this.f20812a.mo63472c(aVar3.mo63480b(c)));
        }
        return iArr3;
    }
}
