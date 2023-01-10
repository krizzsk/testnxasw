package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;

/* compiled from: ReflectAnnotationSource.kt */
public final class ReflectAnnotationSource implements SourceElement {

    /* renamed from: a */
    private final Annotation f5027a;

    public ReflectAnnotationSource(Annotation annotation) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        this.f5027a = annotation;
    }

    public final Annotation getAnnotation() {
        return this.f5027a;
    }

    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        Intrinsics.checkNotNullExpressionValue(sourceFile, "NO_SOURCE_FILE");
        return sourceFile;
    }
}
