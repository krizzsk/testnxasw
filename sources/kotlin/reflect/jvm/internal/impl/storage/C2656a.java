package kotlin.reflect.jvm.internal.impl.storage;

/* renamed from: kotlin.reflect.jvm.internal.impl.storage.a */
/* compiled from: SingleThreadValue */
class C2656a<T> {

    /* renamed from: a */
    private final T f5787a;

    /* renamed from: b */
    private final Thread f5788b = Thread.currentThread();

    C2656a(T t) {
        this.f5787a = t;
    }

    /* renamed from: a */
    public boolean mo26979a() {
        return this.f5788b == Thread.currentThread();
    }

    /* renamed from: b */
    public T mo26980b() {
        if (mo26979a()) {
            return this.f5787a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }
}
