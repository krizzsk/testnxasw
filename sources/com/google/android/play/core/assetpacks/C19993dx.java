package com.google.android.play.core.assetpacks;

import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.dx */
final class C19993dx {

    /* renamed from: a */
    private final String f55998a;

    /* renamed from: b */
    private final long f55999b;

    /* renamed from: c */
    private final int f56000c;

    /* renamed from: d */
    private final boolean f56001d;

    /* renamed from: e */
    private final boolean f56002e;

    /* renamed from: f */
    private final byte[] f56003f;

    C19993dx() {
    }

    C19993dx(String str, long j, int i, boolean z, boolean z2, byte[] bArr) {
        this();
        this.f55998a = str;
        this.f55999b = j;
        this.f56000c = i;
        this.f56001d = z;
        this.f56002e = z2;
        this.f56003f = bArr;
    }

    /* renamed from: a */
    static C19993dx m42061a(String str, long j, int i, boolean z, byte[] bArr, boolean z2) {
        return new C19993dx(str, j, i, z, z2, bArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo164224a() {
        if (mo164226c() == null) {
            return false;
        }
        return mo164226c().endsWith("/");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo164225b() {
        return mo164228e() == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo164226c() {
        return this.f55998a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public long mo164227d() {
        return this.f55999b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo164228e() {
        return this.f56000c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C19993dx) {
            C19993dx dxVar = (C19993dx) obj;
            String str = this.f55998a;
            if (str != null ? str.equals(dxVar.mo164226c()) : dxVar.mo164226c() == null) {
                if (this.f55999b == dxVar.mo164227d() && this.f56000c == dxVar.mo164228e() && this.f56001d == dxVar.mo164230f() && this.f56002e == dxVar.mo164231g()) {
                    if (Arrays.equals(this.f56003f, dxVar instanceof C19993dx ? dxVar.f56003f : dxVar.mo164232h())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo164230f() {
        return this.f56001d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo164231g() {
        return this.f56002e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public byte[] mo164232h() {
        return this.f56003f;
    }

    public int hashCode() {
        String str = this.f55998a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f55999b;
        int i = 1237;
        int i2 = (((((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.f56000c) * 1000003) ^ (true != this.f56001d ? 1237 : 1231)) * 1000003;
        if (true == this.f56002e) {
            i = 1231;
        }
        return ((i2 ^ i) * 1000003) ^ Arrays.hashCode(this.f56003f);
    }

    public String toString() {
        String str = this.f55998a;
        long j = this.f55999b;
        int i = this.f56000c;
        boolean z = this.f56001d;
        boolean z2 = this.f56002e;
        String arrays = Arrays.toString(this.f56003f);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 126 + String.valueOf(arrays).length());
        sb.append("ZipEntry{name=");
        sb.append(str);
        sb.append(", size=");
        sb.append(j);
        sb.append(", compressionMethod=");
        sb.append(i);
        sb.append(", isPartial=");
        sb.append(z);
        sb.append(", isEndOfArchive=");
        sb.append(z2);
        sb.append(", headerBytes=");
        sb.append(arrays);
        sb.append("}");
        return sb.toString();
    }
}
