package kotlin.ranges;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0013\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, mo148868d2 = {"Lkotlin/ranges/ClosedDoubleRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "(DD)V", "_endInclusive", "_start", "getEndInclusive", "()Ljava/lang/Double;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.ranges.a */
/* compiled from: Ranges.kt */
final class C2418a implements ClosedFloatingPointRange<Double> {

    /* renamed from: a */
    private final double f4703a;

    /* renamed from: b */
    private final double f4704b;

    /* renamed from: a */
    public boolean mo24054a(double d, double d2) {
        return d <= d2;
    }

    public C2418a(double d, double d2) {
        this.f4703a = d;
        this.f4704b = d2;
    }

    public /* synthetic */ boolean contains(Comparable comparable) {
        return mo24053a(((Number) comparable).doubleValue());
    }

    public /* synthetic */ boolean lessThanOrEquals(Comparable comparable, Comparable comparable2) {
        return mo24054a(((Number) comparable).doubleValue(), ((Number) comparable2).doubleValue());
    }

    /* renamed from: a */
    public Double getStart() {
        return Double.valueOf(this.f4703a);
    }

    /* renamed from: b */
    public Double getEndInclusive() {
        return Double.valueOf(this.f4704b);
    }

    /* renamed from: a */
    public boolean mo24053a(double d) {
        return d >= this.f4703a && d <= this.f4704b;
    }

    public boolean isEmpty() {
        return this.f4703a > this.f4704b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C2418a) {
            if (!isEmpty() || !((C2418a) obj).isEmpty()) {
                C2418a aVar = (C2418a) obj;
                if (!(this.f4703a == aVar.f4703a && this.f4704b == aVar.f4704b)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.f4703a).hashCode() * 31) + Double.valueOf(this.f4704b).hashCode();
    }

    public String toString() {
        return this.f4703a + ".." + this.f4704b;
    }
}
