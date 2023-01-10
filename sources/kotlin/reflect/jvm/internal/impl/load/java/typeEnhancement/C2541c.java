package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.osgi.framework.VersionRange;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.c */
/* compiled from: typeEnhancement.kt */
final class C2541c<T> {

    /* renamed from: a */
    private final T f5330a;

    /* renamed from: b */
    private final Annotations f5331b;

    /* renamed from: a */
    public final T mo25244a() {
        return this.f5330a;
    }

    /* renamed from: b */
    public final Annotations mo25245b() {
        return this.f5331b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2541c)) {
            return false;
        }
        C2541c cVar = (C2541c) obj;
        return Intrinsics.areEqual((Object) this.f5330a, (Object) cVar.f5330a) && Intrinsics.areEqual((Object) this.f5331b, (Object) cVar.f5331b);
    }

    public int hashCode() {
        T t = this.f5330a;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        Annotations annotations = this.f5331b;
        if (annotations != null) {
            i = annotations.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "EnhancementResult(result=" + this.f5330a + ", enhancementAnnotations=" + this.f5331b + VersionRange.RIGHT_OPEN;
    }

    public C2541c(T t, Annotations annotations) {
        this.f5330a = t;
        this.f5331b = annotations;
    }
}
