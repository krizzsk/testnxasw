package com.didiglobal.travel.infra.value;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b@\u0018\u0000 52\u00020\u0001:\u00015B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\tJ\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J]\u0010\u001e\u001a\u00020\u001f2K\u0010 \u001aG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001f0!H\b¢\u0006\u0004\b'\u0010(Jr\u0010\u001e\u001a\u00020\u001f2`\u0010 \u001a\\\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u001f0)H\b¢\u0006\u0004\b'\u0010*J\u0017\u0010+\u001a\u00020,2\b\b\u0001\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020,H\u0007¢\u0006\u0004\b1\u00102J\t\u00103\u001a\u000204HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u00066"}, mo148868d2 = {"Lcom/didiglobal/travel/infra/value/Color;", "", "rawValue", "", "constructor-impl", "(J)J", "alpha", "", "getAlpha-impl", "(J)I", "blue", "getBlue-impl", "colorInt", "getColorInt-impl", "green", "getGreen-impl", "red", "getRed-impl", "component1", "component1-impl", "component2", "component2-impl", "component3", "component3-impl", "component4", "component4-impl", "equals", "", "other", "hashCode", "toComponents", "", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "r", "g", "b", "toComponents-impl", "(JLkotlin/jvm/functions/Function3;)V", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)V", "toHSV", "", "hsv", "toHSV-impl", "(J[F)[F", "toHSVArray", "toHSVArray-impl", "(J)[F", "toString", "", "Companion", "lib-common_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: Color.kt */
public final class Color {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final long f53995b = m47717constructorimpl(4294967296L);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Regex f53996c = new Regex("^#([0-1a-fA-F]{6}|[0-1a-fA-F]{8})$");
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final String[] f53997d = {"black", "darkgray", "gray", "lightgray", "white", "red", "green", "blue", "yellow", "cyan", "magenta", "aqua", "fuchsia", "darkgrey", "grey", "lightgrey", "lime", "maroon", "navy", "olive", "purple", "silver", "teal"};

    /* renamed from: a */
    private final long f53998a;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Color m47712boximpl(long j) {
        return new Color(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m47717constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47718equalsimpl(long j, Object obj) {
        return (obj instanceof Color) && j == ((Color) obj).m47731unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m47719equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getColorInt-impl  reason: not valid java name */
    public static final int m47722getColorIntimpl(long j) {
        return (int) j;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47725hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m47730toStringimpl(long j) {
        return "Color(rawValue=" + j + ")";
    }

    public boolean equals(Object obj) {
        return m47718equalsimpl(this.f53998a, obj);
    }

    public int hashCode() {
        return m47725hashCodeimpl(this.f53998a);
    }

    public String toString() {
        return m47730toStringimpl(this.f53998a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m47731unboximpl() {
        return this.f53998a;
    }

    private /* synthetic */ Color(long j) {
        this.f53998a = j;
    }

    /* renamed from: getAlpha-impl  reason: not valid java name */
    public static final int m47720getAlphaimpl(long j) {
        return android.graphics.Color.alpha(m47722getColorIntimpl(j));
    }

    /* renamed from: getRed-impl  reason: not valid java name */
    public static final int m47724getRedimpl(long j) {
        return android.graphics.Color.red(m47722getColorIntimpl(j));
    }

    /* renamed from: getGreen-impl  reason: not valid java name */
    public static final int m47723getGreenimpl(long j) {
        return android.graphics.Color.green(m47722getColorIntimpl(j));
    }

    /* renamed from: getBlue-impl  reason: not valid java name */
    public static final int m47721getBlueimpl(long j) {
        return android.graphics.Color.blue(m47722getColorIntimpl(j));
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final int m47713component1impl(long j) {
        return m47724getRedimpl(j);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final int m47714component2impl(long j) {
        return m47723getGreenimpl(j);
    }

    /* renamed from: component3-impl  reason: not valid java name */
    public static final int m47715component3impl(long j) {
        return m47721getBlueimpl(j);
    }

    /* renamed from: component4-impl  reason: not valid java name */
    public static final int m47716component4impl(long j) {
        return m47720getAlphaimpl(j);
    }

    /* renamed from: toHSV-impl  reason: not valid java name */
    public static final float[] m47728toHSVimpl(long j, float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "hsv");
        android.graphics.Color.colorToHSV(m47722getColorIntimpl(j), fArr);
        return fArr;
    }

    /* renamed from: toHSVArray-impl  reason: not valid java name */
    public static final float[] m47729toHSVArrayimpl(long j) {
        float[] fArr = new float[3];
        android.graphics.Color.colorToHSV(m47722getColorIntimpl(j), fArr);
        return fArr;
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final void m47726toComponentsimpl(long j, Function3<? super Integer, ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "action");
        function3.invoke(Integer.valueOf(m47713component1impl(j)), Integer.valueOf(m47714component2impl(j)), Integer.valueOf(m47715component3impl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final void m47727toComponentsimpl(long j, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        Intrinsics.checkParameterIsNotNull(function4, "action");
        function4.invoke(Integer.valueOf(m47713component1impl(j)), Integer.valueOf(m47714component2impl(j)), Integer.valueOf(m47715component3impl(j)), Integer.valueOf(m47716component4impl(j)));
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0012\u001a\u00020\u00102\b\b\u0003\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\"\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0003\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0018\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\u0019\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ,\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\u001b\u001a\u00020\u00142\b\b\u0001\u0010\u001c\u001a\u00020\u00142\b\b\u0001\u0010\u001d\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ6\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u001b\u001a\u00020\u00142\b\b\u0001\u0010\u001c\u001a\u00020\u00142\b\b\u0001\u0010\u001d\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010!R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, mo148868d2 = {"Lcom/didiglobal/travel/infra/value/Color$Companion;", "", "()V", "COLOR_NAME_ARRAY", "", "", "[Ljava/lang/String;", "COLOR_WEB_PATTERN", "Lkotlin/text/Regex;", "UNKNOWN", "Lcom/didiglobal/travel/infra/value/Color;", "getUNKNOWN", "()J", "J", "of", "h", "", "s", "v", "alpha", "", "(FFFI)J", "hsv", "", "([FI)J", "color", "(I)J", "red", "green", "blue", "(III)J", "(IIII)J", "colorString", "(Ljava/lang/String;)J", "lib-common_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: Color.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long getUNKNOWN() {
            return Color.f53995b;
        }

        /* renamed from: of */
        public final long mo131296of(String str) {
            boolean z;
            Intrinsics.checkParameterIsNotNull(str, "colorString");
            if (str.charAt(0) == '#') {
                z = Color.f53996c.matches(str);
            } else {
                String[] access$getCOLOR_NAME_ARRAY$cp = Color.f53997d;
                Locale locale = Locale.ROOT;
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
                String lowerCase = str.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                z = ArraysKt.contains((T[]) access$getCOLOR_NAME_ARRAY$cp, lowerCase);
            }
            if (!z) {
                return getUNKNOWN();
            }
            try {
                return Color.m47717constructorimpl((long) android.graphics.Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                return getUNKNOWN();
            }
        }

        /* renamed from: of */
        public final long mo131293of(int i) {
            return Color.m47717constructorimpl((long) i);
        }

        /* renamed from: of */
        public final long mo131294of(int i, int i2, int i3) {
            return Color.m47717constructorimpl((long) android.graphics.Color.rgb(i, i2, i3));
        }

        /* renamed from: of */
        public final long mo131295of(int i, int i2, int i3, int i4) {
            return Color.m47717constructorimpl((long) android.graphics.Color.argb(i, i2, i3, i4));
        }

        public static /* synthetic */ long of$default(Companion companion, float[] fArr, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 255;
            }
            return companion.mo131297of(fArr, i);
        }

        /* renamed from: of */
        public final long mo131297of(float[] fArr, int i) {
            Intrinsics.checkParameterIsNotNull(fArr, "hsv");
            if (fArr.length >= 3) {
                return Color.m47717constructorimpl((long) android.graphics.Color.HSVToColor(i, fArr));
            }
            throw new IllegalArgumentException("3 components required for hsv");
        }

        public static /* synthetic */ long of$default(Companion companion, float f, float f2, float f3, int i, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                i = 255;
            }
            return companion.mo131292of(f, f2, f3, i);
        }

        /* renamed from: of */
        public final long mo131292of(float f, float f2, float f3, int i) {
            return Color.m47717constructorimpl((long) android.graphics.Color.HSVToColor(i, new float[]{f, f2, f3}));
        }
    }
}
