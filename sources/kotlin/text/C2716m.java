package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000Z\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0005H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\r\u0010\b\u001a\u00020\t*\u00020\u0003H\b\u001a\u0015\u0010\b\u001a\u00020\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\b\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u0003H\u0007\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\r\u0010\r\u001a\u00020\u000e*\u00020\u0003H\b\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\b\u001a\u000e\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007\u001a\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\r\u0010\u0012\u001a\u00020\u0013*\u00020\u0003H\b\u001a\u0014\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\u0003H\b¢\u0006\u0002\b\u0014\u001a\r\u0010\u0015\u001a\u00020\u0016*\u00020\u0003H\b\u001a\u0015\u0010\u0015\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\b\u001a\r\u0010\u0017\u001a\u00020\u0018*\u00020\u0003H\b\u001a\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0018*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001a\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0003H\b\u001a\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001c*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001e\u001a\r\u0010\u001f\u001a\u00020\u0010*\u00020\u0003H\b\u001a\u0015\u0010\u001f\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\b\u001a\r\u0010 \u001a\u00020!*\u00020\u0003H\b\u001a\u0015\u0010 \u001a\u00020!*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\b\u001a\r\u0010\"\u001a\u00020#*\u00020\u0003H\b\u001a\u0015\u0010\"\u001a\u00020#*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020!2\u0006\u0010\u000f\u001a\u00020\u0010H\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020#2\u0006\u0010\u000f\u001a\u00020\u0010H\b¨\u0006%"}, mo148868d2 = {"screenFloatValue", "T", "str", "", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "toBigInteger", "Ljava/math/BigInteger;", "radix", "", "toBigIntegerOrNull", "toBoolean", "", "toBooleanNullable", "toByte", "", "toDouble", "", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toFloat", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toInt", "toLong", "", "toShort", "", "toString", "kotlin-stdlib"}, mo148869k = 5, mo148870mv = {1, 5, 1}, mo148872xi = 1, mo148873xs = "kotlin/text/StringsKt")
/* renamed from: kotlin.text.m */
/* compiled from: StringNumberConversionsJVM.kt */
class C2716m extends C2715l {
    /* renamed from: a */
    private static final String m5456a(byte b, int i) {
        String num = Integer.toString(b, CharsKt.checkRadix(CharsKt.checkRadix(i)));
        Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    /* renamed from: a */
    private static final String m5459a(short s, int i) {
        String num = Integer.toString(s, CharsKt.checkRadix(CharsKt.checkRadix(i)));
        Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    /* renamed from: a */
    private static final String m5457a(int i, int i2) {
        String num = Integer.toString(i, CharsKt.checkRadix(i2));
        Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    /* renamed from: a */
    private static final String m5458a(long j, int i) {
        String l = Long.toString(j, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(l, "java.lang.Long.toString(this, checkRadix(radix))");
        return l;
    }

    /* renamed from: b */
    private static final boolean m5463b(String str) {
        return Boolean.parseBoolean(str);
    }

    /* renamed from: c */
    private static final byte m5464c(String str) {
        return Byte.parseByte(str);
    }

    /* renamed from: a */
    private static final byte m5454a(String str, int i) {
        return Byte.parseByte(str, CharsKt.checkRadix(i));
    }

    /* renamed from: d */
    private static final short m5467d(String str) {
        return Short.parseShort(str);
    }

    /* renamed from: b */
    private static final short m5462b(String str, int i) {
        return Short.parseShort(str, CharsKt.checkRadix(i));
    }

    /* renamed from: e */
    private static final int m5468e(String str) {
        return Integer.parseInt(str);
    }

    /* renamed from: c */
    private static final int m5465c(String str, int i) {
        return Integer.parseInt(str, CharsKt.checkRadix(i));
    }

    /* renamed from: f */
    private static final long m5470f(String str) {
        return Long.parseLong(str);
    }

    /* renamed from: d */
    private static final long m5466d(String str, int i) {
        return Long.parseLong(str, CharsKt.checkRadix(i));
    }

    /* renamed from: g */
    private static final float m5471g(String str) {
        return Float.parseFloat(str);
    }

    /* renamed from: h */
    private static final double m5472h(String str) {
        return Double.parseDouble(str);
    }

    /* renamed from: i */
    private static final BigInteger m5473i(String str) {
        return new BigInteger(str);
    }

    /* renamed from: e */
    private static final BigInteger m5469e(String str, int i) {
        return new BigInteger(str, CharsKt.checkRadix(i));
    }

    public static final BigInteger toBigIntegerOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$toBigIntegerOrNull");
        return StringsKt.toBigIntegerOrNull(str, 10);
    }

    public static final BigInteger toBigIntegerOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "$this$toBigIntegerOrNull");
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        if (length != 1) {
            if (str.charAt(0) == '-') {
                i2 = 1;
            }
            while (i2 < length) {
                if (CharsKt.digitOf(str.charAt(i2), i) < 0) {
                    return null;
                }
                i2++;
            }
        } else if (CharsKt.digitOf(str.charAt(0), i) < 0) {
            return null;
        }
        return new BigInteger(str, CharsKt.checkRadix(i));
    }

    /* renamed from: j */
    private static final BigDecimal m5474j(String str) {
        return new BigDecimal(str);
    }

    /* renamed from: a */
    private static final BigDecimal m5460a(String str, MathContext mathContext) {
        return new BigDecimal(str, mathContext);
    }

    /* renamed from: a */
    private static final <T> T m5455a(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (C2709f.f5988a.matches(str)) {
                return function1.invoke(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final Float toFloatOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$toFloatOrNull");
        try {
            if (C2709f.f5988a.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final Double toDoubleOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$toDoubleOrNull");
        try {
            if (C2709f.f5988a.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final BigDecimal toBigDecimalOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$toBigDecimalOrNull");
        try {
            if (C2709f.f5988a.matches(str)) {
                return new BigDecimal(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final BigDecimal toBigDecimalOrNull(String str, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, "$this$toBigDecimalOrNull");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        try {
            if (C2709f.f5988a.matches(str)) {
                return new BigDecimal(str, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
