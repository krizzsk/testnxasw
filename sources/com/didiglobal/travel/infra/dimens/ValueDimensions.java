package com.didiglobal.travel.infra.dimens;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b@\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÖ\u0001J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, mo148868d2 = {"Lcom/didiglobal/travel/infra/dimens/ValueDimensions;", "", "valueAndUnit", "", "constructor-impl", "(J)J", "unit", "", "getUnit-impl", "(J)I", "value", "", "getValue-impl", "(J)F", "equals", "", "other", "hashCode", "toPx", "context", "Landroid/content/Context;", "toPx-impl", "(JLandroid/content/Context;)F", "toPxInt", "toPxInt-impl", "(JLandroid/content/Context;)I", "toString", "", "Companion", "lib-common_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: ValueDimensions.kt */
public final class ValueDimensions {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b */
    private static final long f53963b = 4294967295L;

    /* renamed from: a */
    private final long f53964a;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ValueDimensions m47556boximpl(long j) {
        return new ValueDimensions(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m47557constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47558equalsimpl(long j, Object obj) {
        return (obj instanceof ValueDimensions) && j == ((ValueDimensions) obj).m47566unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m47559equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getUnit-impl  reason: not valid java name */
    public static final int m47560getUnitimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47562hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m47565toStringimpl(long j) {
        return "ValueDimensions(valueAndUnit=" + j + ")";
    }

    public boolean equals(Object obj) {
        return m47558equalsimpl(this.f53964a, obj);
    }

    public int hashCode() {
        return m47562hashCodeimpl(this.f53964a);
    }

    public String toString() {
        return m47565toStringimpl(this.f53964a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m47566unboximpl() {
        return this.f53964a;
    }

    private /* synthetic */ ValueDimensions(long j) {
        this.f53964a = j;
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, mo148868d2 = {"Lcom/didiglobal/travel/infra/dimens/ValueDimensions$Companion;", "", "()V", "DIMENSION_VALUE_MASK", "", "of", "Lcom/didiglobal/travel/infra/dimens/ValueDimensions;", "value", "", "unit", "", "(FI)J", "lib-common_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: ValueDimensions.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: of */
        public final long mo131208of(float f, int i) {
            return ValueDimensions.m47557constructorimpl(((long) Float.floatToRawIntBits(f)) | (((long) i) << 32));
        }
    }

    /* renamed from: getValue-impl  reason: not valid java name */
    public static final float m47561getValueimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: toPx-impl  reason: not valid java name */
    public static final float m47563toPximpl(long j, Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        int r0 = m47560getUnitimpl(j);
        float r1 = m47561getValueimpl(j);
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        return TypedValue.applyDimension(r0, r1, resources.getDisplayMetrics());
    }

    /* renamed from: toPxInt-impl  reason: not valid java name */
    public static final int m47564toPxIntimpl(long j, Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return MathKt.roundToInt(m47563toPximpl(j, context));
    }
}
