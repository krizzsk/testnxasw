package kotlin;

import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(mo148867d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\b\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\b\u001a\u0015\u0010\u0005\u001a\u00020\t*\u00020\n2\u0006\u0010\b\u001a\u00020\u0001H\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\u0006H\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\tH\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\u0006H\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\tH\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\u0006H\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\tH\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0015\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\u0015\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\u0014\u001a\u00020\u0002*\u00020\u0006H\b\u001a\r\u0010\u0014\u001a\u00020\u0001*\u00020\tH\b\u001a\r\u0010\u0015\u001a\u00020\u0002*\u00020\u0006H\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\tH\b¨\u0006\u0016"}, mo148868d2 = {"countLeadingZeroBits", "", "", "countOneBits", "countTrailingZeroBits", "fromBits", "", "Lkotlin/Double$Companion;", "bits", "", "Lkotlin/Float$Companion;", "isFinite", "", "isInfinite", "isNaN", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "toBits", "toRawBits", "kotlin-stdlib"}, mo148869k = 5, mo148870mv = {1, 5, 1}, mo148872xi = 1, mo148873xs = "kotlin/NumbersKt")
/* renamed from: kotlin.i */
/* compiled from: NumbersJVM.kt */
class C19552i extends C19551h {
    /* renamed from: a */
    private static final boolean m41690a(double d) {
        return Double.isNaN(d);
    }

    /* renamed from: a */
    private static final boolean m41691a(float f) {
        return Float.isNaN(f);
    }

    /* renamed from: b */
    private static final boolean m41696b(double d) {
        return Double.isInfinite(d);
    }

    /* renamed from: b */
    private static final boolean m41697b(float f) {
        return Float.isInfinite(f);
    }

    /* renamed from: c */
    private static final boolean m41700c(double d) {
        return !Double.isInfinite(d) && !Double.isNaN(d);
    }

    /* renamed from: c */
    private static final boolean m41701c(float f) {
        return !Float.isInfinite(f) && !Float.isNaN(f);
    }

    /* renamed from: d */
    private static final long m41704d(double d) {
        return Double.doubleToLongBits(d);
    }

    /* renamed from: e */
    private static final long m41708e(double d) {
        return Double.doubleToRawLongBits(d);
    }

    /* renamed from: a */
    private static final double m41684a(DoubleCompanionObject doubleCompanionObject, long j) {
        return Double.longBitsToDouble(j);
    }

    /* renamed from: d */
    private static final int m41702d(float f) {
        return Float.floatToIntBits(f);
    }

    /* renamed from: e */
    private static final int m41706e(float f) {
        return Float.floatToRawIntBits(f);
    }

    /* renamed from: a */
    private static final float m41685a(FloatCompanionObject floatCompanionObject, int i) {
        return Float.intBitsToFloat(i);
    }

    /* renamed from: a */
    private static final int m41686a(int i) {
        return Integer.bitCount(i);
    }

    /* renamed from: b */
    private static final int m41692b(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    /* renamed from: c */
    private static final int m41698c(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    /* renamed from: d */
    private static final int m41703d(int i) {
        return Integer.highestOneBit(i);
    }

    /* renamed from: e */
    private static final int m41707e(int i) {
        return Integer.lowestOneBit(i);
    }

    /* renamed from: a */
    private static final int m41687a(int i, int i2) {
        return Integer.rotateLeft(i, i2);
    }

    /* renamed from: b */
    private static final int m41693b(int i, int i2) {
        return Integer.rotateRight(i, i2);
    }

    /* renamed from: a */
    private static final int m41688a(long j) {
        return Long.bitCount(j);
    }

    /* renamed from: b */
    private static final int m41694b(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    /* renamed from: c */
    private static final int m41699c(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    /* renamed from: d */
    private static final long m41705d(long j) {
        return Long.highestOneBit(j);
    }

    /* renamed from: e */
    private static final long m41709e(long j) {
        return Long.lowestOneBit(j);
    }

    /* renamed from: a */
    private static final long m41689a(long j, int i) {
        return Long.rotateLeft(j, i);
    }

    /* renamed from: b */
    private static final long m41695b(long j, int i) {
        return Long.rotateRight(j, i);
    }
}
