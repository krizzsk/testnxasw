package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: StubTypes.kt */
public abstract class AbstractStubType extends SimpleType {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final TypeConstructor f5791a;

    /* renamed from: b */
    private final boolean f5792b;

    /* renamed from: c */
    private final MemberScope f5793c;

    public abstract AbstractStubType materialize(boolean z);

    public AbstractStubType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public AbstractStubType(TypeConstructor typeConstructor, boolean z) {
        Intrinsics.checkNotNullParameter(typeConstructor, "originalTypeVariable");
        this.f5791a = typeConstructor;
        this.f5792b = z;
        MemberScope createErrorScope = ErrorUtils.createErrorScope(Intrinsics.stringPlus("Scope for stub type: ", typeConstructor));
        Intrinsics.checkNotNullExpressionValue(createErrorScope, "createErrorScope(\"Scope …: $originalTypeVariable\")");
        this.f5793c = createErrorScope;
    }

    public final TypeConstructor getOriginalTypeVariable() {
        return this.f5791a;
    }

    public boolean isMarkedNullable() {
        return this.f5792b;
    }

    public MemberScope getMemberScope() {
        return this.f5793c;
    }

    public List<TypeProjection> getArguments() {
        return CollectionsKt.emptyList();
    }

    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    public SimpleType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return this;
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        return z == isMarkedNullable() ? this : materialize(z);
    }

    /* compiled from: StubTypes.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
