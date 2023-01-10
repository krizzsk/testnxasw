package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.osgi.framework.VersionRange;

/* compiled from: IntegerValueTypeConstructor.kt */
public final class IntegerValueTypeConstructor implements TypeConstructor {

    /* renamed from: a */
    private final long f5590a;

    /* renamed from: b */
    private final ModuleDescriptor f5591b;

    /* renamed from: c */
    private final ArrayList<KotlinType> f5592c;

    public Void getDeclarationDescriptor() {
        return null;
    }

    public boolean isDenotable() {
        return false;
    }

    public Collection<KotlinType> getSupertypes() {
        return this.f5592c;
    }

    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    public KotlinBuiltIns getBuiltIns() {
        return this.f5591b.getBuiltIns();
    }

    public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public String toString() {
        return "IntegerValueType(" + this.f5590a + VersionRange.RIGHT_OPEN;
    }
}
