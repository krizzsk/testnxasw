package com.didi.map.global.component.floatingwindow.util;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u0011\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\nJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u001b"}, mo148868d2 = {"Lcom/didi/map/global/component/floatingwindow/util/ExpandWidth;", "", "()V", "left", "", "top", "right", "bottom", "(IIII)V", "src", "(Lcom/didi/map/global/component/floatingwindow/util/ExpandWidth;)V", "getBottom", "()I", "setBottom", "(I)V", "getLeft", "setLeft", "getRight", "setRight", "getTop", "setTop", "equals", "", "other", "hashCode", "toString", "", "compFloatingWindow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ViewExt.kt */
public final class ExpandWidth {

    /* renamed from: a */
    private int f27885a;

    /* renamed from: b */
    private int f27886b;

    /* renamed from: c */
    private int f27887c;

    /* renamed from: d */
    private int f27888d;

    public final int getLeft() {
        return this.f27885a;
    }

    public final void setLeft(int i) {
        this.f27885a = i;
    }

    public final int getTop() {
        return this.f27886b;
    }

    public final void setTop(int i) {
        this.f27886b = i;
    }

    public final int getRight() {
        return this.f27887c;
    }

    public final void setRight(int i) {
        this.f27887c = i;
    }

    public final int getBottom() {
        return this.f27888d;
    }

    public final void setBottom(int i) {
        this.f27888d = i;
    }

    public ExpandWidth() {
    }

    public ExpandWidth(int i, int i2, int i3, int i4) {
        this.f27885a = i;
        this.f27886b = i2;
        this.f27887c = i3;
        this.f27888d = i4;
    }

    public ExpandWidth(ExpandWidth expandWidth) {
        if (expandWidth != null) {
            this.f27886b = expandWidth.f27886b;
            this.f27888d = expandWidth.f27888d;
            this.f27885a = expandWidth.f27885a;
            this.f27887c = expandWidth.f27887c;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ExpandWidth)) {
            return false;
        }
        ExpandWidth expandWidth = (ExpandWidth) obj;
        if (expandWidth.f27885a == this.f27885a && expandWidth.f27887c == this.f27887c && expandWidth.f27888d == this.f27888d && expandWidth.f27886b == this.f27886b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "top=" + this.f27886b + ", bottom=" + this.f27888d + ", left=" + this.f27885a + ", right=" + this.f27887c;
    }

    public int hashCode() {
        return (((((this.f27885a * 31) + this.f27886b) * 31) + this.f27887c) * 31) + this.f27888d;
    }
}
