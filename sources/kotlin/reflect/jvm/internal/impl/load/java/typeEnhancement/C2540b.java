package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.b */
/* compiled from: typeEnhancement.kt */
final class C2540b implements Annotations {

    /* renamed from: a */
    private final FqName f5329a;

    public boolean isEmpty() {
        return false;
    }

    public C2540b(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqNameToMatch");
        this.f5329a = fqName;
    }

    public boolean hasAnnotation(FqName fqName) {
        return Annotations.DefaultImpls.hasAnnotation(this, fqName);
    }

    /* renamed from: a */
    public C2539a findAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (Intrinsics.areEqual((Object) fqName, (Object) this.f5329a)) {
            return C2539a.f5328a;
        }
        return null;
    }

    public Iterator<AnnotationDescriptor> iterator() {
        return CollectionsKt.emptyList().iterator();
    }
}
