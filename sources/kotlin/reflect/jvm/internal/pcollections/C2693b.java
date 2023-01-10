package kotlin.reflect.jvm.internal.pcollections;

/* renamed from: kotlin.reflect.jvm.internal.pcollections.b */
/* compiled from: IntTreePMap */
final class C2693b<V> {

    /* renamed from: a */
    private static final C2693b<Object> f5928a = new C2693b<>(C2692a.f5922a);

    /* renamed from: b */
    private final C2692a<V> f5929b;

    /* renamed from: a */
    public static <V> C2693b<V> m5312a() {
        return f5928a;
    }

    private C2693b(C2692a<V> aVar) {
        this.f5929b = aVar;
    }

    /* renamed from: a */
    private C2693b<V> m5313a(C2692a<V> aVar) {
        if (aVar == this.f5929b) {
            return this;
        }
        return new C2693b<>(aVar);
    }

    /* renamed from: a */
    public V mo27248a(int i) {
        return this.f5929b.mo27245a((long) i);
    }

    /* renamed from: a */
    public C2693b<V> mo27249a(int i, V v) {
        return m5313a(this.f5929b.mo27246a((long) i, v));
    }

    /* renamed from: b */
    public C2693b<V> mo27250b(int i) {
        return m5313a(this.f5929b.mo27247b((long) i));
    }
}
