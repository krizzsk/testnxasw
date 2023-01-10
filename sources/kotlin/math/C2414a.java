package kotlin.math;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo148868d2 = {"Lkotlin/math/Constants;", "", "()V", "LN2", "", "epsilon", "taylor_2_bound", "taylor_n_bound", "upper_taylor_2_bound", "upper_taylor_n_bound", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.math.a */
/* compiled from: MathJVM.kt */
final class C2414a {

    /* renamed from: a */
    public static final double f4657a = Math.log(2.0d);

    /* renamed from: b */
    public static final double f4658b;

    /* renamed from: c */
    public static final double f4659c;

    /* renamed from: d */
    public static final double f4660d;

    /* renamed from: e */
    public static final double f4661e;

    /* renamed from: f */
    public static final double f4662f;

    /* renamed from: g */
    public static final C2414a f4663g = new C2414a();

    static {
        double ulp = Math.ulp(1.0d);
        f4658b = ulp;
        double sqrt = Math.sqrt(ulp);
        f4659c = sqrt;
        double sqrt2 = Math.sqrt(sqrt);
        f4660d = sqrt2;
        double d = (double) 1;
        f4661e = d / f4659c;
        f4662f = d / sqrt2;
    }

    private C2414a() {
    }
}
