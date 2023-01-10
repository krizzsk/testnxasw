package com.didi.dqr.pdf417.decoder;

import com.didi.dqr.ResultPoint;

/* renamed from: com.didi.dqr.pdf417.decoder.g */
/* compiled from: DetectionResultRowIndicatorColumn */
final class C8471g extends C8470f {

    /* renamed from: a */
    private final boolean f20823a;

    C8471g(C8466c cVar, boolean z) {
        super(cVar);
        this.f20823a = z;
    }

    /* renamed from: f */
    private void m17581f() {
        for (C8467d dVar : mo63491b()) {
            if (dVar != null) {
                dVar.mo63446b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo63494a(C8464a aVar) {
        C8467d[] b = mo63491b();
        m17581f();
        m17579a(b, aVar);
        C8466c a = mo63487a();
        ResultPoint e = this.f20823a ? a.mo63440e() : a.mo63441f();
        ResultPoint g = this.f20823a ? a.mo63442g() : a.mo63443h();
        int b2 = mo63490b((int) e.getY());
        int b3 = mo63490b((int) g.getY());
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        while (b2 < b3) {
            if (b[b2] != null) {
                C8467d dVar = b[b2];
                int h = dVar.mo63453h() - i;
                if (h == 0) {
                    i2++;
                } else {
                    if (h == 1) {
                        i3 = Math.max(i3, i2);
                        i = dVar.mo63453h();
                    } else if (h < 0 || dVar.mo63453h() >= aVar.mo63429c() || h > b2) {
                        b[b2] = null;
                    } else {
                        if (i3 > 2) {
                            h *= i3 - 2;
                        }
                        boolean z = h >= b2;
                        for (int i4 = 1; i4 <= h && !z; i4++) {
                            z = b[b2 - i4] != null;
                        }
                        if (z) {
                            b[b2] = null;
                        } else {
                            i = dVar.mo63453h();
                        }
                    }
                    i2 = 1;
                }
            }
            b2++;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int[] mo63495c() {
        int h;
        C8464a d = mo63496d();
        if (d == null) {
            return null;
        }
        m17580b(d);
        int c = d.mo63429c();
        int[] iArr = new int[c];
        for (C8467d dVar : mo63491b()) {
            if (dVar != null && (h = dVar.mo63453h()) < c) {
                iArr[h] = iArr[h] + 1;
            }
        }
        return iArr;
    }

    /* renamed from: b */
    private void m17580b(C8464a aVar) {
        C8466c a = mo63487a();
        ResultPoint e = this.f20823a ? a.mo63440e() : a.mo63441f();
        ResultPoint g = this.f20823a ? a.mo63442g() : a.mo63443h();
        int b = mo63490b((int) g.getY());
        C8467d[] b2 = mo63491b();
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        for (int b3 = mo63490b((int) e.getY()); b3 < b; b3++) {
            if (b2[b3] != null) {
                C8467d dVar = b2[b3];
                dVar.mo63446b();
                int h = dVar.mo63453h() - i;
                if (h == 0) {
                    i2++;
                } else {
                    if (h == 1) {
                        i3 = Math.max(i3, i2);
                        i = dVar.mo63453h();
                    } else if (dVar.mo63453h() >= aVar.mo63429c()) {
                        b2[b3] = null;
                    } else {
                        i = dVar.mo63453h();
                    }
                    i2 = 1;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C8464a mo63496d() {
        C8467d[] b = mo63491b();
        C8465b bVar = new C8465b();
        C8465b bVar2 = new C8465b();
        C8465b bVar3 = new C8465b();
        C8465b bVar4 = new C8465b();
        for (C8467d dVar : b) {
            if (dVar != null) {
                dVar.mo63446b();
                int g = dVar.mo63452g() % 30;
                int h = dVar.mo63453h();
                if (!this.f20823a) {
                    h += 2;
                }
                int i = h % 3;
                if (i == 0) {
                    bVar2.mo63432a((g * 3) + 1);
                } else if (i == 1) {
                    bVar4.mo63432a(g / 3);
                    bVar3.mo63432a(g % 3);
                } else if (i == 2) {
                    bVar.mo63432a(g + 1);
                }
            }
        }
        if (bVar.mo63433a().length == 0 || bVar2.mo63433a().length == 0 || bVar3.mo63433a().length == 0 || bVar4.mo63433a().length == 0 || bVar.mo63433a()[0] < 1 || bVar2.mo63433a()[0] + bVar3.mo63433a()[0] < 3 || bVar2.mo63433a()[0] + bVar3.mo63433a()[0] > 90) {
            return null;
        }
        C8464a aVar = new C8464a(bVar.mo63433a()[0], bVar2.mo63433a()[0], bVar3.mo63433a()[0], bVar4.mo63433a()[0]);
        m17579a(b, aVar);
        return aVar;
    }

    /* renamed from: a */
    private void m17579a(C8467d[] dVarArr, C8464a aVar) {
        for (int i = 0; i < dVarArr.length; i++) {
            C8467d dVar = dVarArr[i];
            if (dVarArr[i] != null) {
                int g = dVar.mo63452g() % 30;
                int h = dVar.mo63453h();
                if (h > aVar.mo63429c()) {
                    dVarArr[i] = null;
                } else {
                    if (!this.f20823a) {
                        h += 2;
                    }
                    int i2 = h % 3;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2 && g + 1 != aVar.mo63427a()) {
                                dVarArr[i] = null;
                            }
                        } else if (g / 3 != aVar.mo63428b() || g % 3 != aVar.mo63431e()) {
                            dVarArr[i] = null;
                        }
                    } else if ((g * 3) + 1 != aVar.mo63430d()) {
                        dVarArr[i] = null;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo63497e() {
        return this.f20823a;
    }

    public String toString() {
        return "IsLeft: " + this.f20823a + 10 + super.toString();
    }
}
