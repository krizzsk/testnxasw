package com.google.p224vr.dynamite.client;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.Objects;

/* renamed from: com.google.vr.dynamite.client.e */
/* compiled from: TargetLibraryInfo */
final class C20700e {

    /* renamed from: a */
    private final String f56668a;

    /* renamed from: b */
    private final String f56669b;

    public C20700e(String str, String str2) {
        this.f56668a = str;
        this.f56669b = str2;
    }

    /* renamed from: a */
    public final String mo170430a() {
        return this.f56668a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C20700e) {
            C20700e eVar = (C20700e) obj;
            return Objects.equals(this.f56668a, eVar.f56668a) && Objects.equals(this.f56669b, eVar.f56669b);
        }
    }

    public final int hashCode() {
        return (Objects.hashCode(this.f56668a) * 37) + Objects.hashCode(this.f56669b);
    }

    public final String toString() {
        return "[packageName=" + this.f56668a + ",libraryName=" + this.f56669b + Const.jaRight;
    }
}
