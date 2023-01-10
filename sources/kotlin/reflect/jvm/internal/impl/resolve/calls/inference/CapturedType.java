package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import org.osgi.framework.VersionRange;

/* compiled from: CapturedTypeConstructor.kt */
public final class CapturedType extends SimpleType implements CapturedTypeMarker {

    /* renamed from: a */
    private final TypeProjection f5574a;

    /* renamed from: b */
    private final CapturedTypeConstructor f5575b;

    /* renamed from: c */
    private final boolean f5576c;

    /* renamed from: d */
    private final Annotations f5577d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CapturedType(TypeProjection typeProjection, CapturedTypeConstructor capturedTypeConstructor, boolean z, Annotations annotations, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeProjection, (i & 2) != 0 ? new CapturedTypeConstructorImpl(typeProjection) : capturedTypeConstructor, (i & 4) != 0 ? false : z, (i & 8) != 0 ? Annotations.Companion.getEMPTY() : annotations);
    }

    public CapturedTypeConstructor getConstructor() {
        return this.f5575b;
    }

    public boolean isMarkedNullable() {
        return this.f5576c;
    }

    public Annotations getAnnotations() {
        return this.f5577d;
    }

    public CapturedType(TypeProjection typeProjection, CapturedTypeConstructor capturedTypeConstructor, boolean z, Annotations annotations) {
        Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        Intrinsics.checkNotNullParameter(capturedTypeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        this.f5574a = typeProjection;
        this.f5575b = capturedTypeConstructor;
        this.f5576c = z;
        this.f5577d = annotations;
    }

    public List<TypeProjection> getArguments() {
        return CollectionsKt.emptyList();
    }

    public MemberScope getMemberScope() {
        MemberScope createErrorScope = ErrorUtils.createErrorScope("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        Intrinsics.checkNotNullExpressionValue(createErrorScope, "createErrorScope(\n      …solution\", true\n        )");
        return createErrorScope;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Captured(");
        sb.append(this.f5574a);
        sb.append(VersionRange.RIGHT_OPEN);
        sb.append(isMarkedNullable() ? "?" : "");
        return sb.toString();
    }

    public CapturedType makeNullableAsSpecified(boolean z) {
        if (z == isMarkedNullable()) {
            return this;
        }
        return new CapturedType(this.f5574a, getConstructor(), z, getAnnotations());
    }

    public CapturedType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return new CapturedType(this.f5574a, getConstructor(), isMarkedNullable(), annotations);
    }

    public CapturedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection refine = this.f5574a.refine(kotlinTypeRefiner);
        Intrinsics.checkNotNullExpressionValue(refine, "typeProjection.refine(kotlinTypeRefiner)");
        return new CapturedType(refine, getConstructor(), isMarkedNullable(), getAnnotations());
    }
}
