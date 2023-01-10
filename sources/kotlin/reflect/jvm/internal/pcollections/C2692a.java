package kotlin.reflect.jvm.internal.pcollections;

/* renamed from: kotlin.reflect.jvm.internal.pcollections.a */
/* compiled from: IntTree */
final class C2692a<V> {

    /* renamed from: a */
    static final C2692a<Object> f5922a = new C2692a<>();

    /* renamed from: b */
    private final long f5923b;

    /* renamed from: c */
    private final V f5924c;

    /* renamed from: d */
    private final C2692a<V> f5925d;

    /* renamed from: e */
    private final C2692a<V> f5926e;

    /* renamed from: f */
    private final int f5927f;

    private C2692a() {
        this.f5927f = 0;
        this.f5923b = 0;
        this.f5924c = null;
        this.f5925d = null;
        this.f5926e = null;
    }

    private C2692a(long j, V v, C2692a<V> aVar, C2692a<V> aVar2) {
        this.f5923b = j;
        this.f5924c = v;
        this.f5925d = aVar;
        this.f5926e = aVar2;
        this.f5927f = aVar.f5927f + 1 + aVar2.f5927f;
    }

    /* renamed from: c */
    private C2692a<V> m5308c(long j) {
        if (this.f5927f == 0 || j == this.f5923b) {
            return this;
        }
        return new C2692a(j, this.f5924c, this.f5925d, this.f5926e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public V mo27245a(long j) {
        if (this.f5927f == 0) {
            return null;
        }
        long j2 = this.f5923b;
        if (j < j2) {
            return this.f5925d.mo27245a(j - j2);
        }
        if (j > j2) {
            return this.f5926e.mo27245a(j - j2);
        }
        return this.f5924c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2692a<V> mo27246a(long j, V v) {
        if (this.f5927f == 0) {
            return new C2692a(j, v, this, this);
        }
        long j2 = this.f5923b;
        if (j < j2) {
            return m5307a(this.f5925d.mo27246a(j - j2, v), this.f5926e);
        }
        if (j > j2) {
            return m5307a(this.f5925d, this.f5926e.mo27246a(j - j2, v));
        }
        if (v == this.f5924c) {
            return this;
        }
        return new C2692a(j, v, this.f5925d, this.f5926e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C2692a<V> mo27247b(long j) {
        if (this.f5927f == 0) {
            return this;
        }
        long j2 = this.f5923b;
        if (j < j2) {
            return m5307a(this.f5925d.mo27247b(j - j2), this.f5926e);
        }
        if (j > j2) {
            return m5307a(this.f5925d, this.f5926e.mo27247b(j - j2));
        }
        C2692a<V> aVar = this.f5925d;
        if (aVar.f5927f == 0) {
            C2692a<V> aVar2 = this.f5926e;
            return aVar2.m5308c(aVar2.f5923b + j2);
        }
        C2692a<V> aVar3 = this.f5926e;
        if (aVar3.f5927f == 0) {
            return aVar.m5308c(aVar.f5923b + j2);
        }
        long a = aVar3.m5305a();
        long j3 = this.f5923b;
        long j4 = a + j3;
        V a2 = this.f5926e.mo27245a(j4 - j3);
        C2692a<V> b = this.f5926e.mo27247b(j4 - this.f5923b);
        C2692a<V> c = b.m5308c((b.f5923b + this.f5923b) - j4);
        C2692a<V> aVar4 = this.f5925d;
        return m5306a(j4, a2, aVar4.m5308c((aVar4.f5923b + this.f5923b) - j4), c);
    }

    /* renamed from: a */
    private long m5305a() {
        C2692a<V> aVar = this.f5925d;
        if (aVar.f5927f == 0) {
            return this.f5923b;
        }
        return aVar.m5305a() + this.f5923b;
    }

    /* renamed from: a */
    private C2692a<V> m5307a(C2692a<V> aVar, C2692a<V> aVar2) {
        if (aVar == this.f5925d && aVar2 == this.f5926e) {
            return this;
        }
        return m5306a(this.f5923b, this.f5924c, aVar, aVar2);
    }

    /* renamed from: a */
    private static <V> C2692a<V> m5306a(long j, V v, C2692a<V> aVar, C2692a<V> aVar2) {
        C2692a<V> aVar3 = aVar;
        int i = aVar3.f5927f;
        int i2 = aVar2.f5927f;
        if (i + i2 > 1) {
            if (i >= i2 * 5) {
                C2692a<V> aVar4 = aVar3.f5925d;
                C2692a<V> aVar5 = aVar3.f5926e;
                if (aVar5.f5927f < aVar4.f5927f * 2) {
                    long j2 = aVar3.f5923b + j;
                    V v2 = aVar3.f5924c;
                    long j3 = aVar3.f5923b;
                    return new C2692a(j2, v2, aVar4, new C2692a(-j3, v, aVar5.m5308c(aVar5.f5923b + j3), aVar2));
                }
                C2692a<V> aVar6 = aVar5.f5925d;
                C2692a<V> aVar7 = aVar5.f5926e;
                long j4 = aVar5.f5923b + aVar3.f5923b + j;
                V v3 = aVar5.f5924c;
                long j5 = aVar5.f5923b;
                V v4 = v3;
                C2692a aVar8 = new C2692a(-j5, aVar3.f5924c, aVar4, aVar6.m5308c(aVar6.f5923b + j5));
                long j6 = aVar3.f5923b;
                long j7 = aVar5.f5923b;
                return new C2692a(j4, v4, aVar8, new C2692a((-j6) - j7, v, aVar7.m5308c(aVar7.f5923b + j7 + j6), aVar2));
            }
            C2692a<V> aVar9 = aVar2;
            if (i2 >= i * 5) {
                C2692a<V> aVar10 = aVar9.f5925d;
                C2692a<V> aVar11 = aVar9.f5926e;
                if (aVar10.f5927f < aVar11.f5927f * 2) {
                    long j8 = aVar9.f5923b + j;
                    V v5 = aVar9.f5924c;
                    long j9 = aVar9.f5923b;
                    return new C2692a(j8, v5, new C2692a(-j9, v, aVar, aVar10.m5308c(aVar10.f5923b + j9)), aVar11);
                }
                C2692a<V> aVar12 = aVar10.f5925d;
                C2692a<V> aVar13 = aVar10.f5926e;
                long j10 = aVar10.f5923b + aVar9.f5923b + j;
                V v6 = aVar10.f5924c;
                long j11 = aVar9.f5923b;
                long j12 = j10;
                long j13 = aVar10.f5923b;
                C2692a aVar14 = new C2692a((-j11) - j13, v, aVar, aVar12.m5308c(aVar12.f5923b + j13 + j11));
                long j14 = aVar10.f5923b;
                V v7 = aVar9.f5924c;
                C2692a<V> aVar15 = aVar13;
                return new C2692a(j12, v6, aVar14, new C2692a(-j14, v7, aVar15.m5308c(aVar15.f5923b + j14), aVar11));
            }
        }
        return new C2692a(j, v, aVar, aVar2);
    }
}
