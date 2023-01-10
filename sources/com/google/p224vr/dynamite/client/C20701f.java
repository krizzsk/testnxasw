package com.google.p224vr.dynamite.client;

import java.util.Objects;

/* renamed from: com.google.vr.dynamite.client.f */
/* compiled from: Version */
public final class C20701f {

    /* renamed from: a */
    private final int f56670a;

    /* renamed from: b */
    private final int f56671b;

    /* renamed from: c */
    private final int f56672c;

    public C20701f(int i, int i2, int i3) {
        this.f56670a = i;
        this.f56671b = i2;
        this.f56672c = i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C20701f)) {
            return false;
        }
        C20701f fVar = (C20701f) obj;
        if (this.f56670a == fVar.f56670a && this.f56671b == fVar.f56671b && this.f56672c == fVar.f56672c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f56670a), Integer.valueOf(this.f56671b), Integer.valueOf(this.f56672c)});
    }

    public final String toString() {
        return String.format("%d.%d.%d", new Object[]{Integer.valueOf(this.f56670a), Integer.valueOf(this.f56671b), Integer.valueOf(this.f56672c)});
    }
}
