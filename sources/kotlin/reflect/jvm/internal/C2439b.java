package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004¨\u0006\u0017"}, mo148868d2 = {"Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "identityHashCode", "", "getIdentityHashCode", "()I", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "temporaryStrongRef", "getTemporaryStrongRef", "()Ljava/lang/ClassLoader;", "setTemporaryStrongRef", "equals", "", "other", "hashCode", "toString", "", "kotlin-reflection"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.reflect.jvm.internal.b */
/* compiled from: moduleByClassLoader.kt */
final class C2439b {

    /* renamed from: a */
    private final WeakReference<ClassLoader> f4781a;

    /* renamed from: b */
    private final int f4782b;

    /* renamed from: c */
    private ClassLoader f4783c;

    public C2439b(ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        this.f4781a = new WeakReference<>(classLoader);
        this.f4782b = System.identityHashCode(classLoader);
        this.f4783c = classLoader;
    }

    /* renamed from: a */
    public final void mo24253a(ClassLoader classLoader) {
        this.f4783c = classLoader;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C2439b) && ((ClassLoader) this.f4781a.get()) == ((ClassLoader) ((C2439b) obj).f4781a.get());
    }

    public int hashCode() {
        return this.f4782b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r0.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r1 = this;
            java.lang.ref.WeakReference<java.lang.ClassLoader> r0 = r1.f4781a
            java.lang.Object r0 = r0.get()
            java.lang.ClassLoader r0 = (java.lang.ClassLoader) r0
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            java.lang.String r0 = "<null>"
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.C2439b.toString():java.lang.String");
    }
}
