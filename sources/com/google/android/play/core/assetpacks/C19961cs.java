package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C20030ag;

/* renamed from: com.google.android.play.core.assetpacks.cs */
final class C19961cs {

    /* renamed from: a */
    private static final C20030ag f55887a = new C20030ag("ExtractorTaskFinder");

    /* renamed from: b */
    private final C19958cp f55888b;

    /* renamed from: c */
    private final C19917bb f55889c;

    /* renamed from: d */
    private final C19926bk f55890d;

    C19961cs(C19958cp cpVar, C19917bb bbVar, C19926bk bkVar) {
        this.f55888b = cpVar;
        this.f55889c = bbVar;
        this.f55890d = bkVar;
    }

    /* renamed from: a */
    private final boolean m41985a(C19955cm cmVar, C19956cn cnVar) {
        C19917bb bbVar = this.f55889c;
        C19954cl clVar = cmVar.f55867c;
        String str = clVar.f55860a;
        return bbVar.mo164115e(str, cmVar.f55866b, clVar.f55861b, cnVar.f55868a).exists();
    }

    /* renamed from: a */
    private static boolean m41986a(C19956cn cnVar) {
        int i = cnVar.f55873f;
        return i == 1 || i == 2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: com.google.android.play.core.assetpacks.dh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: com.google.android.play.core.assetpacks.dh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: com.google.android.play.core.assetpacks.de} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: com.google.android.play.core.assetpacks.de} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: com.google.android.play.core.assetpacks.du} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: com.google.android.play.core.assetpacks.du} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: com.google.android.play.core.assetpacks.dn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: com.google.android.play.core.assetpacks.dn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: com.google.android.play.core.assetpacks.dn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: com.google.android.play.core.assetpacks.du} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v6, resolved type: com.google.android.play.core.assetpacks.de} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: com.google.android.play.core.assetpacks.dh} */
    /* JADX WARNING: type inference failed for: r0v11, types: [com.google.android.play.core.assetpacks.cr] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x040f, code lost:
        if (r0 != null) goto L_0x0411;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        f55887a.mo164267a("Found final move task for session %s with pack %s.", java.lang.Integer.valueOf(r4.f55865a), r4.f55867c.f55860a);
        r11 = r4.f55865a;
        r8 = r4.f55867c;
        r10 = new com.google.android.play.core.assetpacks.C19977dh(r11, r8.f55860a, r4.f55866b, r8.f55861b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0218, code lost:
        r0 = f55887a;
        r4 = new java.lang.Object[r8];
        r4[r7] = java.lang.Integer.valueOf(r6.f55865a);
        r4[1] = r6.f55867c.f55860a;
        r4[2] = r10.f55868a;
        r0.mo164267a("Found extraction task for patch for session %s, pack %s, slice %s.", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r11 = r1.f55889c;
        r4 = r6.f55867c;
        r0 = new java.io.FileInputStream(r11.mo164115e(r4.f55860a, r6.f55866b, r4.f55861b, r10.f55868a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        r9 = r6.f55865a;
        r11 = r6.f55867c;
        r19 = new com.google.android.play.core.assetpacks.C19934bs(r9, r11.f55860a, r6.f55866b, r11.f55861b, r10.f55868a, 0, 0, 1, r11.f55863d, r11.f55862c, r0);
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.assetpacks.C19960cr mo164177a() {
        /*
            r34 = this;
            r1 = r34
            com.google.android.play.core.assetpacks.cp r0 = r1.f55888b     // Catch:{ all -> 0x0424 }
            r0.mo164162a()     // Catch:{ all -> 0x0424 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0424 }
            r2.<init>()     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cp r0 = r1.f55888b     // Catch:{ all -> 0x0424 }
            java.util.Map r0 = r0.mo164172c()     // Catch:{ all -> 0x0424 }
            java.util.Collection r0 = r0.values()     // Catch:{ all -> 0x0424 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0424 }
        L_0x001a:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0424 }
            if (r3 == 0) goto L_0x0034
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cm r3 = (com.google.android.play.core.assetpacks.C19955cm) r3     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r4 = r3.f55867c     // Catch:{ all -> 0x0424 }
            int r4 = r4.f55862c     // Catch:{ all -> 0x0424 }
            boolean r4 = com.google.android.play.core.assetpacks.C19971db.m42019c(r4)     // Catch:{ all -> 0x0424 }
            if (r4 == 0) goto L_0x001a
            r2.add(r3)     // Catch:{ all -> 0x0424 }
            goto L_0x001a
        L_0x0034:
            boolean r0 = r2.isEmpty()     // Catch:{ all -> 0x0424 }
            if (r0 != 0) goto L_0x0417
            java.util.Iterator r0 = r2.iterator()     // Catch:{ all -> 0x0424 }
        L_0x003e:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x0424 }
            r5 = 2
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x00ac
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cm r4 = (com.google.android.play.core.assetpacks.C19955cm) r4     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.bb r8 = r1.f55889c     // Catch:{ IOException -> 0x008d }
            com.google.android.play.core.assetpacks.cl r9 = r4.f55867c     // Catch:{ IOException -> 0x008d }
            java.lang.String r10 = r9.f55860a     // Catch:{ IOException -> 0x008d }
            int r11 = r4.f55866b     // Catch:{ IOException -> 0x008d }
            long r12 = r9.f55861b     // Catch:{ IOException -> 0x008d }
            int r8 = r8.mo164109d(r10, r11, r12)     // Catch:{ IOException -> 0x008d }
            com.google.android.play.core.assetpacks.cl r9 = r4.f55867c     // Catch:{ IOException -> 0x008d }
            java.util.List<com.google.android.play.core.assetpacks.cn> r9 = r9.f55864e     // Catch:{ IOException -> 0x008d }
            int r9 = r9.size()     // Catch:{ IOException -> 0x008d }
            if (r8 != r9) goto L_0x003e
            com.google.android.play.core.internal.ag r0 = f55887a     // Catch:{ all -> 0x0424 }
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x0424 }
            int r9 = r4.f55865a     // Catch:{ all -> 0x0424 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0424 }
            r8[r7] = r9     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r9 = r4.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r9 = r9.f55860a     // Catch:{ all -> 0x0424 }
            r8[r6] = r9     // Catch:{ all -> 0x0424 }
            java.lang.String r9 = "Found final move task for session %s with pack %s."
            r0.mo164267a(r9, r8)     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.dh r0 = new com.google.android.play.core.assetpacks.dh     // Catch:{ all -> 0x0424 }
            int r11 = r4.f55865a     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r8 = r4.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r12 = r8.f55860a     // Catch:{ all -> 0x0424 }
            int r13 = r4.f55866b     // Catch:{ all -> 0x0424 }
            long r14 = r8.f55861b     // Catch:{ all -> 0x0424 }
            r10 = r0
            r10.<init>(r11, r12, r13, r14)     // Catch:{ all -> 0x0424 }
            goto L_0x00ad
        L_0x008d:
            r0 = move-exception
            com.google.android.play.core.assetpacks.bv r2 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0424 }
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ all -> 0x0424 }
            int r5 = r4.f55865a     // Catch:{ all -> 0x0424 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0424 }
            r3[r7] = r5     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r5 = r4.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r5 = r5.f55860a     // Catch:{ all -> 0x0424 }
            r3[r6] = r5     // Catch:{ all -> 0x0424 }
            java.lang.String r5 = "Failed to check number of completed merges for session %s, pack %s"
            java.lang.String r3 = java.lang.String.format(r5, r3)     // Catch:{ all -> 0x0424 }
            int r4 = r4.f55865a     // Catch:{ all -> 0x0424 }
            r2.<init>(r3, r0, r4)     // Catch:{ all -> 0x0424 }
            throw r2     // Catch:{ all -> 0x0424 }
        L_0x00ac:
            r0 = 0
        L_0x00ad:
            if (r0 != 0) goto L_0x0411
            java.util.Iterator r0 = r2.iterator()     // Catch:{ all -> 0x0424 }
        L_0x00b3:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x0424 }
            r8 = 3
            if (r4 == 0) goto L_0x0137
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cm r4 = (com.google.android.play.core.assetpacks.C19955cm) r4     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r9 = r4.f55867c     // Catch:{ all -> 0x0424 }
            int r9 = r9.f55862c     // Catch:{ all -> 0x0424 }
            boolean r9 = com.google.android.play.core.assetpacks.C19971db.m42019c(r9)     // Catch:{ all -> 0x0424 }
            if (r9 == 0) goto L_0x00b3
            com.google.android.play.core.assetpacks.cl r9 = r4.f55867c     // Catch:{ all -> 0x0424 }
            java.util.List<com.google.android.play.core.assetpacks.cn> r9 = r9.f55864e     // Catch:{ all -> 0x0424 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0424 }
        L_0x00d2:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x0424 }
            if (r10 == 0) goto L_0x00b3
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cn r10 = (com.google.android.play.core.assetpacks.C19956cn) r10     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.bb r11 = r1.f55889c     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r12 = r4.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r13 = r12.f55860a     // Catch:{ all -> 0x0424 }
            int r14 = r4.f55866b     // Catch:{ all -> 0x0424 }
            long r5 = r12.f55861b     // Catch:{ all -> 0x0424 }
            java.lang.String r15 = r10.f55868a     // Catch:{ all -> 0x0424 }
            r12 = r13
            r13 = r14
            r16 = r15
            r14 = r5
            java.io.File r5 = r11.mo164103b(r12, r13, r14, r16)     // Catch:{ all -> 0x0424 }
            boolean r5 = r5.exists()     // Catch:{ all -> 0x0424 }
            if (r5 == 0) goto L_0x0134
            com.google.android.play.core.internal.ag r0 = f55887a     // Catch:{ all -> 0x0424 }
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ all -> 0x0424 }
            int r6 = r4.f55865a     // Catch:{ all -> 0x0424 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0424 }
            r5[r7] = r6     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r6 = r4.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r6 = r6.f55860a     // Catch:{ all -> 0x0424 }
            r9 = 1
            r5[r9] = r6     // Catch:{ all -> 0x0424 }
            java.lang.String r6 = r10.f55868a     // Catch:{ all -> 0x0424 }
            r9 = 2
            r5[r9] = r6     // Catch:{ all -> 0x0424 }
            java.lang.String r6 = "Found merge task for session %s with pack %s and slice %s."
            r0.mo164267a(r6, r5)     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.de r0 = new com.google.android.play.core.assetpacks.de     // Catch:{ all -> 0x0424 }
            int r5 = r4.f55865a     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r6 = r4.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r9 = r6.f55860a     // Catch:{ all -> 0x0424 }
            int r4 = r4.f55866b     // Catch:{ all -> 0x0424 }
            long r11 = r6.f55861b     // Catch:{ all -> 0x0424 }
            java.lang.String r6 = r10.f55868a     // Catch:{ all -> 0x0424 }
            r19 = r0
            r20 = r5
            r21 = r9
            r22 = r4
            r23 = r11
            r25 = r6
            r19.<init>(r20, r21, r22, r23, r25)     // Catch:{ all -> 0x0424 }
            goto L_0x0138
        L_0x0134:
            r5 = 2
            r6 = 1
            goto L_0x00d2
        L_0x0137:
            r0 = 0
        L_0x0138:
            if (r0 != 0) goto L_0x0411
            java.util.Iterator r0 = r2.iterator()     // Catch:{ all -> 0x0424 }
        L_0x013e:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x0424 }
            if (r4 == 0) goto L_0x01d8
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cm r4 = (com.google.android.play.core.assetpacks.C19955cm) r4     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r5 = r4.f55867c     // Catch:{ all -> 0x0424 }
            int r5 = r5.f55862c     // Catch:{ all -> 0x0424 }
            boolean r5 = com.google.android.play.core.assetpacks.C19971db.m42019c(r5)     // Catch:{ all -> 0x0424 }
            if (r5 == 0) goto L_0x013e
            com.google.android.play.core.assetpacks.cl r5 = r4.f55867c     // Catch:{ all -> 0x0424 }
            java.util.List<com.google.android.play.core.assetpacks.cn> r5 = r5.f55864e     // Catch:{ all -> 0x0424 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0424 }
        L_0x015c:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0424 }
            if (r6 == 0) goto L_0x013e
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cn r6 = (com.google.android.play.core.assetpacks.C19956cn) r6     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.dr r16 = new com.google.android.play.core.assetpacks.dr     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.bb r10 = r1.f55889c     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r9 = r4.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r11 = r9.f55860a     // Catch:{ all -> 0x0424 }
            int r12 = r4.f55866b     // Catch:{ all -> 0x0424 }
            long r13 = r9.f55861b     // Catch:{ all -> 0x0424 }
            java.lang.String r15 = r6.f55868a     // Catch:{ all -> 0x0424 }
            r9 = r16
            r9.<init>(r10, r11, r12, r13, r15)     // Catch:{ all -> 0x0424 }
            boolean r9 = r16.mo164221d()     // Catch:{ all -> 0x0424 }
            if (r9 == 0) goto L_0x015c
            com.google.android.play.core.assetpacks.bb r10 = r1.f55889c     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r9 = r4.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r11 = r9.f55860a     // Catch:{ all -> 0x0424 }
            int r12 = r4.f55866b     // Catch:{ all -> 0x0424 }
            long r13 = r9.f55861b     // Catch:{ all -> 0x0424 }
            java.lang.String r15 = r6.f55868a     // Catch:{ all -> 0x0424 }
            java.io.File r9 = r10.mo164096a((java.lang.String) r11, (int) r12, (long) r13, (java.lang.String) r15)     // Catch:{ all -> 0x0424 }
            boolean r9 = r9.exists()     // Catch:{ all -> 0x0424 }
            if (r9 == 0) goto L_0x015c
            com.google.android.play.core.internal.ag r0 = f55887a     // Catch:{ all -> 0x0424 }
            java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ all -> 0x0424 }
            int r9 = r4.f55865a     // Catch:{ all -> 0x0424 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0424 }
            r5[r7] = r9     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r9 = r4.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r9 = r9.f55860a     // Catch:{ all -> 0x0424 }
            r10 = 1
            r5[r10] = r9     // Catch:{ all -> 0x0424 }
            java.lang.String r9 = r6.f55868a     // Catch:{ all -> 0x0424 }
            r10 = 2
            r5[r10] = r9     // Catch:{ all -> 0x0424 }
            java.lang.String r9 = "Found verify task for session %s with pack %s and slice %s."
            r0.mo164267a(r9, r5)     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.du r0 = new com.google.android.play.core.assetpacks.du     // Catch:{ all -> 0x0424 }
            int r5 = r4.f55865a     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r9 = r4.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r10 = r9.f55860a     // Catch:{ all -> 0x0424 }
            int r4 = r4.f55866b     // Catch:{ all -> 0x0424 }
            long r11 = r9.f55861b     // Catch:{ all -> 0x0424 }
            java.lang.String r9 = r6.f55868a     // Catch:{ all -> 0x0424 }
            java.lang.String r13 = r6.f55869b     // Catch:{ all -> 0x0424 }
            long r14 = r6.f55870c     // Catch:{ all -> 0x0424 }
            r19 = r0
            r20 = r5
            r21 = r10
            r22 = r4
            r23 = r11
            r25 = r9
            r26 = r13
            r19.<init>(r20, r21, r22, r23, r25, r26)     // Catch:{ all -> 0x0424 }
            goto L_0x01d9
        L_0x01d8:
            r0 = 0
        L_0x01d9:
            if (r0 != 0) goto L_0x0411
            java.util.Iterator r4 = r2.iterator()     // Catch:{ all -> 0x0424 }
        L_0x01df:
            boolean r0 = r4.hasNext()     // Catch:{ all -> 0x0424 }
            r5 = 4
            if (r0 == 0) goto L_0x035b
            java.lang.Object r0 = r4.next()     // Catch:{ all -> 0x0424 }
            r6 = r0
            com.google.android.play.core.assetpacks.cm r6 = (com.google.android.play.core.assetpacks.C19955cm) r6     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r0 = r6.f55867c     // Catch:{ all -> 0x0424 }
            int r0 = r0.f55862c     // Catch:{ all -> 0x0424 }
            boolean r0 = com.google.android.play.core.assetpacks.C19971db.m42019c(r0)     // Catch:{ all -> 0x0424 }
            if (r0 == 0) goto L_0x01df
            com.google.android.play.core.assetpacks.cl r0 = r6.f55867c     // Catch:{ all -> 0x0424 }
            java.util.List<com.google.android.play.core.assetpacks.cn> r0 = r0.f55864e     // Catch:{ all -> 0x0424 }
            java.util.Iterator r9 = r0.iterator()     // Catch:{ all -> 0x0424 }
        L_0x01ff:
            boolean r0 = r9.hasNext()     // Catch:{ all -> 0x0424 }
            if (r0 == 0) goto L_0x01df
            java.lang.Object r0 = r9.next()     // Catch:{ all -> 0x0424 }
            r10 = r0
            com.google.android.play.core.assetpacks.cn r10 = (com.google.android.play.core.assetpacks.C19956cn) r10     // Catch:{ all -> 0x0424 }
            boolean r0 = m41986a(r10)     // Catch:{ all -> 0x0424 }
            if (r0 == 0) goto L_0x02a2
            boolean r0 = r1.m41985a(r6, r10)     // Catch:{ all -> 0x0424 }
            if (r0 == 0) goto L_0x01ff
            com.google.android.play.core.internal.ag r0 = f55887a     // Catch:{ all -> 0x0424 }
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ all -> 0x0424 }
            int r9 = r6.f55865a     // Catch:{ all -> 0x0424 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0424 }
            r4[r7] = r9     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r9 = r6.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r9 = r9.f55860a     // Catch:{ all -> 0x0424 }
            r11 = 1
            r4[r11] = r9     // Catch:{ all -> 0x0424 }
            java.lang.String r9 = r10.f55868a     // Catch:{ all -> 0x0424 }
            r11 = 2
            r4[r11] = r9     // Catch:{ all -> 0x0424 }
            java.lang.String r9 = "Found extraction task for patch for session %s, pack %s, slice %s."
            r0.mo164267a(r9, r4)     // Catch:{ all -> 0x0424 }
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x027b }
            com.google.android.play.core.assetpacks.bb r11 = r1.f55889c     // Catch:{ FileNotFoundException -> 0x027b }
            com.google.android.play.core.assetpacks.cl r4 = r6.f55867c     // Catch:{ FileNotFoundException -> 0x027b }
            java.lang.String r12 = r4.f55860a     // Catch:{ FileNotFoundException -> 0x027b }
            int r13 = r6.f55866b     // Catch:{ FileNotFoundException -> 0x027b }
            long r14 = r4.f55861b     // Catch:{ FileNotFoundException -> 0x027b }
            java.lang.String r4 = r10.f55868a     // Catch:{ FileNotFoundException -> 0x027b }
            r16 = r4
            java.io.File r4 = r11.mo164115e(r12, r13, r14, r16)     // Catch:{ FileNotFoundException -> 0x027b }
            r0.<init>(r4)     // Catch:{ FileNotFoundException -> 0x027b }
            com.google.android.play.core.assetpacks.bs r4 = new com.google.android.play.core.assetpacks.bs     // Catch:{ all -> 0x0424 }
            int r9 = r6.f55865a     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r11 = r6.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r12 = r11.f55860a     // Catch:{ all -> 0x0424 }
            int r6 = r6.f55866b     // Catch:{ all -> 0x0424 }
            long r13 = r11.f55861b     // Catch:{ all -> 0x0424 }
            java.lang.String r10 = r10.f55868a     // Catch:{ all -> 0x0424 }
            long r7 = r11.f55863d     // Catch:{ all -> 0x0424 }
            r26 = 0
            r27 = 0
            r28 = 1
            int r11 = r11.f55862c     // Catch:{ all -> 0x0424 }
            r19 = r4
            r20 = r9
            r21 = r12
            r22 = r6
            r23 = r13
            r25 = r10
            r29 = r7
            r31 = r11
            r32 = r0
            r19.<init>(r20, r21, r22, r23, r25, r26, r27, r28, r29, r31, r32)     // Catch:{ all -> 0x0424 }
            goto L_0x035c
        L_0x027b:
            r0 = move-exception
            com.google.android.play.core.assetpacks.bv r2 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0424 }
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0424 }
            int r4 = r6.f55865a     // Catch:{ all -> 0x0424 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0424 }
            r5 = 0
            r3[r5] = r4     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r4 = r6.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r4 = r4.f55860a     // Catch:{ all -> 0x0424 }
            r5 = 1
            r3[r5] = r4     // Catch:{ all -> 0x0424 }
            java.lang.String r4 = r10.f55868a     // Catch:{ all -> 0x0424 }
            r5 = 2
            r3[r5] = r4     // Catch:{ all -> 0x0424 }
            java.lang.String r4 = "Error finding patch, session %s packName %s sliceId %s"
            java.lang.String r3 = java.lang.String.format(r4, r3)     // Catch:{ all -> 0x0424 }
            int r4 = r6.f55865a     // Catch:{ all -> 0x0424 }
            r2.<init>(r3, r0, r4)     // Catch:{ all -> 0x0424 }
            throw r2     // Catch:{ all -> 0x0424 }
        L_0x02a2:
            com.google.android.play.core.assetpacks.dr r0 = new com.google.android.play.core.assetpacks.dr     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.bb r7 = r1.f55889c     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r8 = r6.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r11 = r8.f55860a     // Catch:{ all -> 0x0424 }
            int r12 = r6.f55866b     // Catch:{ all -> 0x0424 }
            long r13 = r8.f55861b     // Catch:{ all -> 0x0424 }
            java.lang.String r8 = r10.f55868a     // Catch:{ all -> 0x0424 }
            r19 = r0
            r20 = r7
            r21 = r11
            r22 = r12
            r23 = r13
            r25 = r8
            r19.<init>(r20, r21, r22, r23, r25)     // Catch:{ all -> 0x0424 }
            int r0 = r0.mo164220c()     // Catch:{ IOException -> 0x02c4 }
            goto L_0x02d4
        L_0x02c4:
            r0 = move-exception
            r7 = r0
            com.google.android.play.core.internal.ag r0 = f55887a     // Catch:{ all -> 0x0424 }
            r8 = 1
            java.lang.Object[] r11 = new java.lang.Object[r8]     // Catch:{ all -> 0x0424 }
            r8 = 0
            r11[r8] = r7     // Catch:{ all -> 0x0424 }
            java.lang.String r7 = "Slice checkpoint corrupt, restarting extraction. %s"
            r0.mo164269b(r7, r11)     // Catch:{ all -> 0x0424 }
            r0 = 0
        L_0x02d4:
            r7 = -1
            if (r0 == r7) goto L_0x0357
            java.util.List<com.google.android.play.core.assetpacks.ck> r7 = r10.f55871d     // Catch:{ all -> 0x0424 }
            java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.ck r7 = (com.google.android.play.core.assetpacks.C19953ck) r7     // Catch:{ all -> 0x0424 }
            boolean r7 = r7.f55859a     // Catch:{ all -> 0x0424 }
            if (r7 == 0) goto L_0x0357
            com.google.android.play.core.internal.ag r4 = f55887a     // Catch:{ all -> 0x0424 }
            r7 = 5
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x0424 }
            int r8 = r10.f55872e     // Catch:{ all -> 0x0424 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0424 }
            r9 = 0
            r7[r9] = r8     // Catch:{ all -> 0x0424 }
            int r8 = r6.f55865a     // Catch:{ all -> 0x0424 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0424 }
            r9 = 1
            r7[r9] = r8     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r8 = r6.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r8 = r8.f55860a     // Catch:{ all -> 0x0424 }
            r9 = 2
            r7[r9] = r8     // Catch:{ all -> 0x0424 }
            java.lang.String r8 = r10.f55868a     // Catch:{ all -> 0x0424 }
            r9 = 3
            r7[r9] = r8     // Catch:{ all -> 0x0424 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0424 }
            r7[r5] = r8     // Catch:{ all -> 0x0424 }
            java.lang.String r8 = "Found extraction task using compression format %s for session %s, pack %s, slice %s, chunk %s."
            r4.mo164267a(r8, r7)     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.bk r4 = r1.f55890d     // Catch:{ all -> 0x0424 }
            int r7 = r6.f55865a     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r8 = r6.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r8 = r8.f55860a     // Catch:{ all -> 0x0424 }
            java.lang.String r9 = r10.f55868a     // Catch:{ all -> 0x0424 }
            java.io.InputStream r32 = r4.mo164139a(r7, r8, r9, r0)     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.bs r4 = new com.google.android.play.core.assetpacks.bs     // Catch:{ all -> 0x0424 }
            int r7 = r6.f55865a     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r8 = r6.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r9 = r8.f55860a     // Catch:{ all -> 0x0424 }
            int r11 = r6.f55866b     // Catch:{ all -> 0x0424 }
            long r12 = r8.f55861b     // Catch:{ all -> 0x0424 }
            java.lang.String r8 = r10.f55868a     // Catch:{ all -> 0x0424 }
            int r14 = r10.f55872e     // Catch:{ all -> 0x0424 }
            java.util.List<com.google.android.play.core.assetpacks.ck> r10 = r10.f55871d     // Catch:{ all -> 0x0424 }
            int r28 = r10.size()     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r6 = r6.f55867c     // Catch:{ all -> 0x0424 }
            r33 = r4
            long r3 = r6.f55863d     // Catch:{ all -> 0x0424 }
            int r6 = r6.f55862c     // Catch:{ all -> 0x0424 }
            r19 = r33
            r20 = r7
            r21 = r9
            r22 = r11
            r23 = r12
            r25 = r8
            r26 = r14
            r27 = r0
            r29 = r3
            r31 = r6
            r19.<init>(r20, r21, r22, r23, r25, r26, r27, r28, r29, r31, r32)     // Catch:{ all -> 0x0424 }
            r4 = r33
            goto L_0x035c
        L_0x0357:
            r7 = 0
            r8 = 3
            goto L_0x01ff
        L_0x035b:
            r4 = 0
        L_0x035c:
            if (r4 != 0) goto L_0x041e
            java.util.Iterator r0 = r2.iterator()     // Catch:{ all -> 0x0424 }
        L_0x0362:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0424 }
            if (r2 == 0) goto L_0x040e
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cm r2 = (com.google.android.play.core.assetpacks.C19955cm) r2     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r3 = r2.f55867c     // Catch:{ all -> 0x0424 }
            int r3 = r3.f55862c     // Catch:{ all -> 0x0424 }
            boolean r3 = com.google.android.play.core.assetpacks.C19971db.m42019c(r3)     // Catch:{ all -> 0x0424 }
            if (r3 == 0) goto L_0x0362
            com.google.android.play.core.assetpacks.cl r3 = r2.f55867c     // Catch:{ all -> 0x0424 }
            java.util.List<com.google.android.play.core.assetpacks.cn> r3 = r3.f55864e     // Catch:{ all -> 0x0424 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0424 }
        L_0x0380:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0424 }
            if (r4 == 0) goto L_0x0362
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cn r4 = (com.google.android.play.core.assetpacks.C19956cn) r4     // Catch:{ all -> 0x0424 }
            boolean r6 = m41986a(r4)     // Catch:{ all -> 0x0424 }
            if (r6 == 0) goto L_0x0380
            java.util.List<com.google.android.play.core.assetpacks.ck> r6 = r4.f55871d     // Catch:{ all -> 0x0424 }
            r7 = 0
            java.lang.Object r6 = r6.get(r7)     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.ck r6 = (com.google.android.play.core.assetpacks.C19953ck) r6     // Catch:{ all -> 0x0424 }
            boolean r6 = r6.f55859a     // Catch:{ all -> 0x0424 }
            if (r6 == 0) goto L_0x0380
            boolean r6 = r1.m41985a(r2, r4)     // Catch:{ all -> 0x0424 }
            if (r6 != 0) goto L_0x0380
            com.google.android.play.core.internal.ag r0 = f55887a     // Catch:{ all -> 0x0424 }
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ all -> 0x0424 }
            int r5 = r4.f55873f     // Catch:{ all -> 0x0424 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0424 }
            r6 = 0
            r3[r6] = r5     // Catch:{ all -> 0x0424 }
            int r5 = r2.f55865a     // Catch:{ all -> 0x0424 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0424 }
            r6 = 1
            r3[r6] = r5     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r5 = r2.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r5 = r5.f55860a     // Catch:{ all -> 0x0424 }
            r7 = 2
            r3[r7] = r5     // Catch:{ all -> 0x0424 }
            java.lang.String r5 = r4.f55868a     // Catch:{ all -> 0x0424 }
            r8 = 3
            r3[r8] = r5     // Catch:{ all -> 0x0424 }
            java.lang.String r5 = "Found patch slice task using patch format %s for session %s, pack %s, slice %s."
            r0.mo164267a(r5, r3)     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.bk r0 = r1.f55890d     // Catch:{ all -> 0x0424 }
            int r3 = r2.f55865a     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r5 = r2.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r5 = r5.f55860a     // Catch:{ all -> 0x0424 }
            java.lang.String r6 = r4.f55868a     // Catch:{ all -> 0x0424 }
            r9 = 0
            java.io.InputStream r24 = r0.mo164139a(r3, r5, r6, r9)     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.dn r0 = new com.google.android.play.core.assetpacks.dn     // Catch:{ all -> 0x0424 }
            int r12 = r2.f55865a     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r3 = r2.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r13 = r3.f55860a     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.bb r3 = r1.f55889c     // Catch:{ all -> 0x0424 }
            int r14 = r3.mo164113e(r13)     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.bb r3 = r1.f55889c     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r5 = r2.f55867c     // Catch:{ all -> 0x0424 }
            java.lang.String r5 = r5.f55860a     // Catch:{ all -> 0x0424 }
            long r15 = r3.mo164117f(r5)     // Catch:{ all -> 0x0424 }
            int r3 = r2.f55866b     // Catch:{ all -> 0x0424 }
            com.google.android.play.core.assetpacks.cl r2 = r2.f55867c     // Catch:{ all -> 0x0424 }
            long r5 = r2.f55861b     // Catch:{ all -> 0x0424 }
            int r2 = r4.f55873f     // Catch:{ all -> 0x0424 }
            java.lang.String r7 = r4.f55868a     // Catch:{ all -> 0x0424 }
            long r8 = r4.f55870c     // Catch:{ all -> 0x0424 }
            r11 = r0
            r17 = r3
            r18 = r5
            r20 = r2
            r21 = r7
            r22 = r8
            r11.<init>(r12, r13, r14, r15, r17, r18, r20, r21, r22, r24)     // Catch:{ all -> 0x0424 }
            goto L_0x040f
        L_0x040e:
            r0 = 0
        L_0x040f:
            if (r0 == 0) goto L_0x0417
        L_0x0411:
            com.google.android.play.core.assetpacks.cp r2 = r1.f55888b
            r2.mo164167b()
            return r0
        L_0x0417:
            com.google.android.play.core.assetpacks.cp r0 = r1.f55888b
            r0.mo164167b()
            r2 = 0
            return r2
        L_0x041e:
            com.google.android.play.core.assetpacks.cp r0 = r1.f55888b
            r0.mo164167b()
            return r4
        L_0x0424:
            r0 = move-exception
            com.google.android.play.core.assetpacks.cp r2 = r1.f55888b
            r2.mo164167b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C19961cs.mo164177a():com.google.android.play.core.assetpacks.cr");
    }
}
