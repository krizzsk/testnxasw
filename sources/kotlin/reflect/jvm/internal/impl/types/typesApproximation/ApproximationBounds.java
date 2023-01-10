package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

/* compiled from: CapturedTypeApproximation.kt */
public final class ApproximationBounds<T> {

    /* renamed from: a */
    private final T f5886a;

    /* renamed from: b */
    private final T f5887b;

    public final T component1() {
        return this.f5886a;
    }

    public final T component2() {
        return this.f5887b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApproximationBounds)) {
            return false;
        }
        ApproximationBounds approximationBounds = (ApproximationBounds) obj;
        return Intrinsics.areEqual((Object) this.f5886a, (Object) approximationBounds.f5886a) && Intrinsics.areEqual((Object) this.f5887b, (Object) approximationBounds.f5887b);
    }

    public int hashCode() {
        T t = this.f5886a;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.f5887b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ApproximationBounds(lower=" + this.f5886a + ", upper=" + this.f5887b + VersionRange.RIGHT_OPEN;
    }

    public ApproximationBounds(T t, T t2) {
        this.f5886a = t;
        this.f5887b = t2;
    }

    public final T getLower() {
        return this.f5886a;
    }

    public final T getUpper() {
        return this.f5887b;
    }
}
