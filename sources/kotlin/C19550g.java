package kotlin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0001H\n\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0001H\b\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\f\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\f\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\r\u0010\u0010\u001a\u00020\u0011*\u00020\u0001H\b\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\rH\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0016H\b\u001a\r\u0010\u0017\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f¨\u0006\u0019"}, mo148868d2 = {"and", "Ljava/math/BigInteger;", "other", "dec", "div", "inc", "inv", "minus", "or", "plus", "rem", "shl", "n", "", "shr", "times", "toBigDecimal", "Ljava/math/BigDecimal;", "scale", "mathContext", "Ljava/math/MathContext;", "toBigInteger", "", "unaryMinus", "xor", "kotlin-stdlib"}, mo148869k = 5, mo148870mv = {1, 5, 1}, mo148872xi = 1, mo148873xs = "kotlin/NumbersKt")
/* renamed from: kotlin.g */
/* compiled from: BigIntegers.kt */
class C19550g extends C19549f {
    /* renamed from: a */
    private static final BigInteger m41635a(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "$this$plus");
        BigInteger add = bigInteger.add(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
        return add;
    }

    /* renamed from: b */
    private static final BigInteger m41638b(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "$this$minus");
        BigInteger subtract = bigInteger.subtract(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(other)");
        return subtract;
    }

    /* renamed from: c */
    private static final BigInteger m41640c(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "$this$times");
        BigInteger multiply = bigInteger.multiply(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(multiply, "this.multiply(other)");
        return multiply;
    }

    /* renamed from: d */
    private static final BigInteger m41642d(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "$this$div");
        BigInteger divide = bigInteger.divide(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(divide, "this.divide(other)");
        return divide;
    }

    /* renamed from: e */
    private static final BigInteger m41644e(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "$this$rem");
        BigInteger remainder = bigInteger.remainder(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(remainder, "this.remainder(other)");
        return remainder;
    }

    /* renamed from: a */
    private static final BigInteger m41633a(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "$this$unaryMinus");
        BigInteger negate = bigInteger.negate();
        Intrinsics.checkNotNullExpressionValue(negate, "this.negate()");
        return negate;
    }

    /* renamed from: b */
    private static final BigInteger m41636b(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "$this$inc");
        BigInteger add = bigInteger.add(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(BigInteger.ONE)");
        return add;
    }

    /* renamed from: c */
    private static final BigInteger m41639c(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "$this$dec");
        BigInteger subtract = bigInteger.subtract(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(BigInteger.ONE)");
        return subtract;
    }

    /* renamed from: d */
    private static final BigInteger m41641d(BigInteger bigInteger) {
        BigInteger not = bigInteger.not();
        Intrinsics.checkNotNullExpressionValue(not, "this.not()");
        return not;
    }

    /* renamed from: f */
    private static final BigInteger m41645f(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger and = bigInteger.and(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(and, "this.and(other)");
        return and;
    }

    /* renamed from: g */
    private static final BigInteger m41646g(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger or = bigInteger.or(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(or, "this.or(other)");
        return or;
    }

    /* renamed from: h */
    private static final BigInteger m41647h(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger xor = bigInteger.xor(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(xor, "this.xor(other)");
        return xor;
    }

    /* renamed from: a */
    private static final BigInteger m41634a(BigInteger bigInteger, int i) {
        BigInteger shiftLeft = bigInteger.shiftLeft(i);
        Intrinsics.checkNotNullExpressionValue(shiftLeft, "this.shiftLeft(n)");
        return shiftLeft;
    }

    /* renamed from: b */
    private static final BigInteger m41637b(BigInteger bigInteger, int i) {
        BigInteger shiftRight = bigInteger.shiftRight(i);
        Intrinsics.checkNotNullExpressionValue(shiftRight, "this.shiftRight(n)");
        return shiftRight;
    }

    /* renamed from: a */
    private static final BigInteger m41631a(int i) {
        BigInteger valueOf = BigInteger.valueOf((long) i);
        Intrinsics.checkNotNullExpressionValue(valueOf, "BigInteger.valueOf(this.toLong())");
        return valueOf;
    }

    /* renamed from: a */
    private static final BigInteger m41632a(long j) {
        BigInteger valueOf = BigInteger.valueOf(j);
        Intrinsics.checkNotNullExpressionValue(valueOf, "BigInteger.valueOf(this)");
        return valueOf;
    }

    /* renamed from: e */
    private static final BigDecimal m41643e(BigInteger bigInteger) {
        return new BigDecimal(bigInteger);
    }

    /* renamed from: a */
    static /* synthetic */ BigDecimal m41630a(BigInteger bigInteger, int i, MathContext mathContext, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            Intrinsics.checkNotNullExpressionValue(mathContext, "MathContext.UNLIMITED");
        }
        return new BigDecimal(bigInteger, i, mathContext);
    }

    /* renamed from: a */
    private static final BigDecimal m41629a(BigInteger bigInteger, int i, MathContext mathContext) {
        return new BigDecimal(bigInteger, i, mathContext);
    }
}
