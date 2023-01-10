package com.google.android.play.core.assetpacks;

/* renamed from: com.google.android.play.core.assetpacks.dq */
final class C19986dq {

    /* renamed from: a */
    private final int f55976a;

    /* renamed from: b */
    private final String f55977b;

    /* renamed from: c */
    private final long f55978c;

    /* renamed from: d */
    private final long f55979d;

    /* renamed from: e */
    private final int f55980e;

    C19986dq() {
    }

    C19986dq(int i, String str, long j, long j2, int i2) {
        this();
        this.f55976a = i;
        this.f55977b = str;
        this.f55978c = j;
        this.f55979d = j2;
        this.f55980e = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo164201a() {
        return this.f55976a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo164202b() {
        return this.f55977b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo164203c() {
        return this.f55978c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public long mo164204d() {
        return this.f55979d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo164205e() {
        return this.f55980e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r1 = r7.f55977b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.android.play.core.assetpacks.C19986dq
            r2 = 0
            if (r1 == 0) goto L_0x0046
            com.google.android.play.core.assetpacks.dq r8 = (com.google.android.play.core.assetpacks.C19986dq) r8
            int r1 = r7.f55976a
            int r3 = r8.mo164201a()
            if (r1 != r3) goto L_0x0046
            java.lang.String r1 = r7.f55977b
            if (r1 != 0) goto L_0x001e
            java.lang.String r1 = r8.mo164202b()
            if (r1 != 0) goto L_0x0046
            goto L_0x0029
        L_0x001e:
            java.lang.String r3 = r8.mo164202b()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0029
            goto L_0x0046
        L_0x0029:
            long r3 = r7.f55978c
            long r5 = r8.mo164203c()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0046
            long r3 = r7.f55979d
            long r5 = r8.mo164204d()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0046
            int r1 = r7.f55980e
            int r8 = r8.mo164205e()
            if (r1 != r8) goto L_0x0046
            return r0
        L_0x0046:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C19986dq.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = (this.f55976a ^ 1000003) * 1000003;
        String str = this.f55977b;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f55978c;
        long j2 = this.f55979d;
        return ((((((i ^ hashCode) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f55980e;
    }

    public String toString() {
        int i = this.f55976a;
        String str = this.f55977b;
        long j = this.f55978c;
        long j2 = this.f55979d;
        int i2 = this.f55980e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 157);
        sb.append("SliceCheckpoint{fileExtractionStatus=");
        sb.append(i);
        sb.append(", filePath=");
        sb.append(str);
        sb.append(", fileOffset=");
        sb.append(j);
        sb.append(", remainingBytes=");
        sb.append(j2);
        sb.append(", previousChunk=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
