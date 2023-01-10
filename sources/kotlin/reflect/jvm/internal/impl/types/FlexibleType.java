package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;

/* compiled from: KotlinType.kt */
public abstract class FlexibleType extends UnwrappedType implements FlexibleTypeMarker {

    /* renamed from: a */
    private final SimpleType f5817a;

    /* renamed from: b */
    private final SimpleType f5818b;

    public abstract SimpleType getDelegate();

    public abstract String render(DescriptorRenderer descriptorRenderer, DescriptorRendererOptions descriptorRendererOptions);

    public final SimpleType getLowerBound() {
        return this.f5817a;
    }

    public final SimpleType getUpperBound() {
        return this.f5818b;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlexibleType(SimpleType simpleType, SimpleType simpleType2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(simpleType, "lowerBound");
        Intrinsics.checkNotNullParameter(simpleType2, "upperBound");
        this.f5817a = simpleType;
        this.f5818b = simpleType2;
    }

    public Annotations getAnnotations() {
        return getDelegate().getAnnotations();
    }

    public TypeConstructor getConstructor() {
        return getDelegate().getConstructor();
    }

    public List<TypeProjection> getArguments() {
        return getDelegate().getArguments();
    }

    public boolean isMarkedNullable() {
        return getDelegate().isMarkedNullable();
    }

    public MemberScope getMemberScope() {
        return getDelegate().getMemberScope();
    }

    public String toString() {
        return DescriptorRenderer.DEBUG_TEXT.renderType(this);
    }
}
