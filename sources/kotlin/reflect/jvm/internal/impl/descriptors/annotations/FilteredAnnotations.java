package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: Annotations.kt */
public final class FilteredAnnotations implements Annotations {

    /* renamed from: a */
    private final Annotations f4915a;

    /* renamed from: b */
    private final boolean f4916b;

    /* renamed from: c */
    private final Function1<FqName, Boolean> f4917c;

    public FilteredAnnotations(Annotations annotations, boolean z, Function1<? super FqName, Boolean> function1) {
        Intrinsics.checkNotNullParameter(annotations, "delegate");
        Intrinsics.checkNotNullParameter(function1, "fqNameFilter");
        this.f4915a = annotations;
        this.f4916b = z;
        this.f4917c = function1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FilteredAnnotations(Annotations annotations, Function1<? super FqName, Boolean> function1) {
        this(annotations, false, function1);
        Intrinsics.checkNotNullParameter(annotations, "delegate");
        Intrinsics.checkNotNullParameter(function1, "fqNameFilter");
    }

    public boolean hasAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.f4917c.invoke(fqName).booleanValue()) {
            return this.f4915a.hasAnnotation(fqName);
        }
        return false;
    }

    public AnnotationDescriptor findAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.f4917c.invoke(fqName).booleanValue()) {
            return this.f4915a.findAnnotation(fqName);
        }
        return null;
    }

    public Iterator<AnnotationDescriptor> iterator() {
        Collection arrayList = new ArrayList();
        for (Object next : this.f4915a) {
            if (m4708a((AnnotationDescriptor) next)) {
                arrayList.add(next);
            }
        }
        return ((List) arrayList).iterator();
    }

    public boolean isEmpty() {
        boolean z;
        Iterable iterable = this.f4915a;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (m4708a((AnnotationDescriptor) it.next())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        if (!this.f4916b) {
            return z;
        }
        if (!z) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private final boolean m4708a(AnnotationDescriptor annotationDescriptor) {
        FqName fqName = annotationDescriptor.getFqName();
        return fqName != null && this.f4917c.invoke(fqName).booleanValue();
    }
}
