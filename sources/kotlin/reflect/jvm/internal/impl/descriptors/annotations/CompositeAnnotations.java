package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.sequences.SequencesKt;

/* compiled from: Annotations.kt */
public final class CompositeAnnotations implements Annotations {

    /* renamed from: a */
    private final List<Annotations> f4914a;

    public CompositeAnnotations(List<? extends Annotations> list) {
        Intrinsics.checkNotNullParameter(list, "delegates");
        this.f4914a = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CompositeAnnotations(Annotations... annotationsArr) {
        this((List<? extends Annotations>) ArraysKt.toList((T[]) annotationsArr));
        Intrinsics.checkNotNullParameter(annotationsArr, "delegates");
    }

    public boolean isEmpty() {
        Iterable<Annotations> iterable = this.f4914a;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Annotations isEmpty : iterable) {
            if (!isEmpty.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean hasAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        for (Annotations hasAnnotation : CollectionsKt.asSequence(this.f4914a)) {
            if (hasAnnotation.hasAnnotation(fqName)) {
                return true;
            }
        }
        return false;
    }

    public AnnotationDescriptor findAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return (AnnotationDescriptor) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.f4914a), new CompositeAnnotations$findAnnotation$1(fqName)));
    }

    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt.flatMap(CollectionsKt.asSequence(this.f4914a), CompositeAnnotations$iterator$1.INSTANCE).iterator();
    }
}
