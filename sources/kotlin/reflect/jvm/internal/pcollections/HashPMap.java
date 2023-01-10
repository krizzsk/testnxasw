package kotlin.reflect.jvm.internal.pcollections;

public final class HashPMap<K, V> {

    /* renamed from: a */
    private static final HashPMap<Object, Object> f5919a = new HashPMap<>(C2693b.m5312a(), 0);

    /* renamed from: b */
    private final C2693b<ConsPStack<MapEntry<K, V>>> f5920b;

    /* renamed from: c */
    private final int f5921c;

    /* renamed from: b */
    private static /* synthetic */ void m5304b(int i) {
        Object[] objArr = new Object[2];
        objArr[0] = "kotlin/reflect/jvm/internal/pcollections/HashPMap";
        if (i != 1) {
            objArr[1] = "empty";
        } else {
            objArr[1] = "minus";
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", objArr));
    }

    public static <K, V> HashPMap<K, V> empty() {
        HashPMap<Object, Object> hashPMap = f5919a;
        if (hashPMap == null) {
            m5304b(0);
        }
        return hashPMap;
    }

    private HashPMap(C2693b<ConsPStack<MapEntry<K, V>>> bVar, int i) {
        this.f5920b = bVar;
        this.f5921c = i;
    }

    public int size() {
        return this.f5921c;
    }

    public boolean containsKey(Object obj) {
        return m5302a(m5303a(obj.hashCode()), obj) != -1;
    }

    public V get(Object obj) {
        ConsPStack<E> a = m5303a(obj.hashCode());
        while (a != null && a.mo27231b() > 0) {
            MapEntry mapEntry = (MapEntry) a.f5916a;
            if (mapEntry.key.equals(obj)) {
                return mapEntry.value;
            }
            a = a.f5917b;
        }
        return null;
    }

    public HashPMap<K, V> plus(K k, V v) {
        ConsPStack a = m5303a(k.hashCode());
        int b = a.mo27231b();
        int a2 = m5302a(a, k);
        if (a2 != -1) {
            a = a.mo27232b(a2);
        }
        ConsPStack a3 = a.mo27230a(new MapEntry(k, v));
        return new HashPMap<>(this.f5920b.mo27249a(k.hashCode(), a3), (this.f5921c - b) + a3.mo27231b());
    }

    public HashPMap<K, V> minus(Object obj) {
        ConsPStack a = m5303a(obj.hashCode());
        int a2 = m5302a(a, obj);
        if (a2 == -1) {
            return this;
        }
        ConsPStack b = a.mo27232b(a2);
        if (b.mo27231b() == 0) {
            return new HashPMap<>(this.f5920b.mo27250b(obj.hashCode()), this.f5921c - 1);
        }
        return new HashPMap<>(this.f5920b.mo27249a(obj.hashCode(), b), this.f5921c - 1);
    }

    /* renamed from: a */
    private ConsPStack<MapEntry<K, V>> m5303a(int i) {
        ConsPStack<MapEntry<K, V>> a = this.f5920b.mo27248a(i);
        return a == null ? ConsPStack.m5294a() : a;
    }

    /* renamed from: a */
    private static <K, V> int m5302a(ConsPStack<MapEntry<K, V>> consPStack, Object obj) {
        int i = 0;
        ConsPStack<E> consPStack2 = consPStack;
        while (consPStack2 != null && consPStack2.mo27231b() > 0) {
            if (((MapEntry) consPStack2.f5916a).key.equals(obj)) {
                return i;
            }
            i++;
            consPStack2 = consPStack2.f5917b;
        }
        return -1;
    }
}
