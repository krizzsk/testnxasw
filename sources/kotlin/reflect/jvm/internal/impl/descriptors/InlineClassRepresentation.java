package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* compiled from: InlineClassRepresentation.kt */
public final class InlineClassRepresentation<Type extends SimpleTypeMarker> {

    /* renamed from: a */
    private final Name f4880a;

    /* renamed from: b */
    private final Type f4881b;

    public InlineClassRepresentation(Name name, Type type) {
        Intrinsics.checkNotNullParameter(name, "underlyingPropertyName");
        Intrinsics.checkNotNullParameter(type, "underlyingType");
        this.f4880a = name;
        this.f4881b = type;
    }

    public final Name getUnderlyingPropertyName() {
        return this.f4880a;
    }

    public final Type getUnderlyingType() {
        return this.f4881b;
    }
}
