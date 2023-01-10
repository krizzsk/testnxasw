package com.didi.aoe.features.bankcard.global.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BC\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u000f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b¨\u0006 "}, mo148868d2 = {"Lcom/didi/aoe/features/bankcard/global/domain/Shape;", "", "w", "", "h", "c", "dims", "elemSize", "cSetp", "(IIIIII)V", "getC", "()I", "getCSetp", "getDims", "getElemSize", "flatSize", "getFlatSize", "getH", "getW", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "global-ocr_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: Shape.kt */
public final class Shape {

    /* renamed from: a */
    private final int f10000a;

    /* renamed from: b */
    private final int f10001b;

    /* renamed from: c */
    private final int f10002c;

    /* renamed from: d */
    private final int f10003d;

    /* renamed from: e */
    private final int f10004e;

    /* renamed from: f */
    private final int f10005f;

    public Shape() {
        this(0, 0, 0, 0, 0, 0, 63, (DefaultConstructorMarker) null);
    }

    public Shape(int i) {
        this(i, 0, 0, 0, 0, 0, 62, (DefaultConstructorMarker) null);
    }

    public Shape(int i, int i2) {
        this(i, i2, 0, 0, 0, 0, 60, (DefaultConstructorMarker) null);
    }

    public Shape(int i, int i2, int i3) {
        this(i, i2, i3, 0, 0, 0, 56, (DefaultConstructorMarker) null);
    }

    public Shape(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, 0, 0, 48, (DefaultConstructorMarker) null);
    }

    public Shape(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3, i4, i5, 0, 32, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Shape copy$default(Shape shape, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = shape.f10000a;
        }
        if ((i7 & 2) != 0) {
            i2 = shape.f10001b;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = shape.f10002c;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = shape.f10003d;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = shape.f10004e;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = shape.f10005f;
        }
        return shape.copy(i, i8, i9, i10, i11, i6);
    }

    public final int component1() {
        return this.f10000a;
    }

    public final int component2() {
        return this.f10001b;
    }

    public final int component3() {
        return this.f10002c;
    }

    public final int component4() {
        return this.f10003d;
    }

    public final int component5() {
        return this.f10004e;
    }

    public final int component6() {
        return this.f10005f;
    }

    public final Shape copy(int i, int i2, int i3, int i4, int i5, int i6) {
        return new Shape(i, i2, i3, i4, i5, i6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shape)) {
            return false;
        }
        Shape shape = (Shape) obj;
        return this.f10000a == shape.f10000a && this.f10001b == shape.f10001b && this.f10002c == shape.f10002c && this.f10003d == shape.f10003d && this.f10004e == shape.f10004e && this.f10005f == shape.f10005f;
    }

    public int hashCode() {
        return (((((((((this.f10000a * 31) + this.f10001b) * 31) + this.f10002c) * 31) + this.f10003d) * 31) + this.f10004e) * 31) + this.f10005f;
    }

    public Shape(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f10000a = i;
        this.f10001b = i2;
        this.f10002c = i3;
        this.f10003d = i4;
        this.f10004e = i5;
        this.f10005f = i6;
    }

    public final int getW() {
        return this.f10000a;
    }

    public final int getH() {
        return this.f10001b;
    }

    public final int getC() {
        return this.f10002c;
    }

    public final int getDims() {
        return this.f10003d;
    }

    public final int getElemSize() {
        return this.f10004e;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Shape(int r6, int r7, int r8, int r9, int r10, int r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = 0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = 0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = 0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = 0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = 0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = 0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.aoe.features.bankcard.global.domain.Shape.<init>(int, int, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getCSetp() {
        return this.f10005f;
    }

    public final int getFlatSize() {
        return this.f10000a * this.f10001b * this.f10002c;
    }

    public String toString() {
        return "w " + this.f10000a + ", h " + this.f10001b + ", c " + this.f10002c + ", dims " + this.f10003d + ", elemSize " + this.f10004e + ", cSetp " + this.f10005f;
    }
}
