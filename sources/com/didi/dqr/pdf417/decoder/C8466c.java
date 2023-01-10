package com.didi.dqr.pdf417.decoder;

import com.didi.dqr.NotFoundException;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitMatrix;

/* renamed from: com.didi.dqr.pdf417.decoder.c */
/* compiled from: BoundingBox */
final class C8466c {

    /* renamed from: a */
    private final BitMatrix f20792a;

    /* renamed from: b */
    private final ResultPoint f20793b;

    /* renamed from: c */
    private final ResultPoint f20794c;

    /* renamed from: d */
    private final ResultPoint f20795d;

    /* renamed from: e */
    private final ResultPoint f20796e;

    /* renamed from: f */
    private final int f20797f;

    /* renamed from: g */
    private final int f20798g;

    /* renamed from: h */
    private final int f20799h;

    /* renamed from: i */
    private final int f20800i;

    C8466c(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        boolean z = false;
        boolean z2 = resultPoint == null || resultPoint2 == null;
        z = (resultPoint3 == null || resultPoint4 == null) ? true : z;
        if (!z2 || !z) {
            if (z2) {
                resultPoint = new ResultPoint(0.0f, resultPoint3.getY());
                resultPoint2 = new ResultPoint(0.0f, resultPoint4.getY());
            } else if (z) {
                resultPoint3 = new ResultPoint((float) (bitMatrix.getWidth() - 1), resultPoint.getY());
                resultPoint4 = new ResultPoint((float) (bitMatrix.getWidth() - 1), resultPoint2.getY());
            }
            this.f20792a = bitMatrix;
            this.f20793b = resultPoint;
            this.f20794c = resultPoint2;
            this.f20795d = resultPoint3;
            this.f20796e = resultPoint4;
            this.f20797f = (int) Math.min(resultPoint.getX(), resultPoint2.getX());
            this.f20798g = (int) Math.max(resultPoint3.getX(), resultPoint4.getX());
            this.f20799h = (int) Math.min(resultPoint.getY(), resultPoint3.getY());
            this.f20800i = (int) Math.max(resultPoint2.getY(), resultPoint4.getY());
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    C8466c(C8466c cVar) {
        this.f20792a = cVar.f20792a;
        this.f20793b = cVar.f20793b;
        this.f20794c = cVar.f20794c;
        this.f20795d = cVar.f20795d;
        this.f20796e = cVar.f20796e;
        this.f20797f = cVar.f20797f;
        this.f20798g = cVar.f20798g;
        this.f20799h = cVar.f20799h;
        this.f20800i = cVar.f20800i;
    }

    /* renamed from: a */
    static C8466c m17512a(C8466c cVar, C8466c cVar2) throws NotFoundException {
        if (cVar == null) {
            return cVar2;
        }
        return cVar2 == null ? cVar : new C8466c(cVar.f20792a, cVar.f20793b, cVar.f20794c, cVar2.f20795d, cVar2.f20796e);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.dqr.pdf417.decoder.C8466c mo63436a(int r13, int r14, boolean r15) throws com.didi.dqr.NotFoundException {
        /*
            r12 = this;
            com.didi.dqr.ResultPoint r0 = r12.f20793b
            com.didi.dqr.ResultPoint r1 = r12.f20794c
            com.didi.dqr.ResultPoint r2 = r12.f20795d
            com.didi.dqr.ResultPoint r3 = r12.f20796e
            if (r13 <= 0) goto L_0x0029
            if (r15 == 0) goto L_0x000e
            r4 = r0
            goto L_0x000f
        L_0x000e:
            r4 = r2
        L_0x000f:
            float r5 = r4.getY()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L_0x0018
            r5 = 0
        L_0x0018:
            com.didi.dqr.ResultPoint r13 = new com.didi.dqr.ResultPoint
            float r4 = r4.getX()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L_0x0026
            r8 = r13
            goto L_0x002a
        L_0x0026:
            r10 = r13
            r8 = r0
            goto L_0x002b
        L_0x0029:
            r8 = r0
        L_0x002a:
            r10 = r2
        L_0x002b:
            if (r14 <= 0) goto L_0x005b
            if (r15 == 0) goto L_0x0032
            com.didi.dqr.ResultPoint r13 = r12.f20794c
            goto L_0x0034
        L_0x0032:
            com.didi.dqr.ResultPoint r13 = r12.f20796e
        L_0x0034:
            float r0 = r13.getY()
            int r0 = (int) r0
            int r0 = r0 + r14
            com.didi.dqr.common.BitMatrix r14 = r12.f20792a
            int r14 = r14.getHeight()
            if (r0 < r14) goto L_0x004a
            com.didi.dqr.common.BitMatrix r14 = r12.f20792a
            int r14 = r14.getHeight()
            int r0 = r14 + -1
        L_0x004a:
            com.didi.dqr.ResultPoint r14 = new com.didi.dqr.ResultPoint
            float r13 = r13.getX()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L_0x0058
            r9 = r14
            goto L_0x005c
        L_0x0058:
            r11 = r14
            r9 = r1
            goto L_0x005d
        L_0x005b:
            r9 = r1
        L_0x005c:
            r11 = r3
        L_0x005d:
            com.didi.dqr.pdf417.decoder.c r13 = new com.didi.dqr.pdf417.decoder.c
            com.didi.dqr.common.BitMatrix r7 = r12.f20792a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.pdf417.decoder.C8466c.mo63436a(int, int, boolean):com.didi.dqr.pdf417.decoder.c");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo63435a() {
        return this.f20797f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo63437b() {
        return this.f20798g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo63438c() {
        return this.f20799h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo63439d() {
        return this.f20800i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public ResultPoint mo63440e() {
        return this.f20793b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public ResultPoint mo63441f() {
        return this.f20795d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public ResultPoint mo63442g() {
        return this.f20794c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public ResultPoint mo63443h() {
        return this.f20796e;
    }
}
