package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: BuiltInAnnotationDescriptor.kt */
public final class BuiltInAnnotationDescriptor implements AnnotationDescriptor {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final KotlinBuiltIns f4910a;

    /* renamed from: b */
    private final FqName f4911b;

    /* renamed from: c */
    private final Map<Name, ConstantValue<?>> f4912c;

    /* renamed from: d */
    private final Lazy f4913d = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BuiltInAnnotationDescriptor$type$2(this));

    public BuiltInAnnotationDescriptor(KotlinBuiltIns kotlinBuiltIns, FqName fqName, Map<Name, ? extends ConstantValue<?>> map) {
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(map, "allValueArguments");
        this.f4910a = kotlinBuiltIns;
        this.f4911b = fqName;
        this.f4912c = map;
    }

    public FqName getFqName() {
        return this.f4911b;
    }

    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return this.f4912c;
    }

    public KotlinType getType() {
        Object value = this.f4913d.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-type>(...)");
        return (KotlinType) value;
    }

    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        return sourceElement;
    }
}
