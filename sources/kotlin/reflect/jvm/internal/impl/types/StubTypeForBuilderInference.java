package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.model.StubTypeMarker;

/* compiled from: StubTypes.kt */
public final class StubTypeForBuilderInference extends AbstractStubType implements StubTypeMarker {

    /* renamed from: a */
    private final TypeConstructor f5837a;

    /* renamed from: b */
    private final MemberScope f5838b;

    public TypeConstructor getConstructor() {
        return this.f5837a;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StubTypeForBuilderInference(TypeConstructor typeConstructor, boolean z, TypeConstructor typeConstructor2) {
        super(typeConstructor, z);
        Intrinsics.checkNotNullParameter(typeConstructor, "originalTypeVariable");
        Intrinsics.checkNotNullParameter(typeConstructor2, "constructor");
        this.f5837a = typeConstructor2;
        this.f5838b = typeConstructor.getBuiltIns().getAnyType().getMemberScope();
    }

    public AbstractStubType materialize(boolean z) {
        return new StubTypeForBuilderInference(getOriginalTypeVariable(), z, getConstructor());
    }

    public MemberScope getMemberScope() {
        return this.f5838b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stub (BI): ");
        sb.append(getOriginalTypeVariable());
        sb.append(isMarkedNullable() ? "?" : "");
        return sb.toString();
    }
}
