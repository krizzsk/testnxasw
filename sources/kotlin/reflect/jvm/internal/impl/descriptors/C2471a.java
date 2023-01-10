package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.a */
/* compiled from: typeParameterUtils.kt */
final class C2471a implements TypeParameterDescriptor {

    /* renamed from: a */
    private final TypeParameterDescriptor f4898a;

    /* renamed from: b */
    private final DeclarationDescriptor f4899b;

    /* renamed from: c */
    private final int f4900c;

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return this.f4898a.accept(declarationDescriptorVisitor, d);
    }

    public Annotations getAnnotations() {
        return this.f4898a.getAnnotations();
    }

    public SimpleType getDefaultType() {
        return this.f4898a.getDefaultType();
    }

    public Name getName() {
        return this.f4898a.getName();
    }

    public SourceElement getSource() {
        return this.f4898a.getSource();
    }

    public StorageManager getStorageManager() {
        return this.f4898a.getStorageManager();
    }

    public TypeConstructor getTypeConstructor() {
        return this.f4898a.getTypeConstructor();
    }

    public List<KotlinType> getUpperBounds() {
        return this.f4898a.getUpperBounds();
    }

    public Variance getVariance() {
        return this.f4898a.getVariance();
    }

    public boolean isCapturedFromOuterDeclaration() {
        return true;
    }

    public boolean isReified() {
        return this.f4898a.isReified();
    }

    public C2471a(TypeParameterDescriptor typeParameterDescriptor, DeclarationDescriptor declarationDescriptor, int i) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "originalDescriptor");
        Intrinsics.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        this.f4898a = typeParameterDescriptor;
        this.f4899b = declarationDescriptor;
        this.f4900c = i;
    }

    public TypeParameterDescriptor getOriginal() {
        TypeParameterDescriptor original = this.f4898a.getOriginal();
        Intrinsics.checkNotNullExpressionValue(original, "originalDescriptor.original");
        return original;
    }

    public DeclarationDescriptor getContainingDeclaration() {
        return this.f4899b;
    }

    public int getIndex() {
        return this.f4900c + this.f4898a.getIndex();
    }

    public String toString() {
        return this.f4898a + "[inner-copy]";
    }
}
