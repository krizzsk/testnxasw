package com.google.android.play.core.splitcompat;

import java.io.File;

/* renamed from: com.google.android.play.core.splitcompat.q */
final class C20165q {

    /* renamed from: a */
    private final File f56189a;

    /* renamed from: b */
    private final String f56190b;

    C20165q() {
    }

    C20165q(File file, String str) {
        this();
        if (file != null) {
            this.f56189a = file;
            if (str != null) {
                this.f56190b = str;
                return;
            }
            throw new NullPointerException("Null splitId");
        }
        throw new NullPointerException("Null splitFile");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public File mo164454a() {
        return this.f56189a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo164455b() {
        return this.f56190b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C20165q) {
            C20165q qVar = (C20165q) obj;
            return this.f56189a.equals(qVar.mo164454a()) && this.f56190b.equals(qVar.mo164455b());
        }
    }

    public int hashCode() {
        return ((this.f56189a.hashCode() ^ 1000003) * 1000003) ^ this.f56190b.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.f56189a);
        String str = this.f56190b;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35 + str.length());
        sb.append("SplitFileInfo{splitFile=");
        sb.append(valueOf);
        sb.append(", splitId=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
