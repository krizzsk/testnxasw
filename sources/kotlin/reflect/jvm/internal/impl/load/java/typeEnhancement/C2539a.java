package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a */
/* compiled from: typeEnhancement.kt */
final class C2539a implements AnnotationDescriptor {

    /* renamed from: a */
    public static final C2539a f5328a = new C2539a();

    public String toString() {
        return "[EnhancedType]";
    }

    private C2539a() {
    }

    public FqName getFqName() {
        return AnnotationDescriptor.DefaultImpls.getFqName(this);
    }

    /* renamed from: a */
    private final Void m4893a() {
        throw new IllegalStateException("No methods should be called on this descriptor. Only its presence matters".toString());
    }

    public KotlinType getType() {
        m4893a();
        throw null;
    }

    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        m4893a();
        throw null;
    }

    public SourceElement getSource() {
        m4893a();
        throw null;
    }
}
