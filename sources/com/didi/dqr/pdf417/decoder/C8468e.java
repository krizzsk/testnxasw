package com.didi.dqr.pdf417.decoder;

/* renamed from: com.didi.dqr.pdf417.decoder.e */
/* compiled from: DetectionResult */
final class C8468e {

    /* renamed from: a */
    private static final int f20807a = 2;

    /* renamed from: b */
    private final C8464a f20808b;

    /* renamed from: c */
    private final C8470f[] f20809c;

    /* renamed from: d */
    private C8466c f20810d;

    /* renamed from: e */
    private final int f20811e;

    C8468e(C8464a aVar, C8466c cVar) {
        this.f20808b = aVar;
        int a = aVar.mo63427a();
        this.f20811e = a;
        this.f20810d = cVar;
        this.f20809c = new C8470f[(a + 2)];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C8470f[] mo63458a() {
        m17534a(this.f20809c[0]);
        m17534a(this.f20809c[this.f20811e + 1]);
        int i = 928;
        while (true) {
            int f = m17536f();
            if (f > 0 && f < i) {
                i = f;
            }
        }
        return this.f20809c;
    }

    /* renamed from: a */
    private void m17534a(C8470f fVar) {
        if (fVar != null) {
            ((C8471g) fVar).mo63494a(this.f20808b);
        }
    }

    /* renamed from: f */
    private int m17536f() {
        int g = m17537g();
        if (g == 0) {
            return 0;
        }
        for (int i = 1; i < this.f20811e + 1; i++) {
            C8467d[] b = this.f20809c[i].mo63491b();
            for (int i2 = 0; i2 < b.length; i2++) {
                if (b[i2] != null && !b[i2].mo63444a()) {
                    m17533a(i, i2, b);
                }
            }
        }
        return g;
    }

    /* renamed from: g */
    private int m17537g() {
        m17538h();
        return m17540j() + m17539i();
    }

    /* renamed from: h */
    private void m17538h() {
        C8470f[] fVarArr = this.f20809c;
        if (fVarArr[0] != null && fVarArr[this.f20811e + 1] != null) {
            C8467d[] b = fVarArr[0].mo63491b();
            C8467d[] b2 = this.f20809c[this.f20811e + 1].mo63491b();
            for (int i = 0; i < b.length; i++) {
                if (!(b[i] == null || b2[i] == null || b[i].mo63453h() != b2[i].mo63453h())) {
                    for (int i2 = 1; i2 <= this.f20811e; i2++) {
                        C8467d dVar = this.f20809c[i2].mo63491b()[i];
                        if (dVar != null) {
                            dVar.mo63447b(b[i].mo63453h());
                            if (!dVar.mo63444a()) {
                                this.f20809c[i2].mo63491b()[i] = null;
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: i */
    private int m17539i() {
        C8470f[] fVarArr = this.f20809c;
        int i = this.f20811e;
        if (fVarArr[i + 1] == null) {
            return 0;
        }
        C8467d[] b = fVarArr[i + 1].mo63491b();
        int i2 = 0;
        for (int i3 = 0; i3 < b.length; i3++) {
            if (b[i3] != null) {
                int h = b[i3].mo63453h();
                int i4 = 0;
                for (int i5 = this.f20811e + 1; i5 > 0 && i4 < 2; i5--) {
                    C8467d dVar = this.f20809c[i5].mo63491b()[i3];
                    if (dVar != null) {
                        i4 = m17532a(h, i4, dVar);
                        if (!dVar.mo63444a()) {
                            i2++;
                        }
                    }
                }
            }
        }
        return i2;
    }

    /* renamed from: j */
    private int m17540j() {
        C8470f[] fVarArr = this.f20809c;
        if (fVarArr[0] == null) {
            return 0;
        }
        C8467d[] b = fVarArr[0].mo63491b();
        int i = 0;
        for (int i2 = 0; i2 < b.length; i2++) {
            if (b[i2] != null) {
                int h = b[i2].mo63453h();
                int i3 = 0;
                for (int i4 = 1; i4 < this.f20811e + 1 && i3 < 2; i4++) {
                    C8467d dVar = this.f20809c[i4].mo63491b()[i2];
                    if (dVar != null) {
                        i3 = m17532a(h, i3, dVar);
                        if (!dVar.mo63444a()) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    private static int m17532a(int i, int i2, C8467d dVar) {
        if (dVar == null || dVar.mo63444a()) {
            return i2;
        }
        if (!dVar.mo63445a(i)) {
            return i2 + 1;
        }
        dVar.mo63447b(i);
        return 0;
    }

    /* renamed from: a */
    private void m17533a(int i, int i2, C8467d[] dVarArr) {
        C8467d dVar = dVarArr[i2];
        C8467d[] b = this.f20809c[i - 1].mo63491b();
        C8470f[] fVarArr = this.f20809c;
        int i3 = i + 1;
        C8467d[] b2 = fVarArr[i3] != null ? fVarArr[i3].mo63491b() : b;
        C8467d[] dVarArr2 = new C8467d[14];
        dVarArr2[2] = b[i2];
        dVarArr2[3] = b2[i2];
        int i4 = 0;
        if (i2 > 0) {
            int i5 = i2 - 1;
            dVarArr2[0] = dVarArr[i5];
            dVarArr2[4] = b[i5];
            dVarArr2[5] = b2[i5];
        }
        if (i2 > 1) {
            int i6 = i2 - 2;
            dVarArr2[8] = dVarArr[i6];
            dVarArr2[10] = b[i6];
            dVarArr2[11] = b2[i6];
        }
        if (i2 < dVarArr.length - 1) {
            int i7 = i2 + 1;
            dVarArr2[1] = dVarArr[i7];
            dVarArr2[6] = b[i7];
            dVarArr2[7] = b2[i7];
        }
        if (i2 < dVarArr.length - 2) {
            int i8 = i2 + 2;
            dVarArr2[9] = dVarArr[i8];
            dVarArr2[12] = b[i8];
            dVarArr2[13] = b2[i8];
        }
        while (i4 < 14 && !m17535a(dVar, dVarArr2[i4])) {
            i4++;
        }
    }

    /* renamed from: a */
    private static boolean m17535a(C8467d dVar, C8467d dVar2) {
        if (dVar2 == null || !dVar2.mo63444a() || dVar2.mo63451f() != dVar.mo63451f()) {
            return false;
        }
        dVar.mo63447b(dVar2.mo63453h());
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo63459b() {
        return this.f20811e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo63460c() {
        return this.f20808b.mo63429c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo63461d() {
        return this.f20808b.mo63428b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo63457a(C8466c cVar) {
        this.f20810d = cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C8466c mo63462e() {
        return this.f20810d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo63456a(int i, C8470f fVar) {
        this.f20809c[i] = fVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C8470f mo63455a(int i) {
        return this.f20809c[i];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0085, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0086, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0089, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r10 = this;
            com.didi.dqr.pdf417.decoder.f[] r0 = r10.f20809c
            r1 = 0
            r2 = r0[r1]
            r3 = 1
            if (r2 != 0) goto L_0x000d
            int r2 = r10.f20811e
            int r2 = r2 + r3
            r2 = r0[r2]
        L_0x000d:
            java.util.Formatter r0 = new java.util.Formatter
            r0.<init>()
            r4 = 0
        L_0x0013:
            com.didi.dqr.pdf417.decoder.d[] r5 = r2.mo63491b()     // Catch:{ all -> 0x007e }
            int r5 = r5.length     // Catch:{ all -> 0x007e }
            if (r4 >= r5) goto L_0x0076
            java.lang.String r5 = "CW %3d:"
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ all -> 0x007e }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x007e }
            r6[r1] = r7     // Catch:{ all -> 0x007e }
            r0.format(r5, r6)     // Catch:{ all -> 0x007e }
            r5 = 0
        L_0x0028:
            int r6 = r10.f20811e     // Catch:{ all -> 0x007e }
            r7 = 2
            int r6 = r6 + r7
            if (r5 >= r6) goto L_0x006c
            com.didi.dqr.pdf417.decoder.f[] r6 = r10.f20809c     // Catch:{ all -> 0x007e }
            r6 = r6[r5]     // Catch:{ all -> 0x007e }
            java.lang.String r8 = "    |   "
            if (r6 != 0) goto L_0x003c
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x007e }
            r0.format(r8, r6)     // Catch:{ all -> 0x007e }
            goto L_0x0069
        L_0x003c:
            com.didi.dqr.pdf417.decoder.f[] r6 = r10.f20809c     // Catch:{ all -> 0x007e }
            r6 = r6[r5]     // Catch:{ all -> 0x007e }
            com.didi.dqr.pdf417.decoder.d[] r6 = r6.mo63491b()     // Catch:{ all -> 0x007e }
            r6 = r6[r4]     // Catch:{ all -> 0x007e }
            if (r6 != 0) goto L_0x004e
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x007e }
            r0.format(r8, r6)     // Catch:{ all -> 0x007e }
            goto L_0x0069
        L_0x004e:
            java.lang.String r8 = " %3d|%3d"
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x007e }
            int r9 = r6.mo63453h()     // Catch:{ all -> 0x007e }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x007e }
            r7[r1] = r9     // Catch:{ all -> 0x007e }
            int r6 = r6.mo63452g()     // Catch:{ all -> 0x007e }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x007e }
            r7[r3] = r6     // Catch:{ all -> 0x007e }
            r0.format(r8, r7)     // Catch:{ all -> 0x007e }
        L_0x0069:
            int r5 = r5 + 1
            goto L_0x0028
        L_0x006c:
            java.lang.String r5 = "%n"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x007e }
            r0.format(r5, r6)     // Catch:{ all -> 0x007e }
            int r4 = r4 + 1
            goto L_0x0013
        L_0x0076:
            java.lang.String r1 = r0.toString()     // Catch:{ all -> 0x007e }
            r0.close()
            return r1
        L_0x007e:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0080 }
        L_0x0080:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x0089:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.pdf417.decoder.C8468e.toString():java.lang.String");
    }
}
