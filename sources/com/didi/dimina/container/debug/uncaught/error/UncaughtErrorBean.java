package com.didi.dimina.container.debug.uncaught.error;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000b¨\u0006\u001a"}, mo148868d2 = {"Lcom/didi/dimina/container/debug/uncaught/error/UncaughtErrorBean;", "", "info", "", "stack", "isPromise", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getInfo", "()Ljava/lang/String;", "setInfo", "(Ljava/lang/String;)V", "()Z", "setPromise", "(Z)V", "getStack", "setStack", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "container_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: UncaughtErrorBean.kt */
public final class UncaughtErrorBean {

    /* renamed from: a */
    private String f18681a;

    /* renamed from: b */
    private String f18682b;

    /* renamed from: c */
    private boolean f18683c;

    public UncaughtErrorBean(String str) {
        this(str, (String) null, false, 6, (DefaultConstructorMarker) null);
    }

    public UncaughtErrorBean(String str, String str2) {
        this(str, str2, false, 4, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UncaughtErrorBean copy$default(UncaughtErrorBean uncaughtErrorBean, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uncaughtErrorBean.f18681a;
        }
        if ((i & 2) != 0) {
            str2 = uncaughtErrorBean.f18682b;
        }
        if ((i & 4) != 0) {
            z = uncaughtErrorBean.f18683c;
        }
        return uncaughtErrorBean.copy(str, str2, z);
    }

    public final String component1() {
        return this.f18681a;
    }

    public final String component2() {
        return this.f18682b;
    }

    public final boolean component3() {
        return this.f18683c;
    }

    public final UncaughtErrorBean copy(String str, String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "info");
        Intrinsics.checkParameterIsNotNull(str2, "stack");
        return new UncaughtErrorBean(str, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UncaughtErrorBean)) {
            return false;
        }
        UncaughtErrorBean uncaughtErrorBean = (UncaughtErrorBean) obj;
        return Intrinsics.areEqual((Object) this.f18681a, (Object) uncaughtErrorBean.f18681a) && Intrinsics.areEqual((Object) this.f18682b, (Object) uncaughtErrorBean.f18682b) && this.f18683c == uncaughtErrorBean.f18683c;
    }

    public int hashCode() {
        String str = this.f18681a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f18682b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.f18683c;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public UncaughtErrorBean(String str, String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "info");
        Intrinsics.checkParameterIsNotNull(str2, "stack");
        this.f18681a = str;
        this.f18682b = str2;
        this.f18683c = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UncaughtErrorBean(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z);
    }

    public final String getInfo() {
        return this.f18681a;
    }

    public final String getStack() {
        return this.f18682b;
    }

    public final boolean isPromise() {
        return this.f18683c;
    }

    public final void setInfo(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f18681a = str;
    }

    public final void setPromise(boolean z) {
        this.f18683c = z;
    }

    public final void setStack(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f18682b = str;
    }

    public String toString() {
        return "info='" + this.f18681a + "', " + "stack='" + this.f18682b + "', " + "isPromise=" + this.f18683c + VersionRange.RIGHT_OPEN;
    }
}
